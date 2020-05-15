package com.lifetech.api.rest;

import com.lifetech.application.dto.PersonDTO;
import com.lifetech.application.manager.PersonManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MockController extends RestBaseController {

    private final PersonManager personManager;

    public MockController(PersonManager personManager) {
        this.personManager = personManager;
    }

    @PostMapping("mockHealth/message")
    private ResponseEntity<String> getIotMessage(@RequestBody String iotmessage){
        System.out.println("Message: "+iotmessage);
        return ResponseEntity.ok("ok");
    }


}
