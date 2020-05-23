package com.lifetech.api.rest;

import com.lifetech.application.dto.ActivityAnalaysisDTO;
import com.lifetech.application.manager.ActivityAnalysisManager;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ActivityAnalysisController extends RestBaseController{
    private final ActivityAnalysisManager activityAnalysisManager;

    public ActivityAnalysisController(ActivityAnalysisManager activityAnalysisManager) {
        this.activityAnalysisManager = activityAnalysisManager;
    }

    @PostMapping("analysis")
    ActivityAnalaysisDTO postAnalysis(@RequestBody ActivityAnalaysisDTO activityAnalaysisDTO) {return activityAnalysisManager.postAnalysis(activityAnalaysisDTO);}
}
