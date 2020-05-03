package com.lifetech.api.rest;

import TrackerResident.Tracking;
import com.lifetech.application.dto.PositionDTO;
import com.lifetech.application.manager.PositionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class PositionController extends RestBaseController{
    private final PositionManager positionManager;

    public PositionController(PositionManager positionManager) {
        this.positionManager = positionManager;
    }

    @GetMapping("position/findByStrap/{id}")
    private PositionDTO findPositionByStrap(@PathVariable("id") long strapId){
        return positionManager.findPositionByStrap(strapId);
    }

    @GetMapping("position/insertPositionByStrap/{id}")
    private void  insertPositionByStrapId() throws Exception {
        positionManager.simulatePosition();
    }


}

