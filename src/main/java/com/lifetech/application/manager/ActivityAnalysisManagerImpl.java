package com.lifetech.application.manager;

import com.lifetech.application.dto.ActivityAnalaysisDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.*;
import com.lifetech.domain.model.*;
import com.lifetech.infrastructure.ActivityAnalysisAxisEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final StrapDAO strapDAO;
    private final HeaterBreakdownDAO heaterBreakdownDAO;
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
    public ActivityAnalaysisDTO postAnalysis(ActivityAnalaysisDTO activityAnalaysisDTO) {
        LOG.info("Input: " + activityAnalaysisDTO.toString());
        ActivityAnalysisAxisEnum activityAnalysisAxisEnum;
        String residenceid = activityAnalaysisDTO.getResidenceid();
        String personid = activityAnalaysisDTO.getPersonid();
        if (residenceid.equals("0") & personid.equals("0"))//All residences
            activityAnalysisAxisEnum = (activityAnalaysisDTO.getPeriod().equals("all")) ? ActivityAnalysisAxisEnum.ALL_ALL : ActivityAnalysisAxisEnum.ALL_PERIOD;
        else//A given residence
            if (personid.equals("0"))//Every person of the given residence
                activityAnalysisAxisEnum = (activityAnalaysisDTO.getPeriod().equals("all")) ? ActivityAnalysisAxisEnum.RESIDENCE_ALL : ActivityAnalysisAxisEnum.RESIDENCE_PERIOD;
            else //A specific person
                activityAnalysisAxisEnum = (activityAnalaysisDTO.getPeriod().equals("all")) ? ActivityAnalysisAxisEnum.PERSON_ALL : ActivityAnalysisAxisEnum.PERSON_PERIOD;

        String startdate = activityAnalaysisDTO.getStartdate();
        String enddate = activityAnalaysisDTO.getEnddate();
        switch (activityAnalysisAxisEnum){
            case ALL_ALL:
                activityAnalaysisDTO.setHeaterbreakdownrate(heaterBreakdownDAO.getBreakdownRate());
                activityAnalaysisDTO.setNheater(String.valueOf(heaterDAO.count()));
                activityAnalaysisDTO.setNclock(String.valueOf(clockDAO.count()));
                activityAnalaysisDTO.setNlight(String.valueOf(lightDAO.count()));
                activityAnalaysisDTO.setNstrap(String.valueOf(strapDAO.count()));
                break;
            case ALL_PERIOD:
                activityAnalaysisDTO.setHeaterbreakdownrate(heaterBreakdownDAO.getBreakdownRateBetween(startdate, enddate));
                activityAnalaysisDTO.setNheater(String.valueOf(heaterDAO.count()));
                activityAnalaysisDTO.setNclock(String.valueOf(clockDAO.count()));
                activityAnalaysisDTO.setNlight(String.valueOf(lightDAO.count()));
                activityAnalaysisDTO.setNstrap(String.valueOf(strapDAO.count()));
                break;
            case RESIDENCE_ALL:
                activityAnalaysisDTO.setHeaterbreakdownrate(heaterBreakdownDAO.getBreakdownRateByResidence(residenceid));
                activityAnalaysisDTO.setNheater(String.valueOf(heaterDAO.countByResidenceId(residenceid)));
                activityAnalaysisDTO.setNclock(String.valueOf(clockDAO.countByResidenceId(residenceid)));
                activityAnalaysisDTO.setNlight(String.valueOf(lightDAO.countByResidenceId(residenceid)));
                activityAnalaysisDTO.setNstrap(String.valueOf(strapDAO.countByResidenceId(residenceid)));
                break;
            case RESIDENCE_PERIOD:
                activityAnalaysisDTO.setHeaterbreakdownrate(heaterBreakdownDAO.getHeaterBreakdownRateByResidenceBetween(residenceid,startdate, enddate));
                activityAnalaysisDTO.setNheater(String.valueOf(heaterDAO.countByResidenceId(residenceid)));
                activityAnalaysisDTO.setNclock(String.valueOf(clockDAO.countByResidenceId(residenceid)));
                activityAnalaysisDTO.setNlight(String.valueOf(lightDAO.countByResidenceId(residenceid)));
                activityAnalaysisDTO.setNstrap(String.valueOf(strapDAO.countByResidenceId(residenceid)));
                break;
            case PERSON_ALL:
                activityAnalaysisDTO.setHeaterbreakdownrate(heaterBreakdownDAO.getBreakdownRateByPerson(personid));
                activityAnalaysisDTO.setNheater(String.valueOf(heaterDAO.countByPersonId(personid)));
                activityAnalaysisDTO.setNclock(String.valueOf(clockDAO.countByPersonId(personid)));
                activityAnalaysisDTO.setNlight(String.valueOf(lightDAO.countByPersonId(personid)));
                activityAnalaysisDTO.setNstrap(String.valueOf(strapDAO.countByPersonId(personid)));
                break;
            case PERSON_PERIOD:
                activityAnalaysisDTO.setHeaterbreakdownrate(heaterBreakdownDAO.getHeaterBreakdownRateByPersonBetween(personid,startdate, enddate));
                activityAnalaysisDTO.setNheater(String.valueOf(heaterDAO.countByPersonId(personid)));
                activityAnalaysisDTO.setNclock(String.valueOf(clockDAO.countByPersonId(personid)));
                activityAnalaysisDTO.setNlight(String.valueOf(lightDAO.countByPersonId(personid)));
                activityAnalaysisDTO.setNstrap(String.valueOf(strapDAO.countByPersonId(personid)));
                break;
        };
        LOG.info("Output: " + activityAnalaysisDTO.toString());
        return activityAnalaysisDTO;
    }
}
