package com.lifetech.api.rest;

import com.lifetech.application.dto.ResidenceDTO;
import com.lifetech.application.manager.ResidenceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ResidenceController extends RestBaseController{
    final ResidenceManager residenceManager;

    public ResidenceController(ResidenceManager residenceManager) {
        this.residenceManager = residenceManager;
    }

    @GetMapping("residence/findAll")
    private List<ResidenceDTO> findAllResidence(){
        return residenceManager.findAll();
    }

}
