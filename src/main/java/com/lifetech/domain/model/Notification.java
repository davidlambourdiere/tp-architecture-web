package com.lifetech.domain.model;

import javax.persistence.*;

@Entity(name="notification")
public class Notification extends  PersistableElement{

    @Column(name="message")
    private String message;

    @Column(name="isread")
    private boolean isread;

    @Enumerated(EnumType.STRING)
    private IOTType typeiot;

    @Column(name="iotid")
    private Long idiot;

    @Column(name="emetteur")
    private String emetteur;

    @Column(name="destinataire")
    private String destinataire;

    public Notification() {
    }

    public Notification(String message, boolean isread, IOTType typeiot, Long idiot, String emetteur, String destinataire) {
        this.message = message;
        this.isread = isread;
        this.typeiot = typeiot;
        this.idiot = idiot;
        this.emetteur = emetteur;
        this.destinataire = destinataire;
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

    public IOTType getTypeiot() {
        return typeiot;
    }

    public void setTypeiot(IOTType typeiot) {
        this.typeiot = typeiot;
    }

    public Long getIdiot() {
        return idiot;
    }

    public void setIdiot(Long idiot) {
        this.idiot = idiot;
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
