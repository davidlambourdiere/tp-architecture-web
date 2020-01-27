package com.lifetech.domain.dao;

import com.lifetech.domain.model.ClockHistoric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClockHistoricDAO extends JpaRepository<ClockHistoric, Long> {
}
