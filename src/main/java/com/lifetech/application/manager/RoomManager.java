package com.lifetech.application.manager;

import com.lifetech.application.dto.RoomDTO;

import java.util.List;

public interface RoomManager {

    List<RoomDTO> findAllRoom();

    RoomDTO findById(String id);
}
