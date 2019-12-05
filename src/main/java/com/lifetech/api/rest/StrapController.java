package com.lifetech.api.rest;

import com.lifetech.application.manager.StrapManager;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StrapController extends RestBaseController{

    private final StrapManager strapManager;

    public StrapController(StrapManager strapManager) {
        this.strapManager = strapManager;
    }
}
