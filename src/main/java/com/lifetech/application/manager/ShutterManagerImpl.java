package com.lifetech.application.manager;

import com.lifetech.application.dto.ShutterDTO;
import com.lifetech.application.dto.ShutterDetailDTO;
import com.lifetech.application.dto.ShutterHistoricDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.RoomDAO;
import com.lifetech.domain.dao.ShutterDAO;
import com.lifetech.domain.dao.ShutterHistoricDAO;
import com.lifetech.domain.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ShutterManagerImpl implements ShutterManager {

    private static final Logger LOG = LoggerFactory.getLogger(ShutterManagerImpl.class);

    private final ShutterDAO shutterDAO;

    private final ShutterHistoricDAO shutterHistoricDAO;

    private final RoomDAO roomDao;

    private final OrikaBeanMapper orikaBeanMapper;

    public ShutterManagerImpl(ShutterHistoricDAO shutterHistoricDAO, ShutterDAO shutterDAO, RoomDAO roomDao, OrikaBeanMapper orikaBeanMapper) {
        this.shutterHistoricDAO = shutterHistoricDAO;
        this.shutterDAO = shutterDAO;
        this.roomDao = roomDao;
        this.orikaBeanMapper = orikaBeanMapper;
    }
    @Override
    public List<ShutterDTO> findByRoom(String id) {
        Room room = roomDao.findById(Long.parseLong(id)).orElse(null);
        List<Shutter> shutters = shutterDAO.findByRoom(room);
        return orikaBeanMapper.mapAsList(shutters, ShutterDTO.class);
    }

    @Override
    public List<ShutterDTO> findAllShutter(){
        List<Shutter> shutters = shutterDAO.findAll();
        return orikaBeanMapper.mapAsList(shutters, ShutterDTO.class);
    }

    @Override
    public List<ShutterDTO> findShutterByPerson(String id) {
        List<Shutter> shutters = shutterDAO.findAllByPersonId(Long. parseLong(id));
        return orikaBeanMapper.mapAsList(shutters, ShutterDTO.class);
    }


    @Override
    public ShutterDTO findById(String id) {
        Shutter shutter = shutterDAO.findById(Long.parseLong(id)).orElse(null);
        return orikaBeanMapper.map(shutter, ShutterDTO.class);
    }

    @Override
    public ShutterDTO updateShutter(String id, ShutterDTO shutterDtoReceived) {

        Shutter shutter = shutterDAO.findById(Long.parseLong(id)).orElse(null);
        // converti en DTO pour modifier
        ShutterDTO updatedShutterDTO = orikaBeanMapper.map(shutter, ShutterDTO.class);

        updatedShutterDTO.setPercentage(shutterDtoReceived.getPercentage());
        Shutter shuttersaved = orikaBeanMapper.map(updatedShutterDTO, Shutter.class);
        System.out.println(shuttersaved);
        return orikaBeanMapper.map(shutterDAO.save(shuttersaved), ShutterDTO.class);
    }

    @Override
    public ShutterDetailDTO findByHistoric(String id) {
        Shutter shutter = shutterDAO.findById(Long.parseLong(id)).orElse(null);
        ShutterDTO shutterDTO = orikaBeanMapper.map(shutter, ShutterDTO.class);
        List<ShutterHistoric> shutterHistorics = shutterHistoricDAO.findAllByShutterid(Long.parseLong(id));
        List<ShutterHistoricDTO> shutterHistoricDTOS = new ArrayList<>();
        String percentageLastMonth = null;
        boolean usedlastmonth = true;
        if (shutterHistorics != null && !shutterHistorics.isEmpty()) {
            for (ShutterHistoric shutterHistoric : shutterHistorics) {
                ShutterHistoricDTO shutterHistoricDTO = new ShutterHistoricDTO();
                shutterHistoricDTO.setEndingdate(shutterHistoric.getEndingDate().toString());
                shutterHistoricDTO.setStartdate(shutterHistoric.getStartDate().toString());
                shutterHistoricDTO.setState(shutterHistoric.getState().toString());
                shutterHistoricDTO.setBreakdownstatus(shutterHistoric.getBreakdownstatus().toString());
                shutterHistoricDTOS.add(shutterHistoricDTO);
            }
            float percentageOnLastMonth = calculateTimeOnLastMonth(shutterHistorics);
            if((percentageOnLastMonth>80 || percentageOnLastMonth<0.5) && percentageOnLastMonth>0){
                usedlastmonth = false;
            } else {
                usedlastmonth = true;
            }


            percentageLastMonth = String.valueOf(percentageOnLastMonth);
        }
        ShutterDetailDTO shutterDetailDTO = new ShutterDetailDTO();
        shutterDetailDTO.setShutterhistorics(shutterHistoricDTOS);
        shutterDetailDTO.setUsedlastmonth(usedlastmonth);
        shutterDetailDTO.setPercentageOnLastMonth(percentageLastMonth);
        shutterDetailDTO.setShutter(shutterDTO);
        return shutterDetailDTO;
    }

    @Override
    public List<Shutter> findAllShutterMalFunctionning() {
        List<Shutter> shutters = shutterDAO.findAll();
        List<ShutterHistoric> shutterHistorics = shutterHistoricDAO.findAll();
        Set<Shutter> distinctShuttersToReturn = new HashSet<>();
        for(Shutter shutter: shutters){
            List<ShutterHistoric> historicToVerify= new ArrayList<>();
            for(ShutterHistoric shutterHistoric: shutterHistorics){
                if(shutterHistoric.getShutterid().equals(shutter.getId())){
                    historicToVerify.add(shutterHistoric);
                }
            }
            for(ShutterHistoric shutterHistoric: historicToVerify){
                if(shutterHistoric.getBreakdownstatus().equals(StatusEnum.BREAKDOWN)){
                    distinctShuttersToReturn.add(shutter);
                }
            }
            float timeOnLastMonth = calculateTimeOnLastMonth(historicToVerify);
            if((timeOnLastMonth<0.5 || timeOnLastMonth>80) && timeOnLastMonth>0){
                distinctShuttersToReturn.add(shutter);
            }
        }
        List<Shutter> shuttersToReturn = new ArrayList<>();
        shuttersToReturn.addAll(distinctShuttersToReturn);
        return shuttersToReturn;
    }

    private float calculateTimeOnLastMonth(List<ShutterHistoric> shutterHistorics) {
        LocalDate d = LocalDate.now().minusMonths(1); //Pick date one month ago
        float percentageOnLastMonth = 0;
        if (shutterHistorics != null && !shutterHistorics.isEmpty()) { //verify that historic for the iot exist
            int timeOn = 0;
            int timeOff = 0;
            for (ShutterHistoric shutterHistoric : shutterHistorics) {
                if ((Instant.ofEpochMilli(shutterHistoric.getStartDate().getTime())
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate()).isAfter(d)) { //verify that we're just getting historic from the last month to today
                    //calculate time on and time off
                    if ((shutterHistoric.getState().equals(StateEnum.ON)) ||shutterHistoric.getState().equals(StateEnum.STANDBY)) {
                        timeOn = timeOn + (int) (shutterHistoric.getEndingDate().getTime() / 100000 - shutterHistoric.getStartDate().getTime() / 100000);
                    } else if (shutterHistoric.getState().equals(StateEnum.OFF)) {
                        timeOff = timeOff + (int) (shutterHistoric.getEndingDate().getTime() / 100000 - shutterHistoric.getStartDate().getTime() / 100000);
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
