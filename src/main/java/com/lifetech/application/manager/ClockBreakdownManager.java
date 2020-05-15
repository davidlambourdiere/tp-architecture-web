package com.lifetech.application.manager;

import com.lifetech.application.dto.ClockBreakdownDTO;

import java.util.List;

public interface ClockBreakdownManager {

    List<ClockBreakdownDTO> findAllClockBreakdown();

    //List<ClockBreakdownDTO> findBreakdownByClock(String id);



}
