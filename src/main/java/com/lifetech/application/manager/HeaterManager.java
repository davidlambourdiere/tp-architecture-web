package com.lifetech.application.manager;

import com.lifetech.application.dto.HeaterDTO;
import com.lifetech.application.dto.HeaterDetailDTO;

import java.util.List;

public interface HeaterManager {
    HeaterDTO findById(String id);
    HeaterDTO findAllHeater();
    HeaterDTO findByRoom(String id);

    HeaterDetailDTO findByHistoric(String id);

    int countHeaters();
}

