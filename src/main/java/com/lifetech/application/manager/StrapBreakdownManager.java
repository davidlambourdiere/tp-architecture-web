package com.lifetech.application.manager;

import com.lifetech.application.dto.StrapBreakdownDTO;

import java.util.List;

public interface StrapBreakdownManager {

    List<StrapBreakdownDTO> findAllStrapBreakdown();

    //List<ClockBreakdownDTO> findBreakdownByClock(String id);



}
