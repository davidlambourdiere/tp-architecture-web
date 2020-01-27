package com.lifetech.api.rest;

import com.lifetech.application.dto.StrapDTO;
import com.lifetech.application.dto.StrapDetailDTO;
import com.lifetech.application.manager.StrapManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StrapController extends RestBaseController{

    private final StrapManager strapManager;

    public StrapController(StrapManager strapManager) {
        this.strapManager = strapManager;
    }

    @GetMapping("strap/{id}")
    private StrapDTO findById(@PathVariable("id") String id){
        return null;
    }

    @GetMapping("strap/findHistoric/{id}")
    private StrapDetailDTO findByHistoric(@PathVariable("id") String id) {
        return strapManager.findByHistoric(id);
    }
}
