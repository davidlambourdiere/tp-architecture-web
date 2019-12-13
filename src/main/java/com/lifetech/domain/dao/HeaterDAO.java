package com.lifetech.domain.dao;

import com.lifetech.domain.model.Heater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeaterDAO extends JpaRepository<Heater, Long> {
}
