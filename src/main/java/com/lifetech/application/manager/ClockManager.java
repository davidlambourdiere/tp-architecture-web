package com.lifetech.application.manager;

import com.lifetech.application.dto.ClockDTO;

public interface ClockManager {
    ClockDTO findById(String id);
}
