package com.lifetech.application.manager;

import com.lifetech.application.dto.*;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IOTManagerImpl implements IOTManager{

    private final ClockDAO clockDAO;

    private final HeaterDAO heaterDAO;

    private final LightDAO lightDAO;

    private final ShutterDAO shutterDAO;

    private final StrapDAO strapDAO;

    private final OrikaBeanMapper orikaBeanMapper;

    public IOTManagerImpl(ClockDAO clockDAO, HeaterDAO heaterDAO, LightDAO lightDAO, ShutterDAO shutterDAO, StrapDAO strapDAO, OrikaBeanMapper orikaBeanMapper) {
        this.clockDAO = clockDAO;
        this.heaterDAO = heaterDAO;
        this.lightDAO = lightDAO;
        this.shutterDAO = shutterDAO;
        this.strapDAO = strapDAO;
        this.orikaBeanMapper = orikaBeanMapper;
    }


    public IOTDTO findAllIOT() {
        List<ClockDTO> clocks= orikaBeanMapper.convertListDTO(clockDAO.findAll(), ClockDTO.class);
        List<HeaterDTO> heaters = orikaBeanMapper.convertListDTO(heaterDAO.findAll(), HeaterDTO.class);
        List<LightDTO> lights = orikaBeanMapper.convertListDTO(lightDAO.findAll(), LightDTO.class);
        List<ShutterDTO> shutters = orikaBeanMapper.convertListDTO(shutterDAO.findAll(), ShutterDTO.class);
        List<StrapDTO> straps = orikaBeanMapper.convertListDTO(strapDAO.findAll(), StrapDTO.class);
        IOTDTO iotToReturn = new IOTDTO();
        iotToReturn.setClocks(clocks);
        iotToReturn.setHeaters(heaters);
        iotToReturn.setLights(lights);
        iotToReturn.setShutters(shutters);
        iotToReturn.setStraps(straps);
        return iotToReturn;
    }
}
