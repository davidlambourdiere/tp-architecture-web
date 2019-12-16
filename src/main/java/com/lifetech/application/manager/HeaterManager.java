package com.lifetech.application.manager;

import com.lifetech.application.dto.HeaterDTO;

public interface HeaterManager {
    HeaterDTO findById(String id);

    HeaterDTO findByRoom(String id);
}
