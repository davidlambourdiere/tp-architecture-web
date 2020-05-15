package com.lifetech.application.manager;

import com.lifetech.application.dto.LightDTO;
import com.lifetech.application.dto.LightDetailDTO;
import com.lifetech.application.dto.LightHistoricDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.LightDAO;
import com.lifetech.domain.dao.LightHistoricDAO;
import com.lifetech.domain.dao.RoomDAO;
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
public class LightManagerImpl implements LightManager {

    private static final Logger LOG = LoggerFactory.getLogger(LightManagerImpl.class);


    private final LightDAO lightDAO;

    private final LightHistoricDAO lightHistoricDAO;

    private final OrikaBeanMapper orikaBeanMapper;
    private final RoomDAO roomDao;

    public LightManagerImpl(LightHistoricDAO lightHistoricDAO, LightDAO lightDAO, RoomDAO roomDao, OrikaBeanMapper orikaBeanMapper) {
        this.lightHistoricDAO = lightHistoricDAO;
        this.lightDAO = lightDAO;
        this.orikaBeanMapper = orikaBeanMapper;
        this.roomDao = roomDao;
    }

    @Override
    public LightDTO updateLight(String id, LightDTO lightDtoReceived) {
        // light trouvé par l'id reçu  p r front
        Light light = lightDAO.findById(Long.parseLong(id)).orElse(null);
        // converti en DTO pour modifier
        LightDTO updatedLightDTO = orikaBeanMapper.map(light, LightDTO.class);

        updatedLightDTO.setColor(lightDtoReceived.getColor());
        updatedLightDTO.setState(lightDtoReceived.getState());
        updatedLightDTO.setPercentage(lightDtoReceived.getPercentage());
        Light lightsaved = orikaBeanMapper.map(updatedLightDTO, Light.class);
        System.out.println(lightsaved);
        return orikaBeanMapper.map(lightDAO.save(lightsaved), LightDTO.class);
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
    public List<LightDTO> findByRoom(String id) {
        Room room = roomDao.findById(Long.parseLong(id)).orElse(null);
        List<Light> lights = lightDAO.findByRoom(room);
        return orikaBeanMapper.mapAsList(lights, LightDTO.class);
    }




    @Override
    public LightDetailDTO findByHistoric(String id) {
        Light light = lightDAO.findById(Long.parseLong(id)).orElse(null);
        LightDTO lightDTO = orikaBeanMapper.map(light, LightDTO.class);
        List<LightHistoric> lightHistorics = lightHistoricDAO.findAllByLightId(Long.parseLong(id));
        List<LightHistoricDTO> lightHistoricDTOS = new ArrayList<>();
        String percentageLastMonth = null;
        boolean usedlastmonth = true;
        if (lightHistorics != null && !lightHistorics.isEmpty()) {
            for (LightHistoric lightHistoric : lightHistorics) {
                LightHistoricDTO lightHistoricDTO = new LightHistoricDTO();
                lightHistoricDTO.setColor(lightHistoric.getColor());
                lightHistoricDTO.setEndingdate(lightHistoric.getEndingDate().toString());
                lightHistoricDTO.setStartdate(lightHistoric.getStartDate().toString());
                lightHistoricDTO.setState(lightHistoric.getState().toString());
                lightHistoricDTO.setBreakdownstatus(lightHistoric.getBreakdownstatus().toString());
                lightHistoricDTOS.add(lightHistoricDTO);
            }
            float percentageOnLastMonth = calculateTimeOnLastMonth(lightHistorics);
            if((percentageOnLastMonth<15 || percentageOnLastMonth>70) && percentageOnLastMonth>0){
                usedlastmonth = false;
            } else {
                usedlastmonth = true;
            }
            percentageLastMonth = String.valueOf(percentageOnLastMonth);
        }
        LightDetailDTO lightDetailDTO = new LightDetailDTO();
        lightDetailDTO.setPercentageOnLastMonth(percentageLastMonth);
        lightDetailDTO.setUsedlastmonth(usedlastmonth);
        lightDetailDTO.setLightshistoric(lightHistoricDTOS);
        lightDetailDTO.setLight(lightDTO);
        return lightDetailDTO;
    }

    @Override
    public List<Light> findAllLightMalFunctionning() {
        List<Light> lights = lightDAO.findAll();
        List<LightHistoric> lightHistorics = lightHistoricDAO.findAll();
        Set<Light> distinctLightToReturn = new HashSet<>();
        for(Light light: lights){
            List<LightHistoric> historicToVerify= new ArrayList<>();
            for(LightHistoric lightHistoric: lightHistorics){
                if(lightHistoric.getLightId().equals(light.getId())){
                    historicToVerify.add(lightHistoric);
                }
            }
            for(LightHistoric lightHistoric: historicToVerify){
                if(lightHistoric.getBreakdownstatus().equals(StatusEnum.BREAKDOWN)){
                    distinctLightToReturn.add(light);
                }
            }
            float timeOnLastMonth = calculateTimeOnLastMonth(historicToVerify);
            if((timeOnLastMonth<15 || timeOnLastMonth>70) && timeOnLastMonth>0){
                distinctLightToReturn.add(light);
            }
        }
        List<Light> lightToReturn = new ArrayList<>();
        lightToReturn.addAll(distinctLightToReturn);
        return lightToReturn;
    }

    private float calculateTimeOnLastMonth(List<LightHistoric> lightHistorics) {
        LocalDate d = LocalDate.now().minusMonths(1); //Pick date one month ago
        float percentageOnLastMonth = 0;
        if (lightHistorics != null && !lightHistorics.isEmpty()) { //verify that historic for the iot exist
            int timeOn = 0;
            int timeOff = 0;
            for (LightHistoric lightHistoric : lightHistorics) {
                if ((Instant.ofEpochMilli(lightHistoric.getStartDate().getTime())
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate()).isAfter(d)) { //verify that we're just getting historic from the last month to today
                    //calculate time on and time off
                    if (lightHistoric.getState().equals(StateEnum.ON)) {
                        timeOn = timeOn + (int) (lightHistoric.getEndingDate().getTime() / 100000 - lightHistoric.getStartDate().getTime() / 100000);
                    } else if (lightHistoric.getState().equals(StateEnum.OFF)) {
                        timeOff = timeOff + (int) (lightHistoric.getEndingDate().getTime() / 100000 - lightHistoric.getStartDate().getTime() / 100000);
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
