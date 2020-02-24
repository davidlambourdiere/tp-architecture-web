package com.lifetech.application.manager;

import com.lifetech.application.dto.PersonProfileDTO;

import java.util.List;

public interface PersonProfileManager {

    List<PersonProfileDTO> findAll();

    PersonProfileDTO save(PersonProfileDTO updatedProfile);
}
