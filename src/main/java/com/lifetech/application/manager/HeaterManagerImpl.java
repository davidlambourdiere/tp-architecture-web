package com.lifetech.application.manager;

import com.lifetech.application.dto.*;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.HeaterDAO;
import com.lifetech.domain.dao.HeaterHistoricDAO;
import com.lifetech.domain.model.Heater;
import com.lifetech.domain.model.HeaterHistoric;
import com.lifetech.domain.model.StateEnum;
import com.lifetech.domain.model.StatusEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.StandardEmitterMBean;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Service
public class HeaterManagerImpl implements HeaterManager{

    private static final Logger LOG = LoggerFactory.getLogger(HeaterManagerImpl.class);


    private final HeaterDAO heaterDAO;

    private final HeaterHistoricDAO heaterHistoricDAO;

    private final OrikaBeanMapper orikaBeanMapper;

    public HeaterManagerImpl(HeaterHistoricDAO heaterHistoricDAO, HeaterDAO heaterDAO, OrikaBeanMapper orikaBeanMapper) {
        this.heaterHistoricDAO = heaterHistoricDAO;
        this.heaterDAO = heaterDAO;
        this.orikaBeanMapper = orikaBeanMapper;
    }

    @Override
    public HeaterDTO findById(String id) {
        return null;
    }

    @Override
    public HeaterDTO findAllHeater() {
        List<HeaterDTO> heaters = orikaBeanMapper.convertListDTO(heaterDAO.findAll(), HeaterDTO.class);
        HeaterDTO iotToReturn = new HeaterDTO();
        iotToReturn.setHeaters(heaters);
        return iotToReturn;
    }


    @Override
    public HeaterDTO findByRoom(String id) {
        return null;
    }

    @Override
    public HeaterDetailDTO findByHistoric(String id) {
        Heater heater = heaterDAO.findById(Long.parseLong(id)).orElse(null);
        HeaterDTO heaterDTO = orikaBeanMapper.map(heater, HeaterDTO.class);
        List<HeaterHistoric> heaterHistorics = heaterHistoricDAO.findAllByHeaterId(Long.parseLong(id));
        List<HeaterHistoricDTO> heaterHistoricDTOS = new ArrayList<>();
        LocalDate d = LocalDate.now().minusMonths(1); //Pick date one month ago
        String percentageLastMonth = null;
        boolean usedlastmonth = true;
        if (heaterHistorics != null && !heaterHistorics.isEmpty()) { //verify that historic for the iot exist
            int timeOn = 0;
            int timeOff = 0;
            for (HeaterHistoric heaterHistoric : heaterHistorics) {
                if ((Instant.ofEpochMilli(heaterHistoric.getStartdate().getTime())
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate()).isAfter(d)) { //verify that we're just getting historic from the last month to today
                    //calculate time on and time off
                    if (heaterHistoric.getState().equals(StateEnum.ON)) {
                        timeOn = timeOn + (int) (heaterHistoric.getEndingdate().getTime()/100000 - heaterHistoric.getStartdate().getTime()/100000);
                    } else if (heaterHistoric.getState().equals(StateEnum.OFF)) {
                        timeOff = timeOff + (int) (heaterHistoric.getEndingdate().getTime()/100000 - heaterHistoric.getStartdate().getTime()/100000);
                    }
                }
                boolean temperaturetohot = false;
                // TODO do try catch if convert don't work correctly
                if(Integer.parseInt(heaterHistoric.getTemperature())>30){
                    temperaturetohot = true;
                }
                //Create the object to return in the ui
                HeaterHistoricDTO heaterHistoricDTO = new HeaterHistoricDTO();
                heaterHistoricDTO.setEndingdate(heaterHistoric.getEndingdate().toString());
                heaterHistoricDTO.setStartdate(heaterHistoric.getStartdate().toString());
                heaterHistoricDTO.setState(heaterHistoric.getState().toString());
                heaterHistoricDTO.setTemperature(heaterHistoric.getTemperature());
                heaterHistoricDTO.setBreakdownstatus(heaterHistoric.getBreakdownstatus().toString());
                heaterHistoricDTO.setTemperaturetohot(temperaturetohot);
                heaterHistoricDTOS.add(heaterHistoricDTO);
            }
            //calcultate time global when the heater was on last month (in percent)
            int totalTime = timeOn + timeOff;
            float percentageOnLastMonth = ((float)timeOn / (float)totalTime)*100;
            if(percentageOnLastMonth<20 || percentageOnLastMonth>80){
                usedlastmonth = false;
            } else {
                usedlastmonth = true;
            }
            percentageLastMonth = String.valueOf(percentageOnLastMonth);
        }
        //create a "container" for all the data to return to the ui with the list of concerned historic
        HeaterDetailDTO heaterDetailDTO = new HeaterDetailDTO();
        heaterDetailDTO.setPercentageOnLastMonth(percentageLastMonth);
        heaterDetailDTO.setHeaterhistorics(heaterHistoricDTOS);
        heaterDetailDTO.setUsedlastmonth(usedlastmonth);
        heaterDetailDTO.setHeater(heaterDTO);
        return heaterDetailDTO;
    }

    @Override
    public List<Heater> findAllHeaterMalFunctionning() {
        List<Heater> heaters = heaterDAO.findAll();
        List<HeaterHistoric> heaterHistorics = heaterHistoricDAO.findAll();
        List<Heater> heaterToReturn = new ArrayList<>();
        for(Heater heater: heaters){
            List<HeaterHistoric> historicToVerify= new ArrayList<>();
            for(HeaterHistoric heaterHistoric: heaterHistorics){
                if(heaterHistoric.getHeaterId().equals(heater.getId())){
                    historicToVerify.add(heaterHistoric);
                }
            }
            for(HeaterHistoric heaterHistoric: historicToVerify){
                if(heaterHistoric.getBreakdownstatus().equals(StatusEnum.BREAKDOWN) ||
                        Integer.parseInt(heaterHistoric.getTemperature())>30){
                    heaterToReturn.add(heater);
                }
            }
        }
        return heaterToReturn;
    }
}
