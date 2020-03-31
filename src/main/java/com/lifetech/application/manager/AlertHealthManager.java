package com.lifetech.application.manager;

import com.lifetech.application.dto.AlertHealthDTO;
import com.lifetech.application.dto.PersonDTO;
import com.lifetech.domain.model.AlertHealth;

import java.util.List;

public interface AlertHealthManager {
    List<AlertHealthDTO> findAll();

    List<AlertHealthDTO> findNewAlerts();

    int findAlertNumber();

    int findAlertNumberByPerson(String id);

    AlertHealth save(AlertHealth alertFC);

    AlertHealth findById(String id);
}
