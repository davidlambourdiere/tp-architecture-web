package com.lifetech.api.rest;

import com.lifetech.application.manager.HealthHistoricManager;
import com.lifetech.application.manager.PersonManager;
import com.lifetech.domain.model.HealthHistoric;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MockHealthController extends RestBaseController {

    private final PersonManager personManager;
    private final HealthHistoricManager healthHistoricManager;
    private final Map<Long, Map<String, Integer>> cache;

    public MockHealthController(PersonManager personManager, HealthHistoricManager healthHistoricManager) {
        this.personManager = personManager;
        this.healthHistoricManager = healthHistoricManager;
        this.cache = new HashMap<>();
    }


    @GetMapping("mockHealth/message/{strapmessage}")
    private String strapMessage(@PathVariable("strapmessage") String strapmessage){
        System.out.println("Message: "+strapmessage.toString());
        //Historization of the message
        HealthHistoric histSaved = healthHistoricManager.save(healthHistoricManager.split(strapmessage));

        //alertDetection
        boolean isAlert = healthHistoricManager.alertDetection(histSaved, cache);



        return "ok";
    }



}
