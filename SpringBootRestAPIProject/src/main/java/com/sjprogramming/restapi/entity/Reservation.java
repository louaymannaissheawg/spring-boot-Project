package com.sjprogramming.restapi.entity;

import com.sjprogramming.restapi.entity.Chambre;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;
    private String anneeUniversitaire;
    private boolean estValide;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "etudiant_reservation",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "etudiant_id"))
    private List<Etudiant> etudiants = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "chambre_id")
    private Chambre chambre;

    // Constructors, getters, and setters

    public Reservation() {
    }

    public Reservation(String anneeUniversitaire, boolean estValide) {
        this.anneeUniversitaire = anneeUniversitaire;
        this.estValide = estValide;
    }

    // Getters and setters

    public Long getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Long idReservation) {
        this.idReservation = idReservation;
    }

    public String getAnneeUniversitaire() {
        return anneeUniversitaire;
    }

    public void setAnneeUniversitaire(String anneeUniversitaire) {
        this.anneeUniversitaire = anneeUniversitaire;
    }

    public boolean isEstValide() {
        return estValide;
    }

    public void setEstValide(boolean estValide) {
        this.estValide = estValide;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }
}


