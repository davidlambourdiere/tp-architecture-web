package com.lifetech.application.manager;

import com.lifetech.application.dto.PersonProfileDTO;

import java.util.List;

public interface PersonProfileManager {

    List<PersonProfileDTO> findAll();
    List<PersonProfileDTO> findRank();

    PersonProfileDTO save(PersonProfileDTO updatedProfile);
}
