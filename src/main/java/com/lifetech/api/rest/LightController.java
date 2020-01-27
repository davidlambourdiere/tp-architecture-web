package com.lifetech.api.rest;

import com.lifetech.application.dto.ClockDTO;
import com.lifetech.application.dto.LightDTO;
import com.lifetech.application.manager.LightManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LightController extends RestBaseController{

    private final LightManager lightManager;

    public LightController(LightManager lightManager) {
        this.lightManager = lightManager;
    }

    @GetMapping("light")
    private List<LightDTO> findAllLight() {
        return lightManager.findAllLight();
    }

    @GetMapping("light/findByPerson/{idperson}")
    private List<LightDTO> findIOTByPerson(@PathVariable("idperson") String idperson) {
        return lightManager.findLightByPerson(idperson);
    }

    @GetMapping("light/{id}")
    private LightDTO findById(@PathVariable("id") String id){
        return lightManager.findById(id);
    }

    @GetMapping("light/findHistoric/{id}")
    private List<ClockDTO> findByHistoric(@PathVariable("id") String id) {
        return null;
    }
}
