package com.lifetech.application.manager;

import com.lifetech.application.dto.ShutterDTO;
import com.lifetech.application.dto.ShutterDetailDTO;

import java.util.List;

public interface ShutterManager {
    ShutterDTO findByRoom(String id);

    ShutterDetailDTO findByHistoric(String id);

    List<ShutterDTO> findAllShutter();

    List<ShutterDTO> findShutterByPerson(String id);

    ShutterDTO findById(String id);

    ShutterDTO updateShutter( String id, ShutterDTO shutterDtoReceived);
}

