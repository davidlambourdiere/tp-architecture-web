package com.lifetech.api.rest;

import com.lifetech.application.dto.SensorDTO;
import com.lifetech.application.manager.SensorManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SensorController {

    private final SensorManager sensorManager;

    public SensorController(SensorManager sensorManager) {
        this.sensorManager = sensorManager;
    }

    @GetMapping("api/sensor/findAll")
    private List<SensorDTO> findAllSensors(){
        return sensorManager.findAllSensors();
    }
}
