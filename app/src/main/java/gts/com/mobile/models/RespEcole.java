package gts.com.mobile.models;

import java.io.Serializable;

public class RespEcole extends Personne implements Serializable {
    private Ecole ecole;
    private String telephone;

    public RespEcole(int id, String nom, String prenom, String password, String email, Boolean isActive, Ecole ecole, String telephone) {
        super(id, nom, prenom, password, email, isActive);
        this.ecole = ecole;
        this.telephone = telephone;
    }

    public RespEcole() {
    }

    public Ecole getEcole() {
        return ecole;
    }

    public void setEcole(Ecole ecole) {
        this.ecole = ecole;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
