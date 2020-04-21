package com.lifetech.application.manager;

import com.lifetech.application.dto.HeaterBreakdownDTO;

import java.util.List;

public interface HeaterBreakdownManager {

    List<HeaterBreakdownDTO> findAllHeaterBreakdown();

    //List<ClockBreakdownDTO> findBreakdownByClock(String id);



}
