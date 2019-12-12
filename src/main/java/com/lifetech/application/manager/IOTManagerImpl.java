package com.lifetech.application.manager;

import com.lifetech.application.dto.*;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.*;
import com.lifetech.domain.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IOTManagerImpl implements IOTManager{

    private final ClockDAO clockDAO;

    private final HeaterDAO heaterDAO;

    private final LightDAO lightDAO;

    private final ShutterDAO shutterDAO;

    private final StrapDAO strapDAO;

    private final PersonDAO personDAO;

    private final OrikaBeanMapper orikaBeanMapper;

    public IOTManagerImpl(ClockDAO clockDAO, HeaterDAO heaterDAO, LightDAO lightDAO, ShutterDAO shutterDAO, StrapDAO strapDAO, OrikaBeanMapper orikaBeanMapper, PersonDAO personDAO) {
        this.clockDAO = clockDAO;
        this.heaterDAO = heaterDAO;
        this.lightDAO = lightDAO;
        this.shutterDAO = shutterDAO;
        this.strapDAO = strapDAO;
        this.orikaBeanMapper = orikaBeanMapper;
        this.personDAO = personDAO;
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
}
