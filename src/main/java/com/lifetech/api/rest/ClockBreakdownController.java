package com.lifetech.api.rest;

import com.lifetech.application.dto.ClockBreakdownDTO;
import com.lifetech.application.manager.ClockBreakdownManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClockBreakdownController extends RestBaseController {

    private final ClockBreakdownManager clockBreakdownManager;

    public ClockBreakdownController(ClockBreakdownManager clockBreakdownManager) {
        this.clockBreakdownManager = clockBreakdownManager;
    }

    @GetMapping("clockbreakdowns")
    private List<ClockBreakdownDTO> findAllClockBreakdown() { return clockBreakdownManager.findAllClockBreakdown(); }

    //@GetMapping("breakdown/findBreakdownByClock/{id}")
    //private List<ClockBreakdownDTO> findBreakdownByClock(@PathVariable("id") String id){ return breakdownManager.findBreakdownByClock(id); }


}
