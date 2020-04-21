package com.lifetech.api.rest;


import com.lifetech.application.dto.HeaterBreakdownDTO;
import com.lifetech.application.manager.HeaterBreakdownManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HeaterBreakdownController extends RestBaseController {

    private final HeaterBreakdownManager heaterBreakdownManager;

    public HeaterBreakdownController(HeaterBreakdownManager heaterBreakdownManager) {
        this.heaterBreakdownManager = heaterBreakdownManager;
    }

    @GetMapping("heaterbreakdowns")
    private List<HeaterBreakdownDTO> findAllHeaterBreakdown() { return heaterBreakdownManager.findAllHeaterBreakdown(); }

    //@GetMapping("breakdown/findBreakdownByClock/{id}")
    //private List<ClockBreakdownDTO> findBreakdownByClock(@PathVariable("id") String id){ return breakdownManager.findBreakdownByClock(id); }

}
