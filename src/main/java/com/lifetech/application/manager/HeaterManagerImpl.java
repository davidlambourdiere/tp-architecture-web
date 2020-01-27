package com.lifetech.application.manager;

import com.lifetech.application.dto.*;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.HeaterDAO;
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
}
