package com.lifetech.application.manager;

import com.lifetech.application.dto.SensorDTO;

import java.util.List;

public interface SensorManager {
    List<SensorDTO> findAllSensors();
}
