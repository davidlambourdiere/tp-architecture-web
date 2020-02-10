package com.lifetech.application.manager;

import com.lifetech.application.dto.*;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.HeaterDAO;
import com.lifetech.domain.dao.HeaterHistoricDAO;
import com.lifetech.domain.model.Heater;
import com.lifetech.domain.model.HeaterHistoric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        HeaterDetailDTO heaterDetailDTO = new HeaterDetailDTO();
        heaterDetailDTO.setHeater(heaterDTO);
        return heaterDetailDTO;
    }
}
