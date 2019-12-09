package com.lifetech.api.rest;

import com.lifetech.application.dto.IOTDTO;
import com.lifetech.application.manager.IOTManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
