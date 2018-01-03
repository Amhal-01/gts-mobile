package gts.com.mobile.models;

import java.io.Serializable;

public class Voyage implements Serializable {
    private int id;
    private Chauffeur chauffeur;
    private Bus bus;

    public Voyage() {
    }

    public Voyage(int id, Chauffeur chauffeur, Bus bus) {
        this.id = id;
        this.chauffeur = chauffeur;
        this.bus = bus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Chauffeur getChauffeur() {
        return chauffeur;
    }

    public void setChauffeur(Chauffeur chauffeur) {
        this.chauffeur = chauffeur;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }
}
