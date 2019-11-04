package com.demospringboot.api.rest;

import com.demospringboot.application.dto.ObjectDTO;
import com.demospringboot.application.dto.PersonDTO;
import com.demospringboot.application.manager.ObjectManager;
import com.demospringboot.application.manager.PersonManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ObjectController {

    private final ObjectManager objectManager;

    public ObjectController(ObjectManager objectManager) {
        this.objectManager = objectManager;
    }

    @GetMapping("api/object/findAll")
    private List<ObjectDTO> findAllObject(){
        return objectManager.findAll();
    }
}
