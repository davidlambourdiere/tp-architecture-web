package com.lifetech.application.manager;

import com.lifetech.application.dto.*;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.*;
import com.lifetech.domain.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IOTManagerImpl implements IOTManager{

    private static final Logger LOG = LoggerFactory.getLogger(IOTManagerImpl.class);

    private final ClockDAO clockDAO;

    private final HeaterDAO heaterDAO;

    private final LightDAO lightDAO;

    private final ShutterDAO shutterDAO;

    private final StrapDAO strapDAO;

    private final PersonDAO personDAO;

    private final ClockManager clockManager;

    private final LightManager lightManager;

    private final HeaterManager heaterManager;

    private final ShutterManager shutterManager;

    private final StrapManager strapManager;

    private final OrikaBeanMapper orikaBeanMapper;

    public IOTManagerImpl(StrapManager strapManager, ShutterManager shutterManager, HeaterManager heaterManager, LightManager lightManager, ClockManager clockManager, ClockDAO clockDAO, HeaterDAO heaterDAO, LightDAO lightDAO, ShutterDAO shutterDAO, StrapDAO strapDAO, OrikaBeanMapper orikaBeanMapper, PersonDAO personDAO) {
        this.clockDAO = clockDAO;
        this.heaterDAO = heaterDAO;
        this.lightDAO = lightDAO;
        this.shutterDAO = shutterDAO;
        this.strapDAO = strapDAO;
        this.orikaBeanMapper = orikaBeanMapper;
        this.personDAO = personDAO;
        this.clockManager= clockManager;
        this.lightManager = lightManager;
        this.heaterManager = heaterManager;
        this.shutterManager = shutterManager;
        this.strapManager = strapManager;
    }


    public IOTDTO findAllIOT() {
        LOG.info("IOTs will be load");
        List<ClockDTO> clocks= orikaBeanMapper.convertListDTO(clockDAO.findAll(), ClockDTO.class);
        List<HeaterDTO> heaters = orikaBeanMapper.convertListDTO(heaterDAO.findAll(), HeaterDTO.class);
        List<LightDTO> lights = orikaBeanMapper.convertListDTO(lightDAO.findAll(), LightDTO.class);
        List<ShutterDTO> shutters = orikaBeanMapper.convertListDTO(shutterDAO.findAll(), ShutterDTO.class);
        List<StrapDTO> straps = orikaBeanMapper.convertListDTO(strapDAO.findAll(), StrapDTO.class);
        LOG.info("IOTs loaded");
        IOTDTO iotToReturn = new IOTDTO();
        iotToReturn.setClocks(clocks);
        iotToReturn.setHeaters(heaters);
        iotToReturn.setLights(lights);
        iotToReturn.setShutters(shutters);
        iotToReturn.setStraps(straps);
        return iotToReturn;
    }

    public IOTDTO  findIOTByType(String type) {
        IOTDTO iotToReturn = new IOTDTO();
        switch(type){
            case "heater":
                List<HeaterDTO> heaters = orikaBeanMapper.convertListDTO(heaterDAO.findAll(), HeaterDTO.class);
                iotToReturn.setHeaters(heaters);
                break;
            case "light":
                List<LightDTO> lights = orikaBeanMapper.convertListDTO(lightDAO.findAll(), LightDTO.class);
                iotToReturn.setLights(lights);
                break;
            case "strap":
                List<StrapDTO> straps = orikaBeanMapper.convertListDTO(strapDAO.findAll(), StrapDTO.class);
                iotToReturn.setStraps(straps);
                break;
            case "shutter":
                List<ShutterDTO> shutters = orikaBeanMapper.convertListDTO(shutterDAO.findAll(), ShutterDTO.class);
                iotToReturn.setShutters(shutters);
                break;
            case "clock":
                List<ClockDTO> clocks = orikaBeanMapper.convertListDTO(clockDAO.findAll(), ClockDTO.class);
                iotToReturn.setClocks(clocks);
                break;
            default :
                return null;
        }
        return iotToReturn;
    }

    public IOTDTO findByPerson(String id) {
        IOTDTO iotToReturn = new IOTDTO();
        Person person = personDAO.findById(Long.parseLong(id)).orElse(null);
        List<ClockDTO> clocks= orikaBeanMapper.convertListDTO(clockDAO.findByPerson(person), ClockDTO.class);
        iotToReturn.setClocks(clocks);
        return iotToReturn;
    }

    @Override
    public IOTDTO findAllIOTWithMalfunctionning() {
        LOG.info("IOTs malfunctionning will be load");
        List<ClockDTO> clocks= orikaBeanMapper.convertListDTO(clockManager.findAllClockMalFunctionning(), ClockDTO.class);
        List<HeaterDTO> heaters = orikaBeanMapper.convertListDTO(heaterManager.findAllHeaterMalFunctionning(), HeaterDTO.class);
        List<LightDTO> lights = orikaBeanMapper.convertListDTO(lightManager.findAllLightMalFunctionning(), LightDTO.class);
        List<ShutterDTO> shutters = orikaBeanMapper.convertListDTO(shutterManager.findAllShutterMalFunctionning(), ShutterDTO.class);
        List<StrapDTO> straps = orikaBeanMapper.convertListDTO(strapManager.findAllStrapMalFunctionning(), StrapDTO.class);
        LOG.info("IOTs malfunctionning loaded");
        IOTDTO iotToReturn = new IOTDTO();
        iotToReturn.setClocks(clocks);
        iotToReturn.setHeaters(heaters);
        iotToReturn.setLights(lights);
        iotToReturn.setShutters(shutters);
        iotToReturn.setStraps(straps);
        return iotToReturn;
    }
}
