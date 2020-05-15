package com.lifetech.application.manager;

import com.lifetech.application.dto.HeaterDTO;
import com.lifetech.application.dto.HeaterDetailDTO;
import com.lifetech.domain.model.Heater;

import java.util.List;

public interface HeaterManager {
    HeaterDTO findById(String id);
<<<<<<< HEAD
||||||| merged common ancestors
    HeaterDTO findAllHeater();
=======
    List<HeaterDTO> findAllHeater();
>>>>>>> master

    List<HeaterDTO> findByRoom(String id);

    HeaterDetailDTO findByHistoric(String id);

    List<HeaterDTO> findAllHeater();

    List<HeaterDTO> findHeaterByPerson(String id);

    HeaterDTO updateHeater( String id, HeaterDTO heaterDtoReceived);

    HeaterDTO switchDownHeater(String id, HeaterDTO heaterDtoReceived);

    List<Heater> findAllHeaterMalFunctionning();

    int countHeaters();

}

