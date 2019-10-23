package com.lifetech.domain.dao;

import com.lifetech.domain.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorDAO extends JpaRepository<Sensor, Long> {
}
