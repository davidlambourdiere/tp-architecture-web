package com.lifetech.domain.dao;

import com.lifetech.domain.model.Heater;
import com.lifetech.domain.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeaterDAO extends JpaRepository<Heater, Long> {
    List<Heater> findByRoom(Room room);
}
