package com.lifetech.application.manager;

import com.lifetech.domain.model.HealthHistoric;

import java.util.Map;

public interface HealthHistoricManager {

    HealthHistoric save (HealthHistoric healthHistoric);
    HealthHistoric split (String message);

    boolean alertDetection(HealthHistoric histSaved, Map<Long, Map<String, Integer>> cache);
}
