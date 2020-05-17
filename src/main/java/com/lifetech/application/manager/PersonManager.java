package com.lifetech.application.manager;

import com.lifetech.application.dto.PersonDTO;
import com.lifetech.domain.model.PersonStatus;

import java.util.List;

public interface PersonManager {

    List<PersonDTO> findAll();

    PersonDTO verifyConnexion(PersonDTO connectedLogs);

    PersonDTO findById(String id);

    int findNumberOfPersonByRole(PersonStatus personStatus);

    List<PersonDTO> findPersonByRole(PersonStatus personStatus);

    List<PersonDTO> findResidentsByName(String query);
}
