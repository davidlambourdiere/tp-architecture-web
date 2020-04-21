package com.lifetech.api.rest;

import com.lifetech.application.dto.AlertHealthDTO;
import com.lifetech.application.dto.PersonDTO;
import com.lifetech.application.manager.AlertHealthManager;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("alert/health/findAlertNumber")
    private int findAlertNumber(){
        return alertHealthManager.findAlertNumber();
    }

    @PostMapping("alert/health/findAlertNumberByPerson")
    private int findAlertNumberByPerson(@RequestBody PersonDTO person){
        //return alertHealthManager.findAlertNumberByPerson(person);
        System.err.println(person);
        return 0;
    }

    @GetMapping("alert/health/findById/{id}")
    private AlertHealthDTO findById(@PathVariable("id") String id){
        return alertHealthManager.findDtoById(id);
    }

}
