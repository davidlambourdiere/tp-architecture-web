package com.lifetech.application.manager;

import com.lifetech.application.dto.*;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.HeaterDAO;
import com.lifetech.domain.dao.HeaterHistoricDAO;
import com.lifetech.domain.model.Heater;
import com.lifetech.domain.model.HeaterHistoric;
import com.lifetech.domain.model.StateEnum;
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
        LocalDate d = LocalDate.now().minusMonths(1);
        String percentageLastMonth = null;
        boolean usedlastmonth = true;
        if (heaterHistorics != null && !heaterHistorics.isEmpty()) {
            int timeOn = 0;
            int timeOff = 0;
            for (HeaterHistoric heaterHistoric : heaterHistorics) {
                if ((Instant.ofEpochMilli(heaterHistoric.getStartdate().getTime())
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate()).isAfter(d)) {
                    if (heaterHistoric.getState().equals(StateEnum.ON)) {
                        timeOn = timeOn + (int) (heaterHistoric.getEndingdate().getTime()/100000 - heaterHistoric.getStartdate().getTime()/100000);
                    } else if (heaterHistoric.getState().equals(StateEnum.OFF)) {
                        timeOff = timeOff + (int) (heaterHistoric.getEndingdate().getTime()/100000 - heaterHistoric.getStartdate().getTime()/100000);
                    }
                }
                boolean temperaturetohot = false;
                // TODO faire une try catch pour l'erreur si la convertion ne marche pas
                if(Integer.parseInt(heaterHistoric.getTemperature())>30){
                    temperaturetohot = true;
                }
                HeaterHistoricDTO heaterHistoricDTO = new HeaterHistoricDTO();
                heaterHistoricDTO.setEndingdate(heaterHistoric.getEndingdate().toString());
                heaterHistoricDTO.setStartdate(heaterHistoric.getStartdate().toString());
                heaterHistoricDTO.setState(heaterHistoric.getState().toString());
                heaterHistoricDTO.setTemperature(heaterHistoric.getTemperature());
                heaterHistoricDTO.setBreakdownstatus(heaterHistoric.getBreakdownstatus().toString());
                heaterHistoricDTO.setTemperaturetohot(temperaturetohot);
                heaterHistoricDTOS.add(heaterHistoricDTO);
            }
            int totalTime = timeOn + timeOff;
            float percentageOnLastMonth = ((float)timeOn / (float)totalTime)*100;
            if(percentageOnLastMonth<30){
                usedlastmonth = false;
            } else {
                usedlastmonth = true;
            }
            percentageLastMonth = String.valueOf(percentageOnLastMonth);
        }
        HeaterDetailDTO heaterDetailDTO = new HeaterDetailDTO();
        heaterDetailDTO.setPercentageOnLastMonth(percentageLastMonth);
        heaterDetailDTO.setHeaterhistorics(heaterHistoricDTOS);
        heaterDetailDTO.setUsedlastmonth(usedlastmonth);
        heaterDetailDTO.setHeater(heaterDTO);
        return heaterDetailDTO;
    }
}
