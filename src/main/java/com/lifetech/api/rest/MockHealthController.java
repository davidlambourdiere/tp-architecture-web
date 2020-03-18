package com.lifetech.api.rest;

import com.lifetech.application.manager.HealthHistoricManager;
import com.lifetech.application.manager.PersonManager;
import com.lifetech.domain.model.HealthHistoric;
import org.springframework.web.bind.annotation.*;

@RestController
public class MockHealthController extends RestBaseController {

    private final PersonManager personManager;
    private final HealthHistoricManager healthHistoricManager;

    public MockHealthController(PersonManager personManager, HealthHistoricManager healthHistoricManager) {
        this.personManager = personManager;
        this.healthHistoricManager = healthHistoricManager;
    }


    @GetMapping("mockHealth/message/{strapmessage}")
    private String strapMessage(@PathVariable("strapmessage") String strapmessage){
        System.out.println("Message: "+strapmessage.toString());
        //Historization of the message
        HealthHistoric histSaved = healthHistoricManager.save(healthHistoricManager.split(strapmessage));

        //alertDetection
        boolean isAlert = healthHistoricManager.alertDetection(histSaved);


        return "ok";
    }



}
