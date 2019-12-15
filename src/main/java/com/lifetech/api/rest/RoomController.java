package com.lifetech.api.rest;

import com.lifetech.application.dto.RoomDTO;
import com.lifetech.application.manager.RoomManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomController extends RestBaseController {

    private final RoomManager roomManager;

    public RoomController(RoomManager roomManager) { this.roomManager = roomManager; }


    @GetMapping("room/findAll")
    private List<RoomDTO> findAllRoom() { return roomManager.findAllRoom(); }

    @GetMapping("room/{id}")
    private RoomDTO findById(@PathVariable("id") String id){
        return roomManager.findById(id);
    }
}