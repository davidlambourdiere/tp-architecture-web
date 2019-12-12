package com.lifetech.api.rest;

import com.lifetech.application.dto.IOTDTO;
import com.lifetech.application.manager.IOTManager;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
=======
import org.springframework.web.bind.annotation.*;
>>>>>>> master

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

    @PostMapping("iots/findByType")
    private IOTDTO findIOTByType(){
        return iotManager.findIOTByType("heater");
    }

    @GetMapping("iots/findByPerson/{id}")
    private IOTDTO findIOTByPerson(@PathVariable("id") String id){
        return iotManager.findByPerson(id);
    }
}
