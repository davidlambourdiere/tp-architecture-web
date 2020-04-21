package com.lifetech.application.manager;

import com.lifetech.application.dto.AlertHealthDTO;
import com.lifetech.application.dto.PersonDTO;
import com.lifetech.domain.model.AlertHealth;

import java.util.List;

public interface AlertHealthManager {
    List<AlertHealthDTO> findAll();

    List<AlertHealthDTO> findNewAlerts();

    int findAlertNumber();

    int findAlertNumberByStrap(String id);

    AlertHealth save(AlertHealth alertFC);

    AlertHealth findById(String id);

    AlertHealthDTO findDtoById(String id);

    int findAlertNumberByStrapAndStatus(String id , String status);
}
