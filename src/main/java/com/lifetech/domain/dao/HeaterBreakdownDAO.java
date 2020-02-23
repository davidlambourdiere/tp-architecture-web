package com.lifetech.domain.dao;

import com.lifetech.domain.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeaterBreakdownDAO extends JpaRepository<HeaterBreakdown, Long> {
    //List<HeaterBreakdown> findAllHeaterBreakdown();

    //List<ClockBreakdown> findBreakdownByClock(Clock id);



}
