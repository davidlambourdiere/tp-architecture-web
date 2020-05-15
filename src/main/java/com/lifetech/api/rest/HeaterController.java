package com.lifetech.api.rest;

import com.lifetech.application.dto.HeaterDTO;
import com.lifetech.application.dto.HeaterDetailDTO;
import com.lifetech.application.dto.SubscriptionDTO;
import com.lifetech.application.manager.HeaterManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class HeaterController extends RestBaseController{

    private final HeaterManager heaterManager;

    public HeaterController(HeaterManager heaterManager) {
        this.heaterManager = heaterManager;
    }


<<<<<<< HEAD
   @GetMapping("heater")
    private List<HeaterDTO> findAllHeater(){
||||||| merged common ancestors
    @GetMapping("heater/{id}")
    private HeaterDTO findAllHeater(@PathVariable("id") String id){
=======
    @GetMapping("heater")
    private List<HeaterDTO> findAllHeater(){
>>>>>>> master
        return heaterManager.findAllHeater();
    }

    @GetMapping("heater/findHistoric/{id}")
    private HeaterDetailDTO findByHistoric(@PathVariable("id") String id) {
        return heaterManager.findByHistoric(id);
    }



    @GetMapping("heater/findByPerson/{idperson}")
    private List<HeaterDTO> findIOTByPerson(@PathVariable("idperson") String idperson) {
        return heaterManager.findHeaterByPerson(idperson);
    }

    @GetMapping("heater/{id}")
    private HeaterDTO findById(@PathVariable("id") String id){
        return heaterManager.findById(id);
    }


    @PutMapping("heater/switchDownHeater/{id}")
    public HeaterDTO switchDownHeater (@PathVariable(value = "id") String id,
                                   @Valid @RequestBody HeaterDTO heaterDtoReceived) {
        return heaterManager.switchDownHeater(id, heaterDtoReceived);

    }
    @PutMapping("heater/updateHeater/{id}")
    public HeaterDTO updateHeater (@PathVariable(value = "id") String id,
                                 @Valid @RequestBody HeaterDTO heaterDtoReceived) {
        return heaterManager.updateHeater(id, heaterDtoReceived);

    }

    @GetMapping("heater/findByRoom/{id}")
    private List<HeaterDTO> findByRoom(@PathVariable("id") String id){ return heaterManager.findByRoom(id); }


    @GetMapping("heater/countHeaters")
    private int countHeaters(){return heaterManager.countHeaters();}

}

