package com.lifetech.api.rest;

import com.lifetech.application.dto.HealthHistoricDTO;
import com.lifetech.application.manager.HealthHistoricManager;
import org.springframework.web.bind.annotation.*;



@RestController
public class HealthHistoricController extends RestBaseController {

    private final HealthHistoricManager healthHistoricManager;

    public HealthHistoricController(HealthHistoricManager healthHistoricManager) {

        this.healthHistoricManager = healthHistoricManager;
    }

    @GetMapping("health/historic/findHistoric/{id}")
    private HealthHistoricDTO findTopByStrap(@PathVariable("id") String id) {
        return healthHistoricManager.findTopByStrap(id);
    }



}
