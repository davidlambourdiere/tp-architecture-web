package com.lifetech.application.manager;

import com.lifetech.application.dto.ShutterDTO;
import com.lifetech.application.dto.ShutterDetailDTO;

public interface ShutterManager {
    ShutterDTO findByRoom(String id);

    ShutterDetailDTO findByHistoric(String id);
}
