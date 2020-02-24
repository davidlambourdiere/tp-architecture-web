package com.lifetech.application.manager;

import com.lifetech.application.dto.LightBreakdownDTO;

import java.util.List;

public interface LightBreakdownManager {

    List<LightBreakdownDTO> findAllLightBreakdown();

    //List<ClockBreakdownDTO> findBreakdownByClock(String id);



}
