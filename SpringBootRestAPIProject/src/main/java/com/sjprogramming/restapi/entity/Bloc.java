package com.sjprogramming.restapi.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBloc;
    private String nomBloc;
    private int capaciteBloc;

    @ManyToOne
    @JoinColumn(name = "foyer_id")
    private Foyer foyer;

    @OneToMany(mappedBy = "bloc", cascade = CascadeType.ALL)
    private List<Chambre> chambres = new ArrayList<>();

    // Constructors, getters, and setters

    public Bloc() {
    }

    public Bloc(String nomBloc, int capaciteBloc) {
        this.nomBloc = nomBloc;
        this.capaciteBloc = capaciteBloc;
    }

    // Getters and setters

    public Long getIdBloc() {
        return idBloc;
    }

    public void setIdBloc(Long idBloc) {
        this.idBloc = idBloc;
    }

    public String getNomBloc() {
        return nomBloc;
    }

    public void setNomBloc(String nomBloc) {
        this.nomBloc = nomBloc;
    }

    public int getCapaciteBloc() {
        return capaciteBloc;
    }

    public void setCapaciteBloc(int capaciteBloc) {
        this.capaciteBloc = capaciteBloc;
    }

    public Foyer getFoyer() {
        return foyer;
    }

    public void setFoyer(Foyer foyer) {
        this.foyer = foyer;
    }

    public List<Chambre> getChambres() {
        return chambres;
    }

    public void setChambres(List<Chambre> chambres) {
        this.chambres = chambres;
    }
}
