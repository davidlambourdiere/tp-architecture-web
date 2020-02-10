package com.lifetech.application.manager;

import com.lifetech.application.dto.LightDTO;
import com.lifetech.application.dto.LightDetailDTO;
import com.lifetech.application.dto.LightHistoricDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.LightDAO;
import com.lifetech.domain.dao.LightHistoricDAO;
import com.lifetech.domain.model.Light;
import com.lifetech.domain.model.LightHistoric;
import com.lifetech.domain.model.StateEnum;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Service
public class LightManagerImpl implements LightManager {

    private final LightDAO lightDAO;

    private final LightHistoricDAO lightHistoricDAO;

    private final OrikaBeanMapper orikaBeanMapper;

    public LightManagerImpl(LightHistoricDAO lightHistoricDAO, LightDAO lightDAO, OrikaBeanMapper orikaBeanMapper) {
        this.lightHistoricDAO = lightHistoricDAO;
        this.lightDAO = lightDAO;
        this.orikaBeanMapper = orikaBeanMapper;
    }

    public List<LightDTO> findAllLight(){
        List<Light> lights = lightDAO.findAll();
        return orikaBeanMapper.mapAsList(lights, LightDTO.class);
    }

    public List<LightDTO> findLightByPerson(String id) {
        List<Light> lights = lightDAO.findAllByPersonId(Long. parseLong(id));
        return orikaBeanMapper.mapAsList(lights, LightDTO.class);
    }

    @Override
    public LightDTO findById(String id) {
        Light light = lightDAO.findById(Long.parseLong(id)).orElse(null);
        return orikaBeanMapper.map(light, LightDTO.class);
    }

    @Override
    public LightDTO findByRoom(String id) {
        return null;
    }

    @Override
    public LightDetailDTO findByHistoric(String id) {
        Light light = lightDAO.findById(Long.parseLong(id)).orElse(null);
        LightDTO lightDTO = orikaBeanMapper.map(light, LightDTO.class);
        List<LightHistoric> lightHistorics = lightHistoricDAO.findAllByLightId(Long.parseLong(id));
        List<LightHistoricDTO> lightHistoricDTOS = new ArrayList<>();
        LocalDate d = LocalDate.now().minusMonths(1);
        String percentageLastMonth = null;
        if (lightHistorics != null && !lightHistorics.isEmpty()) {
            int timeOn = 0;
            int timeOff = 0;
            for (LightHistoric lightHistoric : lightHistorics) {
                if ((Instant.ofEpochMilli(lightHistoric.getStartDate().getTime())
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate()).isAfter(d)) {
                    if (lightHistoric.getState().equals(StateEnum.ON)) {
                        timeOn = timeOn + (int) (lightHistoric.getEndingDate().getTime()/100000 - lightHistoric.getStartDate().getTime()/100000);
                    } else if (lightHistoric.getState().equals(StateEnum.OFF)) {
                        timeOff = timeOff + (int) (lightHistoric.getEndingDate().getTime()/100000 - lightHistoric.getStartDate().getTime()/100000);
                    }
                }
                LightHistoricDTO lightHistoricDTO = new LightHistoricDTO();
                lightHistoricDTO.setColor(lightHistoric.getColor());
                lightHistoricDTO.setEndingdate(lightHistoric.getEndingDate().toString());
                lightHistoricDTO.setStartdate(lightHistoric.getStartDate().toString());
                lightHistoricDTO.setState(lightHistoric.getState().toString());
                lightHistoricDTO.setBreakdownstatus(lightHistoric.getBreakdownstatus().toString());
                lightHistoricDTOS.add(lightHistoricDTO);
            }
            int totalTime = timeOn + timeOff;
            float percentageOnLastMonth = ((float)timeOn / (float)totalTime)*100;
            percentageLastMonth = String.valueOf(percentageOnLastMonth);
        }
        LightDetailDTO lightDetailDTO = new LightDetailDTO();
        lightDetailDTO.setPercentageOnLastMonth(percentageLastMonth);
        lightDetailDTO.setLightshistoric(lightHistoricDTOS);
        lightDetailDTO.setLight(lightDTO);

        return lightDetailDTO;
    }
}
