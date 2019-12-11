package com.lifetech.api.rest;

import com.lifetech.application.manager.ActivityAnalysisManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ActivityAnalysisController extends RestBaseController{
    private final ActivityAnalysisManager activityAnalysisManager;

    public ActivityAnalysisController(ActivityAnalysisManager activityAnalysisManager) {
        this.activityAnalysisManager = activityAnalysisManager;
    }

    @GetMapping("analysis/countIOTByPerson/{personId}")
    Map<String,Long> countIOTByPerson(@PathVariable("personId") long personId){
        return activityAnalysisManager.countIOTByPerson(personId);
    }

    @GetMapping("analysis/countIOTByResidence/{residenceId}")
    Map<String,Long> countIOTByResidence(@PathVariable("residenceId") long residenceId){
        return activityAnalysisManager.countIOTByResidence(residenceId);
    }

    @GetMapping("analysis/countIOT")
    Map<String,Long> countIOT(){
        return activityAnalysisManager.countIOT();
    }
}
