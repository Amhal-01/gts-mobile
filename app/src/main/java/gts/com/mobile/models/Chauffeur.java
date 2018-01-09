package gts.com.mobile.models;

import java.io.Serializable;
import java.util.Date;

public class Chauffeur extends Personne implements Serializable {
    private String telephone;
    private Boolean isOk;
    private Date dateEmbauche;

    public Chauffeur(int id, String nom, String prenom, String password, String telephone, String email, Boolean isActive, Boolean isOk, Date dateEmbauche) {
        super(id, nom, prenom, password, email, isActive);
        this.isOk = isOk;
        this.telephone = telephone;
        this.dateEmbauche = dateEmbauche;
    }

    public Chauffeur() {

    }

    public Boolean getOk() {
        return isOk;
    }

    public void setOk(Boolean ok) {
        isOk = ok;
    }

    public Date getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Chauffeur{" +
                "telephone='" + telephone + '\'' +
                ", isOk=" + isOk +
                ", dateEmbauche=" + dateEmbauche +
                "} " + super.toString();
    }
}
