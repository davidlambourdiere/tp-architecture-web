package com.lifetech.api.rest;

import com.lifetech.application.dto.PersonDTO;
import com.lifetech.application.manager.PersonManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController extends RestBaseController{

    private final PersonManager personManager;

    public PersonController(PersonManager personManager) {
        this.personManager = personManager;
    }

    @GetMapping("person/findAll")
    private List<PersonDTO> findAllPerson(){
        return personManager.findAll();
    }

    @PostMapping("person/verifyConnection")
    private PersonDTO verifyConnexion(@RequestBody PersonDTO connectedLogs){
        return personManager.verifyConnexion(connectedLogs);
    }
<<<<<<< Updated upstream
=======


>>>>>>> Stashed changes
}
