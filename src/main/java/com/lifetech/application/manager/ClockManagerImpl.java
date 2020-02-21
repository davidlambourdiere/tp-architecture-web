package com.lifetech.application.manager;

import com.lifetech.application.dto.ClockDTO;
import com.lifetech.application.dto.ClockDetailDTO;
import com.lifetech.application.dto.ClockHistoricDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.ClockDAO;
import com.lifetech.domain.dao.ClockHistoricDAO;
import com.lifetech.domain.dao.RoomDAO;
import com.lifetech.domain.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Service
public class ClockManagerImpl implements ClockManager {

    private static final Logger LOG = LoggerFactory.getLogger(ClockManagerImpl.class);

    private final ClockDAO clockDAO;

    private final RoomDAO roomDao;

    private final ClockHistoricDAO clockHistoricDAO;

    private final OrikaBeanMapper orikaBeanMapper;

    public ClockManagerImpl(ClockHistoricDAO clockHistoricDAO, ClockDAO clockDAO, RoomDAO roomDao, OrikaBeanMapper orikaBeanMapper) {
        this.clockHistoricDAO = clockHistoricDAO;
        this.clockDAO = clockDAO;
        this.roomDao = roomDao;
        this.orikaBeanMapper = orikaBeanMapper;
    }


    @Override
    public ClockDTO findById(String id) {
        Clock clock = clockDAO.findById(Long.parseLong(id)).orElse(null);
        return orikaBeanMapper.map(clock, ClockDTO.class);
    }

    @Override
    public List<ClockDTO> findByRoom(String id) {
        Room room = roomDao.findById(Long.parseLong(id)).orElse(null);
        List<Clock> clocks = clockDAO.findByRoom(room);
        return orikaBeanMapper.mapAsList(clocks, ClockDTO.class);
    }

    @Override
    public ClockDetailDTO findByHistoric(String id) {
        Clock clock = clockDAO.findById(Long.parseLong(id)).orElse(null);
        ClockDTO clockDTO = orikaBeanMapper.map(clock, ClockDTO.class);
        List<ClockHistoric> clockHistorics = clockHistoricDAO.findAllByClockid(Long.parseLong(id));
        List<ClockHistoricDTO> clockHistoricDTOS = new ArrayList<>();
        boolean usedlastmonth = true;
        String percentageLastMonth = null;
        if (clockHistorics != null && !clockHistorics.isEmpty()) {
            for (ClockHistoric clockHistoric : clockHistorics) {
                ClockHistoricDTO clockHistoricDTO = new ClockHistoricDTO();
                clockHistoricDTO.setEndingdate(clockHistoric.getEndingDate().toString());
                clockHistoricDTO.setStartdate(clockHistoric.getStartDate().toString());
                clockHistoricDTO.setState(clockHistoric.getState().toString());
                clockHistoricDTO.setBreakdownstatus(clockHistoric.getBreakdownstatus().toString());
                clockHistoricDTOS.add(clockHistoricDTO);
            }
            float percentageOnLastMonth = (calculateTimeOnLastMonth(clockHistorics));
            if((percentageOnLastMonth<20 || percentageOnLastMonth>95) && percentageOnLastMonth>0){
                //TODO
                usedlastmonth = false;
            } else {
                usedlastmonth = true;
            }
            percentageLastMonth = String.valueOf(percentageOnLastMonth);
        }
        ClockDetailDTO clockDetailDTO = new ClockDetailDTO();
        clockDetailDTO.setClockhistorics(clockHistoricDTOS);
        clockDetailDTO.setUsedlastmonth(usedlastmonth);
        clockDetailDTO.setPercentageOnLastMonth(percentageLastMonth);
        clockDetailDTO.setClock(clockDTO);
        return clockDetailDTO;
    }

    @Override
    public List<Clock> findAllClockMalFunctionning() {
        List<Clock> clocks = clockDAO.findAll();
        List<ClockHistoric> clockHistorics = clockHistoricDAO.findAll();
        Set<Clock> distinctClockToReturn = new HashSet<>();
        for(Clock clock: clocks){
            List<ClockHistoric> historicToVerify= new ArrayList<>();
            for(ClockHistoric clockHistoric: clockHistorics){
                if(clockHistoric.getClockid().equals(clock.getId())){
                    historicToVerify.add(clockHistoric);
                }
            }
            //TODO changer la fonction met des doublons quand breakdown et le time rentrent dans les critères
            for(ClockHistoric clockHistoric: historicToVerify){
                if(clockHistoric.getBreakdownstatus().equals(StatusEnum.BREAKDOWN)){
                    distinctClockToReturn.add(clock);
                }
            }
            float timeOnLastMonth = calculateTimeOnLastMonth(historicToVerify);
            if((timeOnLastMonth<20 || timeOnLastMonth>95) && timeOnLastMonth>0){
                distinctClockToReturn.add(clock);
            }
        }
        List<Clock> clockToReturn = new ArrayList<>();
        clockToReturn.addAll(distinctClockToReturn);
        return clockToReturn;
    }

    private float calculateTimeOnLastMonth(List<ClockHistoric> clockHistorics) {
        LocalDate d = LocalDate.now().minusMonths(1); //Pick date one month ago
        float percentageOnLastMonth = 0;
        if (clockHistorics != null && !clockHistorics.isEmpty()) { //verify that historic for the iot exist
            int timeOn = 0;
            int timeOff = 0;
            for (ClockHistoric clockHistoric : clockHistorics) {
                if ((Instant.ofEpochMilli(clockHistoric.getStartDate().getTime())
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate()).isAfter(d)) { //verify that we're just getting historic from the last month to today
                    //calculate time on and time off
                    if (clockHistoric.getState().equals(StateEnum.ON) || clockHistoric.getState().equals(StateEnum.STANDBY)) {
                        timeOn = timeOn + (int) (clockHistoric.getEndingDate().getTime() / 100000 - clockHistoric.getStartDate().getTime() / 100000);
                    } else if (clockHistoric.getState().equals(StateEnum.OFF)) {
                        timeOff = timeOff + (int) (clockHistoric.getEndingDate().getTime() / 100000 - clockHistoric.getStartDate().getTime() / 100000);
                    }
                }
            }
            //calcultate time global when the heater was on last month (in percent)
            int totalTime = timeOn + timeOff;
            percentageOnLastMonth = ((float) timeOn / (float) totalTime) * 100;
        }
        return percentageOnLastMonth;
    }
}
