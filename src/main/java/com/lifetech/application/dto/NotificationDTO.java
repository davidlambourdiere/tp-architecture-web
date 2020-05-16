package com.lifetech.application.dto;

public class NotificationDTO {
    private String message;
    private boolean isread;
    private String typeiot;
    private Long iotid;
    private String emetteur;
    private String destinataire;

    public NotificationDTO() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isIsread() {
        return isread;
    }

    public void setIsread(boolean isread) {
        this.isread = isread;
    }

    public String getTypeiot() {
        return typeiot;
    }

    public void setTypeiot(String typeiot) {
        this.typeiot = typeiot;
    }

    public Long getIotid() {
        return iotid;
    }

    public void setIotid(Long iotid) {
        this.iotid = iotid;
    }

    public String getEmetteur() {
        return emetteur;
    }

    public void setEmetteur(String emetteur) {
        this.emetteur = emetteur;
    }

    public String getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(String destinataire) {
        this.destinataire = destinataire;
    }
}
