package com.lifetech.domain.dao;

import com.lifetech.application.dto.HealthHistoricDTO;
import com.lifetech.domain.model.HealthHistoric;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HealthHistoricDAO extends JpaRepository<HealthHistoric, Long> {
    List<HealthHistoric> findByStrap(Long id);

}
