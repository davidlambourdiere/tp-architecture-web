package com.lifetech.application.manager;

import com.lifetech.application.dto.ShutterDTO;
import com.lifetech.application.dto.ShutterDetailDTO;
import com.lifetech.domain.model.Shutter;

import java.util.List;

import java.util.List;

public interface ShutterManager {
<<<<<<< HEAD

    List<ShutterDTO> findAllShutter();

    List<ShutterDTO> findShutterByPerson(String id);

    ShutterDTO findById(String id);

    ShutterDTO updateShutter( String id, ShutterDTO shutterDtoReceived);

    ShutterDTO findByRoom(String id);
||||||| merged common ancestors
    ShutterDTO findByRoom(String id);
=======
    List<ShutterDTO> findByRoom(String id);
>>>>>>> master

    ShutterDetailDTO findByHistoric(String id);

    List<Shutter> findAllShutterMalFunctionning();


}

