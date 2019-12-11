package com.lifetech.application.manager;

import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.*;
import com.lifetech.domain.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ActivityAnalysisManagerImpl implements ActivityAnalysisManager {

    private final ClockDAO clockDAO;
    private final HeaterDAO heaterDAO;
    private final LightDAO lightDAO;
    private final OrikaBeanMapper orikaBeanMapper;
    private final PersonDAO personDAO;
    private final ResidenceDAO residenceDAO;

    public ActivityAnalysisManagerImpl(ClockDAO clockDAO, HeaterDAO heaterDAO, LightDAO lightDAO, OrikaBeanMapper orikaBeanMapper, PersonDAO personDAO, ResidenceDAO residenceDAO) {
        this.clockDAO = clockDAO;
        this.heaterDAO = heaterDAO;
        this.lightDAO = lightDAO;
        this.orikaBeanMapper = orikaBeanMapper;
        this.personDAO = personDAO;
        this.residenceDAO = residenceDAO;
    }

    @Override
    public Map<String, Long> countIOTByPerson(long personId) {
        HashMap<String, Long> nIOT = new HashMap<String,Long>();
        Person person = personDAO.findById(personId).orElse(null);
        nIOT.put("nClock",clockDAO.countByPerson(person));
        nIOT.put("nHeater",heaterDAO.countByPerson(person));
        nIOT.put("nLight",lightDAO.countByPerson(person));
        return nIOT;
    }

    @Override
    public Map<String, Long> countIOTByResidence(long residenceId) {
        HashMap<String, Long> nIOT = new HashMap<String,Long>();
        /*Residence residence = residenceDAO.findById(residenceId).orElse(null);
        List<Clock> listClocks = clockDAO.findAllByResidence(residence);
        List<Heater> listHeaters = heaterDAO.findAllByResidence(residence);
        List<Light> listLights = lightDAO.findAllByResidence(residence);
        nIOT.put("nClock", (long) listClocks.size());
        nIOT.put("nHeater", (long) listHeaters.size());
        nIOT.put("nLight", (long) listLights.size());*/
        return nIOT;
    }

    @Override
    public Map<String, Long> countIOT() {
        Map<String, Long> nIOT = new HashMap<String,Long>();
        return nIOT;
    }
}
