package com.lifetech.domain.dao;

import com.lifetech.domain.model.Clock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClockDAO extends JpaRepository<Clock, Long> {
}
