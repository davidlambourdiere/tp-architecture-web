package com.lifetech.api.rest;

import com.lifetech.application.dto.ActivityAnalaysisDTO;
import com.lifetech.application.manager.ActivityAnalysisManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ActivityAnalysisController extends RestBaseController{
    private final ActivityAnalysisManager activityAnalysisManager;

    public ActivityAnalysisController(ActivityAnalysisManager activityAnalysisManager) {
        this.activityAnalysisManager = activityAnalysisManager;
    }

    @GetMapping("analysis/countIOTByPerson/{personLogin}")
    ActivityAnalaysisDTO countIOTByPerson(@PathVariable("personLogin") String personLogin){
        return activityAnalysisManager.countIOTByPerson(personLogin);
    }

    @GetMapping("analysis/countIOTByResidence/{residenceId}")
    ActivityAnalaysisDTO countIOTByResidence(@PathVariable("residenceId") long residenceId){
        return activityAnalysisManager.countIOTByResidence(residenceId);
    }

    @GetMapping("analysis/countIOT")
    ActivityAnalaysisDTO countIOT(){
        return activityAnalysisManager.countIOT();
    }
}
