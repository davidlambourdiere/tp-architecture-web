package com.lifetech.application.manager;

import com.lifetech.application.dto.*;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.HeaterDAO;
import com.lifetech.domain.model.Heater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeaterManagerImpl implements HeaterManager{

    private final HeaterDAO heaterDAO;

    private final OrikaBeanMapper orikaBeanMapper;

    public HeaterManagerImpl(HeaterDAO heaterDAO, OrikaBeanMapper orikaBeanMapper) {
        this.heaterDAO = heaterDAO;
        this.orikaBeanMapper = orikaBeanMapper;
    }

    @Override
    public HeaterDTO findById(String id) {
        Heater heater = heaterDAO.findById(Long.parseLong(id)).orElse(null);
        return orikaBeanMapper.map(heater, HeaterDTO.class);
    }


    @Override
    public List<HeaterDTO> findAllHeater() {
        List<Heater> heaters = heaterDAO.findAll();
        return orikaBeanMapper.mapAsList(heaters, HeaterDTO.class);
    }

    public List<HeaterDTO> findHeaterByPerson(String id) {
        List<Heater> heaters = heaterDAO.findAllByPersonId(Long. parseLong(id));
        return orikaBeanMapper.mapAsList(heaters, HeaterDTO.class);
    }


    @Override
    public HeaterDTO findByRoom(String id) {
        return null;
    }

    @Override
    public HeaterDetailDTO findByHistoric(String id) {
        Heater heater = heaterDAO.findById(Long.parseLong(id)).orElse(null);
        HeaterDTO heaterDTO = orikaBeanMapper.map(heater, HeaterDTO.class);
        HeaterDetailDTO heaterDetailDTO = new HeaterDetailDTO();
        heaterDetailDTO.setHeater(heaterDTO);
        return heaterDetailDTO;
    }


    @Override
    public HeaterDTO switchDownHeater(String id, HeaterDTO heaterDtoReceived) {
        // light trouvé par l'id reçu  p r front
        Heater heater = heaterDAO.findById(Long.parseLong(id)).orElse(null);
        // converti en DTO pour modifier
        HeaterDTO updatedHeaterDTO = orikaBeanMapper.map(heater, HeaterDTO.class);
        updatedHeaterDTO.setActualval(heaterDtoReceived.getActualval());
        Heater heatersaved = orikaBeanMapper.map(updatedHeaterDTO, Heater.class);
        System.out.println(heatersaved);
        return orikaBeanMapper.map(heaterDAO.save(heatersaved), HeaterDTO.class);
    }

    @Override
    public HeaterDTO updateHeater(String id, HeaterDTO heaterDtoReceived) {
        // light trouvé par l'id reçu  p r front
        Heater heater = heaterDAO.findById(Long.parseLong(id)).orElse(null);
        // converti en DTO pour modifier
        HeaterDTO updatedHeaterDTO = orikaBeanMapper.map(heater, HeaterDTO.class);
        updatedHeaterDTO.setState(heaterDtoReceived.getState());
        updatedHeaterDTO.setActualval(heaterDtoReceived.getActualval());
        Heater heatersaved = orikaBeanMapper.map(updatedHeaterDTO, Heater.class);
        System.out.println(heatersaved);
        return orikaBeanMapper.map(heaterDAO.save(heatersaved), HeaterDTO.class);
    }
}
