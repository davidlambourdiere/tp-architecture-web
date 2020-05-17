package com.lifetech.domain.model;

import java.util.List;

public class AlertCache {
    private int nbAlert;
    private List<String> alertId;

    public AlertCache(int nbAlert, List<String> alertId) {
        this.nbAlert = nbAlert;
        this.alertId = alertId;
    }

    public AlertCache() {
    }

    public int getNbAlert() {
        return nbAlert;
    }

    public void setNbAlert(int nbAlert) {
        this.nbAlert = nbAlert;
    }

    public List<String> getAlertId() {
        return alertId;
    }

    public void setAlertId(List<String> alertId) {
        this.alertId = alertId;
    }
}
