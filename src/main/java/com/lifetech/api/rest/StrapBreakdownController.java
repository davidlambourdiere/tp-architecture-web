package com.lifetech.api.rest;

import com.lifetech.application.dto.ClockBreakdownDTO;
import com.lifetech.application.dto.StrapBreakdownDTO;
import com.lifetech.application.manager.ClockBreakdownManager;
import com.lifetech.application.manager.StrapBreakdownManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StrapBreakdownController extends RestBaseController {

    private final StrapBreakdownManager strapBreakdownManager;

    public StrapBreakdownController(StrapBreakdownManager strapBreakdownManager) {
        this.strapBreakdownManager = strapBreakdownManager;
    }

    @GetMapping("strapbreakdowns")
    private List<StrapBreakdownDTO> findAllStrapBreakdown() { return strapBreakdownManager.findAllStrapBreakdown(); }

    //@GetMapping("breakdown/findBreakdownByClock/{id}")
    //private List<ClockBreakdownDTO> findBreakdownByClock(@PathVariable("id") String id){ return breakdownManager.findBreakdownByClock(id); }


}
