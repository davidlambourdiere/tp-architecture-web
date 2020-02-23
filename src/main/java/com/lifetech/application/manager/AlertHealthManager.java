package com.lifetech.application.manager;

import com.lifetech.application.dto.AlertHealthDTO;
import com.lifetech.application.dto.PersonDTO;

import java.util.List;

public interface AlertHealthManager {
    List<AlertHealthDTO> findAll();


}
