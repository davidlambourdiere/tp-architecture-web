package com.lifetech.api.rest;

import com.lifetech.application.dto.PersonProfileDTO;
import com.lifetech.application.manager.PersonProfileManager;
import com.lifetech.domain.model.PersonProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonProfileController extends RestBaseController {

    PersonProfileManager personprofilemanager;

    public PersonProfileController(PersonProfileManager personprofilemanager) {
        this.personprofilemanager = personprofilemanager;

    }

    @GetMapping("personProfile/findAll")
    private List<PersonProfileDTO> findAllPerson(){
        return personprofilemanager.findAll();
    }

    @GetMapping("personProfile/findRank")
    private List<PersonProfileDTO> findPersonRank(){return personprofilemanager.findRank();}

    @PostMapping("personProfile/createpersonProfile")
    private PersonProfileDTO createPersonProfile(@Valid @RequestBody PersonProfileDTO p) {
        return personprofilemanager.save(p);
    }

}
