package com.lifetech.application.manager;

import com.lifetech.application.dto.HeaterDTO;
import com.lifetech.application.dto.HeaterDetailDTO;

import java.util.List;

public interface HeaterManager {
    HeaterDTO findById(String id);

    HeaterDTO findByRoom(String id);

    HeaterDetailDTO findByHistoric(String id);

    List<HeaterDTO> findAllHeater();

    List<HeaterDTO> findHeaterByPerson(String id);

    HeaterDTO updateHeater( String id, HeaterDTO heaterDtoReceived);

    HeaterDTO switchDownHeater(String id, HeaterDTO heaterDtoReceived);
}

