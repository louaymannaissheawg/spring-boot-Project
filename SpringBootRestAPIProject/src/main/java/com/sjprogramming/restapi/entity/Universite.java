package com.sjprogramming.restapi.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUni;
    private String nomUni;

    @OneToOne(mappedBy = "universite", cascade = CascadeType.ALL)
    private Foyer foyer;

    // Constructors, getters, and setters

    public Universite() {
    }

    public Universite(String nomUni) {
        this.nomUni = nomUni;
    }

    // Getters and setters

    public Long getIdUni() {
        return idUni;
    }

    public void setIdUni(Long idUni) {
        this.idUni = idUni;
    }

    public String getNomUni() {
        return nomUni;
    }

    public void setNomUni(String nomUni) {
        this.nomUni = nomUni;
    }

    public Foyer getFoyer() {
        return foyer;
    }

    public void setFoyer(Foyer foyer) {
        this.foyer = foyer;
    }
}
