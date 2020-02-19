package com.lifetech.application.manager;

import com.lifetech.application.dto.ClockDTO;
import com.lifetech.application.dto.ClockDetailDTO;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        List<ClockHistoric> clockHistorics = clockHistoricDAO.findAllByClockId(Long.parseLong(id));
        LocalDate d = LocalDate.now().minusMonths(1);
        String percentageLastMonth = null;
        if (clockHistorics != null && !clockHistorics.isEmpty()) {
            int timeOn = 0;
            int timeOff = 0;
            for (ClockHistoric clockHistoric : clockHistorics) {
                if ((Instant.ofEpochMilli(clockHistoric.getStartDate().getTime())
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate()).isAfter(d)) {
                    if (clockHistoric.getState().equals(StateEnum.ON)) {
                        timeOn = timeOn + (int) (clockHistoric.getEndingDate().getTime()/100000 - clockHistoric.getStartDate().getTime()/100000);
                    } else if (clockHistoric.getState().equals(StateEnum.OFF)) {
                        timeOff = timeOff + (int) (clockHistoric.getEndingDate().getTime()/100000 - clockHistoric.getStartDate().getTime()/100000);
                    }
                }
            }
            int totalTime = timeOn + timeOff;
            float percentageOnLastMonth = ((float)timeOn / (float)totalTime)*100;
            percentageLastMonth = String.valueOf(percentageOnLastMonth);
        }
        ClockDetailDTO clockDetailDTO = new ClockDetailDTO();
        clockDetailDTO.setPercentageOnLastMonth(percentageLastMonth);
        clockDetailDTO.setClock(clockDTO);
        return clockDetailDTO;
    }

    @Override
    public List<Clock> findAllClockMalFunctionning() {
        List<Clock> clocks = clockDAO.findAll();
        List<ClockHistoric> clockHistorics = clockHistoricDAO.findAll();
        List<Clock> clockToReturn = new ArrayList<>();
        for(Clock clock: clocks){
            List<ClockHistoric> historicToVerify= new ArrayList<>();
            for(ClockHistoric clockHistoric: clockHistorics){
                if(clockHistoric.getClockId().equals(clock.getId())){
                    historicToVerify.add(clockHistoric);
                }
            }
            for(ClockHistoric clockHistoric: historicToVerify){
                if(clockHistoric.getBreakdownstatus().equals(StatusEnum.BREAKDOWN)){
                    clockToReturn.add(clock);
                }
            }
        }
        return clockToReturn;
    }


}
