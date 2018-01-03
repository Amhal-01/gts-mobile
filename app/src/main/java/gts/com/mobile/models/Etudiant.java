package gts.com.mobile.models;

import java.io.Serializable;
import java.time.LocalDate;

public class Etudiant extends Personne implements Serializable {
    private LocalDate dateNaissance;
    private Ecole ecole;
    private PointDeRamassage pdr;

    public Etudiant(int id, String nom, String prenom, String password, String email, LocalDate dateNaissance, Boolean isActive, Ecole ecole, PointDeRamassage pdr) {
        super(id, nom, prenom, password, email, isActive);
        this.ecole = ecole;
        this.pdr = pdr;
        this.dateNaissance = dateNaissance;
    }

    public Etudiant() {
    }

    public Ecole getEcole() {
        return ecole;
    }

    public void setEcole(Ecole ecole) {
        this.ecole = ecole;
    }

    public PointDeRamassage getPdr() {
        return pdr;
    }

    public void setPdr(PointDeRamassage pdr) {
        this.pdr = pdr;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
}
