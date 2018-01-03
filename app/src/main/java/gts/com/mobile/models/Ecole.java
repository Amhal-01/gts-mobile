package gts.com.mobile.models;

import java.io.Serializable;

public class Ecole implements Serializable {
    private int id;
    private String nom;
    private String telephone;
    private String email;
    private RespEcole respEcole;
    private Itineraire itineraire;

    public Ecole(int id, String nom, String telephone, String email, RespEcole respEcole, Itineraire itineraire) {
        this.id = id;
        this.nom = nom;
        this.telephone = telephone;
        this.email = email;
        this.respEcole = respEcole;
        this.itineraire = itineraire;
    }

    public Ecole() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RespEcole getRespEcole() {
        return respEcole;
    }

    public void setRespEcole(RespEcole respEcole) {
        this.respEcole = respEcole;
    }

    public Itineraire getItineraire() {
        return itineraire;
    }

    public void setItineraire(Itineraire itineraire) {
        this.itineraire = itineraire;
    }
}
