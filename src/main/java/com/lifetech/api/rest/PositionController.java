package com.lifetech.api.rest;

import com.lifetech.application.dto.PositionDTO;
import com.lifetech.application.manager.PositionManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}

