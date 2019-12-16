package com.lifetech.application.manager;

import com.lifetech.application.dto.ShutterDTO;

public interface ShutterManager {
    ShutterDTO findByRoom(String id);
}
