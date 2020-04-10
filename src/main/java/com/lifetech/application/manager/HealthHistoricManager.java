package com.lifetech.application.manager;

import com.lifetech.application.dto.HealthHistoricDTO;
import com.lifetech.domain.model.AlertCache;
import com.lifetech.domain.model.HealthHistoric;

import java.util.Map;
import java.util.Optional;

public interface HealthHistoricManager {

    HealthHistoric save (HealthHistoric healthHistoric);
    HealthHistoric split (String message);

    boolean alertDetection(HealthHistoric histSaved, Map<Long, Map<String, AlertCache>> cache);

    HealthHistoricDTO findTopByStrap(String id);
}
