package gts.com.mobile.models;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

public class PointDeRamassage implements Serializable {
    private int id;
    private Itineraire point;
    private LocalTime horaire;
    private List<Voyage> voyages;
    private List<Etudiant> etudiants;

    public PointDeRamassage(int id, Itineraire point, LocalTime horaire, List<Voyage> voyages, List<Etudiant> etudiants) {
        this.id = id;
        this.point = point;
        this.horaire = horaire;
        this.voyages = voyages;
        this.etudiants = etudiants;
    }

    public PointDeRamassage() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Itineraire getPoint() {
        return point;
    }

    public void setPoint(Itineraire point) {
        this.point = point;
    }

    public LocalTime getHoraire() {
        return horaire;
    }

    public void setHoraire(LocalTime horaire) {
        this.horaire = horaire;
    }

    public List<Voyage> getVoyages() {
        return voyages;
    }

    public void setVoyages(List<Voyage> voyages) {
        this.voyages = voyages;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }
}
