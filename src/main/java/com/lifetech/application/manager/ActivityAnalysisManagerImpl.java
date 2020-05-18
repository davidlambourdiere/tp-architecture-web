package com.lifetech.application.manager;

import com.lifetech.application.dto.ActivityAnalaysisDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.*;
import com.lifetech.domain.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final HeaterBreakdownDAO heaterBreakdownDAO;
    private static final Logger LOG = LoggerFactory.getLogger(ActivityAnalysisManager.class);
    public ActivityAnalysisManagerImpl(ClockDAO clockDAO, HeaterDAO heaterDAO, LightDAO lightDAO, OrikaBeanMapper orikaBeanMapper, PersonDAO personDAO, ResidenceDAO residenceDAO, HeaterBreakdownDAO heaterBreakdownDAO) {
        this.clockDAO = clockDAO;
        this.heaterDAO = heaterDAO;
        this.lightDAO = lightDAO;
        this.orikaBeanMapper = orikaBeanMapper;
        this.personDAO = personDAO;
        this.residenceDAO = residenceDAO;
        this.heaterBreakdownDAO = heaterBreakdownDAO;
    }

    @Override
    public ActivityAnalaysisDTO postAnalysis(ActivityAnalaysisDTO activityAnalaysisDTO) {
        LOG.info("Input: " + activityAnalaysisDTO.toString());

        LOG.info("Output: " + activityAnalaysisDTO.toString());
        return activityAnalaysisDTO;
    }
}
