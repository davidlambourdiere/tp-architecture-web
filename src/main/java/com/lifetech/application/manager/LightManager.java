package com.lifetech.application.manager;

import com.lifetech.application.dto.LightDTO;
import com.lifetech.application.dto.LightDetailDTO;

import java.util.List;

public interface LightManager {

    List<LightDTO> findAllLight();

    List<LightDTO> findLightByPerson(String id);

    LightDTO findById(String id);

    LightDTO findByRoom(String id);

    LightDetailDTO findByHistoric(String id);
}
