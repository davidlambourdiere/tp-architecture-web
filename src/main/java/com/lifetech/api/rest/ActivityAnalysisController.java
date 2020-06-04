package com.lifetech.api.rest;

import com.lifetech.application.dto.ActivityAnalysisDTO;
import com.lifetech.application.manager.ActivityAnalysisManager;
import org.springframework.web.bind.annotation.*;

@RestController
public class ActivityAnalysisController extends RestBaseController{
    private final ActivityAnalysisManager activityAnalysisManager;

    public ActivityAnalysisController(ActivityAnalysisManager activityAnalysisManager) {
        this.activityAnalysisManager = activityAnalysisManager;
    }

    @PostMapping("analysis")
    ActivityAnalysisDTO postAnalysis(@RequestBody ActivityAnalysisDTO activityAnalysisDTO) {return activityAnalysisManager.postAnalysis(activityAnalysisDTO);}
}
