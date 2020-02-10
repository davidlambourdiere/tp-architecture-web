package com.lifetech.api.rest;

import com.lifetech.application.dto.HeaterDTO;
import com.lifetech.application.dto.HeaterDetailDTO;
import com.lifetech.application.dto.SubscriptionDTO;
import com.lifetech.application.manager.HeaterManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HeaterController extends RestBaseController{

    private final HeaterManager heaterManager;

    public HeaterController(HeaterManager heaterManager) {
        this.heaterManager = heaterManager;
    }


    @GetMapping("heater/{id}")
    private HeaterDTO findAllHeater(@PathVariable("id") String id){
        return heaterManager.findAllHeater();
    }

    @GetMapping("heater/findHistoric/{id}")
    private HeaterDetailDTO findByHistoric(@PathVariable("id") String id) {
        return heaterManager.findByHistoric(id);
    }
}
