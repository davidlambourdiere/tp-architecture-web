package com.lifetech.application.manager;

import com.lifetech.application.dto.RoomDTO;
import com.lifetech.domain.OrikaBeanMapper;
import com.lifetech.domain.dao.RoomDAO;
import com.lifetech.domain.model.Room;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomManagerImpl implements RoomManager {

    private final RoomDAO roomDAO;

    private final OrikaBeanMapper orikaBeanMapper;

    public RoomManagerImpl(OrikaBeanMapper orikaBeanMapper, RoomDAO roomDAO) {
        this.orikaBeanMapper = orikaBeanMapper;
        this.roomDAO = roomDAO;
    }

    public List<RoomDTO> findAllRoom(){
        return orikaBeanMapper.mapAsList(roomDAO.findAll(), RoomDTO.class);
    }

    public RoomDTO findById(String id) {
        Room room = roomDAO.findById(Long.parseLong(id)).orElse(null);
        return orikaBeanMapper.map(room, RoomDTO.class);
    }
}
