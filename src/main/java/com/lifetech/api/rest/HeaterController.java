package com.lifetech.api.rest;

import com.lifetech.application.dto.HeaterDTO;
import com.lifetech.application.manager.HeaterManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeaterController extends RestBaseController{

    @Autowired
    private HeaterManager heaterManager;

    @GetMapping("heater/{id}")
    private HeaterDTO findById(@PathVariable("id") String id){
        return heaterManager.findById(id);
    }
}
