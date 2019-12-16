package com.lifetech.domain.dao;

import com.lifetech.domain.model.HealthHistoric;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthHistoricDAO extends JpaRepository<HealthHistoric, Long> {
}
