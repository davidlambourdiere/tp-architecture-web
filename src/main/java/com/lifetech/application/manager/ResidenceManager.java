package com.lifetech.application.manager;

import com.lifetech.application.dto.ResidenceDTO;

import java.util.List;

public interface ResidenceManager {
    List<ResidenceDTO> findAll();
}
