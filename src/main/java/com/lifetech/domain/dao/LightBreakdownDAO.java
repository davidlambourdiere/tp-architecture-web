package com.lifetech.domain.dao;

import com.lifetech.domain.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LightBreakdownDAO extends JpaRepository<LightBreakdown, Long> {
    //List<LightBreakdown> findAllLightBreakdown();

    //List<ClockBreakdown> findBreakdownByClock(Clock id);




}
