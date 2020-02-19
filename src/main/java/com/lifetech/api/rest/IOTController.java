package com.lifetech.api.rest;

import com.lifetech.application.dto.IOTDTO;
import com.lifetech.application.manager.IOTManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IOTController extends RestBaseController {

    private final IOTManager iotManager;

    public IOTController(IOTManager iotManager) {
        this.iotManager = iotManager;
    }

    @GetMapping("iots")
    private IOTDTO findAllIOT(){
        return iotManager.findAllIOT();
    }

    @GetMapping("iots/malfunctionning")
    private IOTDTO findAllIOTWithMalfunctionning(){
        return iotManager.findAllIOTWithMalfunctionning();
    }

    @PostMapping("iots/findByType")
    private IOTDTO findIOTByType(){
        return iotManager.findIOTByType("heater");
    }

    @GetMapping("iots/findByPerson/{id}")
    private IOTDTO findIOTByPerson(@PathVariable("id") String id){
        return iotManager.findByPerson(id);
    }
}
