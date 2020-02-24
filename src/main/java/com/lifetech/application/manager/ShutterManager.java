package com.lifetech.application.manager;

import com.lifetech.application.dto.ShutterDTO;
import com.lifetech.application.dto.ShutterDetailDTO;
import com.lifetech.domain.model.Shutter;

import java.util.List;

public interface ShutterManager {
    ShutterDTO findByRoom(String id);

    ShutterDetailDTO findByHistoric(String id);

    List<Shutter> findAllShutterMalFunctionning();
}
