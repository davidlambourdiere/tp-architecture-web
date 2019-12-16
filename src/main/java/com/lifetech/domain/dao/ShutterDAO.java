package com.lifetech.domain.dao;

import com.lifetech.domain.model.Room;
import com.lifetech.domain.model.Shutter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShutterDAO extends JpaRepository<Shutter, Long> {
    List<Shutter> findByRoom(Room room);
}
