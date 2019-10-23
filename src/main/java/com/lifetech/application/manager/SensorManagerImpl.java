package com.lifetech.application.manager;

import com.lifetech.application.dto.SensorDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.SensorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorManagerImpl implements SensorManager {

    private final OrikaBeanMapper orikaBeanMapper;

    private final SensorDAO sensorDAO;

    public SensorManagerImpl(OrikaBeanMapper orikaBeanMapper, SensorDAO sensorDAO) {
        this.orikaBeanMapper = orikaBeanMapper;
        this.sensorDAO = sensorDAO;
    }

    public List<SensorDTO> findAllSensors() {
        return orikaBeanMapper.mapAsList(sensorDAO.findAll(),SensorDTO.class);
    }
}
