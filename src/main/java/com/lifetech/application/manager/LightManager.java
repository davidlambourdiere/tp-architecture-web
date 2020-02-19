package com.lifetech.application.manager;

import com.lifetech.application.dto.LightDTO;
import com.lifetech.application.dto.LightDetailDTO;
import com.lifetech.domain.model.Light;

import java.util.List;

public interface LightManager {

    List<LightDTO> findAllLight();

    List<LightDTO> findLightByPerson(String id);

    LightDTO findById(String id);

    LightDetailDTO findByHistoric(String id);

    List<Light> findAllLightMalFunctionning();
}
