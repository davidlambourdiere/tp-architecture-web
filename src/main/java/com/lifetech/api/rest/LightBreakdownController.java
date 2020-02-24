package com.lifetech.api.rest;

import com.lifetech.application.dto.ClockBreakdownDTO;
import com.lifetech.application.dto.LightBreakdownDTO;
import com.lifetech.application.manager.ClockBreakdownManager;
import com.lifetech.application.manager.LightBreakdownManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LightBreakdownController extends RestBaseController {

    private final LightBreakdownManager lightBreakdownManager;

    public LightBreakdownController(LightBreakdownManager lightBreakdownManager) {
        this.lightBreakdownManager = lightBreakdownManager;
    }

    @GetMapping("lightbreakdowns")
    private List<LightBreakdownDTO> findAllLightBreakdown() { return lightBreakdownManager.findAllLightBreakdown(); }

    //@GetMapping("breakdown/findBreakdownByClock/{id}")
    //private List<ClockBreakdownDTO> findBreakdownByClock(@PathVariable("id") String id){ return breakdownManager.findBreakdownByClock(id); }

}
