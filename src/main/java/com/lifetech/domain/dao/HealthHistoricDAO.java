package com.lifetech.domain.dao;

import com.lifetech.domain.model.HealthHistoric;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HealthHistoricDAO extends JpaRepository<HealthHistoric, Long> {
    List<HealthHistoric> findByStrap(Long id);

    HealthHistoric findTopByStrap(Long id);

}
