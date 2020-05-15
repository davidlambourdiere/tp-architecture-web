package com.lifetech.api.rest;

import com.lifetech.application.dto.LightDTO;
import com.lifetech.application.dto.LightDetailDTO;
import com.lifetech.application.manager.LightManager;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class LightController extends RestBaseController{

    private final LightManager lightManager;

    public LightController(LightManager lightManager) {
        this.lightManager = lightManager;
    }

    @PutMapping("light/updateLight/{id}")
    public LightDTO updateLight (@PathVariable(value = "id") String id,
                                                   @Valid @RequestBody LightDTO lightDtoReceived) {
        return lightManager.updateLight(id, lightDtoReceived);

    }
    @GetMapping("light/findByRoom/{id}")
    private List<LightDTO> findByRoom(@PathVariable("id") String id){ return lightManager.findByRoom(id); }


}


