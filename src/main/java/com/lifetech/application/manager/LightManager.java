package com.lifetech.application.manager;

import com.lifetech.application.dto.LightDTO;

import java.util.List;

public interface LightManager {

    List<LightDTO> findAllLight();

    List<LightDTO> findLightByPerson(String id);

    LightDTO findById(String id);

    LightDTO findByRoom(String id);
}
