package com.sjprogramming.restapi.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFoyer;
    private String nomFoyer;

    @OneToOne
    @JoinColumn(name = "universite_id")
    private Universite universite;

    @OneToMany(mappedBy = "foyer", cascade = CascadeType.ALL)
    private List<Bloc> blocs = new ArrayList<>();

    // Constructors, getters, and setters

    public Foyer() {
    }

    public Foyer(String nomFoyer) {
        this.nomFoyer = nomFoyer;
    }

    // Getters and setters

    public Long getIdFoyer() {
        return idFoyer;
    }

    public void setIdFoyer(Long idFoyer) {
        this.idFoyer = idFoyer;
    }

    public String getNomFoyer() {
        return nomFoyer;
    }

    public void setNomFoyer(String nomFoyer) {
        this.nomFoyer = nomFoyer;
    }

    public Universite getUniversite() {
        return universite;
    }

    public void setUniversite(Universite universite) {
        this.universite = universite;
    }

    public List<Bloc> getBlocs() {
        return blocs;
    }

    public void setBlocs(List<Bloc> blocs) {
        this.blocs = blocs;
    }
}
