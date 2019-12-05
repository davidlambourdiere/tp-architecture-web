package com.lifetech.api.rest;

import com.lifetech.application.manager.ShutterManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShutterController extends RestBaseController{

    private final ShutterManager shutterManager;

    public ShutterController(ShutterManager shutterManager) {
        this.shutterManager = shutterManager;
    }
}
