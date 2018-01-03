package gts.com.mobile.models;

import java.io.Serializable;

public class Bus implements Serializable {
    private int id;
    private String matricule;
    private String marque;
    private int nbPlaces;
    private Boolean isOk;

    public Bus() {
    }

    public Bus(int id, String matricule, String marque, int nbPlaces, Boolean isOk) {
        this.id = id;
        this.matricule = matricule;
        this.marque = marque;
        this.nbPlaces = nbPlaces;
        this.isOk = isOk;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public Boolean getOk() {
        return isOk;
    }

    public void setOk(Boolean ok) {
        isOk = ok;
    }
}
