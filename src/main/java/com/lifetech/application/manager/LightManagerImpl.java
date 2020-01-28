package com.lifetech.application.manager;

import com.lifetech.application.dto.LightDTO;
import com.lifetech.application.dto.LightDetailDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.LightDAO;
import com.lifetech.domain.dao.LightHistoricDAO;
import com.lifetech.domain.model.Light;
import com.lifetech.domain.model.LightHistoric;
import org.springframework.stereotype.Service;

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
        LightDetailDTO lightDetailDTO = new LightDetailDTO();
        lightDetailDTO.setLight(lightDTO);
        return lightDetailDTO;
    }
}
