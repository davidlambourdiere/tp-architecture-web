package com.lifetech.api.rest;

import com.lifetech.application.dto.ClockDTO;
import com.lifetech.application.manager.ClockManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClockController extends RestBaseController {

    private final ClockManager clockManager;

    public ClockController(ClockManager clockManager) {
        this.clockManager = clockManager;
    }

    @GetMapping("clock/{id}")
    private ClockDTO findById(@PathVariable("id") String id){
        return clockManager.findById(id);
    }
}
