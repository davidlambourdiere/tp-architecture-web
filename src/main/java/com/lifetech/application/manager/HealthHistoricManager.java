package com.lifetech.application.manager;

import com.lifetech.domain.model.HealthHistoric;

public interface HealthHistoricManager {

    HealthHistoric save (HealthHistoric healthHistoric);
    HealthHistoric split (String message);

    boolean alertDetection(HealthHistoric histSaved);
}
