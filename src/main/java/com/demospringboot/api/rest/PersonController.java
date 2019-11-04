package com.demospringboot.api.rest;

import com.demospringboot.application.dto.PersonDTO;
import com.demospringboot.application.manager.PersonManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    private final PersonManager personManager;

    public PersonController(PersonManager personManager) {
        this.personManager = personManager;
    }

    @GetMapping("api/person/findAll")
    private List<PersonDTO> findAllPerson(){
        return personManager.findAll();
    }

    @RequestMapping("api/person/findById/{id}")
    private PersonDTO findById(@PathVariable("id") Long id) {
        return personManager.findById(id);
    }
}
