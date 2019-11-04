package com.demospringboot.application.manager;

import com.demospringboot.application.dto.PersonDTO;

import java.util.List;

public interface PersonManager {
    List<PersonDTO> findAll();
    PersonDTO findById(Long id);
}
