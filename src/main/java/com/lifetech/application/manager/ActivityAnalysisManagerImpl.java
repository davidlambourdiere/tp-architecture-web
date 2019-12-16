package com.lifetech.application.manager;

import com.lifetech.application.dto.ActivityAnalaysisDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.*;
import com.lifetech.domain.model.*;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public ActivityAnalaysisDTO countIOTByPerson(String personLogin) {
        ActivityAnalaysisDTO activityAnalaysisDTO = new ActivityAnalaysisDTO();
        Person person = personDAO.findByLogin(personLogin).orElse(null);
        activityAnalaysisDTO.setPersonName(person.getFirstName() + " " + person.getLastName());
        activityAnalaysisDTO.setnClock(clockDAO.countByPerson(person));
        activityAnalaysisDTO.setnHeather(heaterDAO.countByPerson(person));
        activityAnalaysisDTO.setnLight(lightDAO.countByPerson(person));
        return activityAnalaysisDTO;
    }

    @Override
    public ActivityAnalaysisDTO countIOTByResidence(long residenceId) {
        ActivityAnalaysisDTO activityAnalaysisDTO = new ActivityAnalaysisDTO();
        Residence residence = residenceDAO.findById(residenceId).orElse(null);
        List<Person> personList = personDAO.findAllByResidenceId(residenceId);
        Long nClock, nHeather, nLight;
        nClock = nHeather = nLight = new Long(0);
        for (Person person : personList) {
            nClock += clockDAO.countByPerson(person);
            nHeather += heaterDAO.countByPerson(person);
            nLight += lightDAO.countByPerson(person);
        }

        activityAnalaysisDTO.setnClock(nClock);
        activityAnalaysisDTO.setnHeather(nHeather);
        activityAnalaysisDTO.setnLight(nLight);

        return activityAnalaysisDTO;
    }

    @Override
    public ActivityAnalaysisDTO countIOT() {
        ActivityAnalaysisDTO activityAnalaysisDTO = new ActivityAnalaysisDTO();
        activityAnalaysisDTO.setnClock(clockDAO.count());
        activityAnalaysisDTO.setnHeather(heaterDAO.count());
        activityAnalaysisDTO.setnLight(lightDAO.count());
        return activityAnalaysisDTO;
    }
}
