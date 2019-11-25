package com.lifetech.api.rest;

import com.lifetech.application.dto.IOTDTO;
import com.lifetech.application.manager.IOTManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IOTController {

    private final IOTManager iotManager;

    public IOTController(IOTManager iotManager) {
        this.iotManager = iotManager;
    }

    @GetMapping("api/iot/findAllIOT")
    private List<IOTDTO> findAllIOT() {
        return iotManager.findAllIOT();
    }
}
