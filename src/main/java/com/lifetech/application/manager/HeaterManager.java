package com.lifetech.application.manager;

import com.lifetech.application.dto.HeaterDTO;
import com.lifetech.application.dto.HeaterDetailDTO;
import com.lifetech.domain.model.Heater;

import java.util.List;

public interface HeaterManager {
    HeaterDTO findById(String id);
    HeaterDTO findAllHeater();

    List<HeaterDTO> findByRoom(String id);

    HeaterDetailDTO findByHistoric(String id);

    List<Heater> findAllHeaterMalFunctionning();

    int countHeaters();
}

