package com.lifetech.domain.dao;

import com.lifetech.domain.model.ClockHistoric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClockHistoricDAO extends JpaRepository<ClockHistoric, Long> {
    List<ClockHistoric> findAllByClockId(Long id);
}
