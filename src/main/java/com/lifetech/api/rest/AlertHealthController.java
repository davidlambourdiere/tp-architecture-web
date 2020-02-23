package com.lifetech.api.rest;

import com.lifetech.application.dto.AlertHealthDTO;
import com.lifetech.application.manager.AlertHealthManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlertHealthController extends RestBaseController {

    private final AlertHealthManager alertHealthManager;

    public AlertHealthController(AlertHealthManager alertHealthManager) {
        this.alertHealthManager = alertHealthManager;
    }

    @GetMapping("alert/health/findAll")
    private List<AlertHealthDTO> findAllAlertHealth(){
        return alertHealthManager.findAll();
    }

    @GetMapping("alert/health/findNewAlerts")
    private List<AlertHealthDTO> findNewAlerts(){
        return alertHealthManager.findNewAlerts();
    }




}
