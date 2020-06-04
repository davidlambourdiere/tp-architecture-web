package com.lifetech.application.manager;

import com.lifetech.application.dto.ActivityAnalysisDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.*;
import com.lifetech.infrastructure.ActivityAnalysisAxisEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityAnalysisManagerImpl implements ActivityAnalysisManager {

    private  ClockDAO clockDAO;
    private  HeaterDAO heaterDAO;
    private  LightDAO lightDAO;
    private  PersonDAO personDAO;
    private  ResidenceDAO residenceDAO;
    private  StrapDAO strapDAO;
    private HeaterBreakdownDAO heaterBreakdownDAO;
    private final OrikaBeanMapper orikaBeanMapper;
    private static final Logger LOG = LoggerFactory.getLogger(ActivityAnalysisManager.class);
    public ActivityAnalysisManagerImpl(ClockDAO clockDAO, HeaterDAO heaterDAO, LightDAO lightDAO, OrikaBeanMapper orikaBeanMapper, PersonDAO personDAO, ResidenceDAO residenceDAO, HeaterBreakdownDAO heaterBreakdownDAO, StrapDAO strapDAO) {
        this.clockDAO = clockDAO;
        this.heaterDAO = heaterDAO;
        this.lightDAO = lightDAO;
        this.orikaBeanMapper = orikaBeanMapper;
        this.personDAO = personDAO;
        this.residenceDAO = residenceDAO;
        this.heaterBreakdownDAO = heaterBreakdownDAO;
        this.strapDAO = strapDAO;
    }

    @Override
    public ActivityAnalysisDTO postAnalysis(ActivityAnalysisDTO activityAnalysisDTO) {
        LOG.info("Input: " + activityAnalysisDTO.toString());
        ActivityAnalysisAxisEnum activityAnalysisAxisEnum;
        String residenceid = activityAnalysisDTO.getResidenceid();
        String personid = activityAnalysisDTO.getPersonid();
        if (residenceid.equals("0") & personid.equals("0"))//All residences
            activityAnalysisAxisEnum = (activityAnalysisDTO.getPeriod().equals("all")) ? ActivityAnalysisAxisEnum.ALL_ALL : ActivityAnalysisAxisEnum.ALL_PERIOD;
        else//A given residence
            if (personid.equals("0"))//Every person of the given residence
                activityAnalysisAxisEnum = (activityAnalysisDTO.getPeriod().equals("all")) ? ActivityAnalysisAxisEnum.RESIDENCE_ALL : ActivityAnalysisAxisEnum.RESIDENCE_PERIOD;
            else //A specific person
                activityAnalysisAxisEnum = (activityAnalysisDTO.getPeriod().equals("all")) ? ActivityAnalysisAxisEnum.PERSON_ALL : ActivityAnalysisAxisEnum.PERSON_PERIOD;

        String startdate = activityAnalysisDTO.getStartdate();
        String enddate = activityAnalysisDTO.getEnddate();
        switch (activityAnalysisAxisEnum){
            case ALL_ALL:
                activityAnalysisDTO.setHeaterbreakdownrate(heaterBreakdownDAO.getBreakdownRate());
                activityAnalysisDTO.setNheater(String.valueOf(heaterDAO.count()));
                activityAnalysisDTO.setNclock(String.valueOf(clockDAO.count()));
                activityAnalysisDTO.setNlight(String.valueOf(lightDAO.count()));
                activityAnalysisDTO.setNstrap(String.valueOf(strapDAO.count()));
                break;
            case ALL_PERIOD:
                activityAnalysisDTO.setHeaterbreakdownrate(heaterBreakdownDAO.getBreakdownRateBetween(startdate, enddate));
                activityAnalysisDTO.setNheater(String.valueOf(heaterDAO.count()));
                activityAnalysisDTO.setNclock(String.valueOf(clockDAO.count()));
                activityAnalysisDTO.setNlight(String.valueOf(lightDAO.count()));
                activityAnalysisDTO.setNstrap(String.valueOf(strapDAO.count()));
                break;
            case RESIDENCE_ALL:
                activityAnalysisDTO.setHeaterbreakdownrate(heaterBreakdownDAO.getBreakdownRateByResidence(residenceid));
                activityAnalysisDTO.setNheater(String.valueOf(heaterDAO.countByResidenceId(residenceid)));
                activityAnalysisDTO.setNclock(String.valueOf(clockDAO.countByResidenceId(residenceid)));
                activityAnalysisDTO.setNlight(String.valueOf(lightDAO.countByResidenceId(residenceid)));
                activityAnalysisDTO.setNstrap(String.valueOf(strapDAO.countByResidenceId(residenceid)));
                break;
            case RESIDENCE_PERIOD:
                activityAnalysisDTO.setHeaterbreakdownrate(heaterBreakdownDAO.getHeaterBreakdownRateByResidenceBetween(residenceid,startdate, enddate));
                activityAnalysisDTO.setNheater(String.valueOf(heaterDAO.countByResidenceId(residenceid)));
                activityAnalysisDTO.setNclock(String.valueOf(clockDAO.countByResidenceId(residenceid)));
                activityAnalysisDTO.setNlight(String.valueOf(lightDAO.countByResidenceId(residenceid)));
                activityAnalysisDTO.setNstrap(String.valueOf(strapDAO.countByResidenceId(residenceid)));
                break;
            case PERSON_ALL:
                activityAnalysisDTO.setHeaterbreakdownrate(heaterBreakdownDAO.getBreakdownRateByPerson(personid));
                activityAnalysisDTO.setNheater(String.valueOf(heaterDAO.countByPersonId(personid)));
                activityAnalysisDTO.setNclock(String.valueOf(clockDAO.countByPersonId(personid)));
                activityAnalysisDTO.setNlight(String.valueOf(lightDAO.countByPersonId(personid)));
                activityAnalysisDTO.setNstrap(String.valueOf(strapDAO.countByPersonId(personid)));
                break;
            case PERSON_PERIOD:
                activityAnalysisDTO.setHeaterbreakdownrate(heaterBreakdownDAO.getHeaterBreakdownRateByPersonBetween(personid,startdate, enddate));
                activityAnalysisDTO.setNheater(String.valueOf(heaterDAO.countByPersonId(personid)));
                activityAnalysisDTO.setNclock(String.valueOf(clockDAO.countByPersonId(personid)));
                activityAnalysisDTO.setNlight(String.valueOf(lightDAO.countByPersonId(personid)));
                activityAnalysisDTO.setNstrap(String.valueOf(strapDAO.countByPersonId(personid)));
                break;
        };
        LOG.info("Output: " + activityAnalysisDTO.toString());
        return activityAnalysisDTO;
    }
}
