package com.sjprogramming.restapi.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChambre;
    @Column(unique = true)
    private String numeroChambre;
    private String typeChambre;

    @ManyToOne
    @JoinColumn(name = "bloc_id")
    private Bloc bloc;

    @OneToMany(mappedBy = "chambre", cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<>();

    // Constructors, getters, and setters

    public Chambre() {
    }

    public Chambre(String numeroChambre, String typeChambre) {
        this.numeroChambre = numeroChambre;
        this.typeChambre = typeChambre;
    }

    // Getters and setters

    public Long getIdChambre() {
        return idChambre;
    }

    public void setIdChambre(Long idChambre) {
        this.idChambre = idChambre;
    }

    public String getNumeroChambre() {
        return numeroChambre;
    }

    public void setNumeroChambre(String numeroChambre) {
        this.numeroChambre = numeroChambre;
    }

    public String getTypeChambre() {
        return typeChambre;
    }

    public void setTypeChambre(String typeChambre) {
        this.typeChambre = typeChambre;
    }

    public Bloc getBloc() {
        return bloc;
    }

    public void setBloc(Bloc bloc) {
        this.bloc = bloc;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}

