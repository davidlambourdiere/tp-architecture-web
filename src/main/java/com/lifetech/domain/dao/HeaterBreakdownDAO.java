package com.lifetech.domain.dao;

import com.lifetech.domain.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeaterBreakdownDAO extends JpaRepository<HeaterBreakdown, Long> {
    @Query(value = "SELECT * FROM lifetech.heaterbreakdown GROUP BY iotheaterbreakdown_id", nativeQuery = true)
    List<HeaterBreakdown> findAllHeaterGroupByIOTId();
    //List<HeaterBreakdown> findAllHeaterBreakdown();

    //List<ClockBreakdown> findBreakdownByClock(Clock id);



}
