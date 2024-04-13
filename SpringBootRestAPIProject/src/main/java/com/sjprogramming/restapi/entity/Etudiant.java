package com.sjprogramming.restapi.entity;



import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Etudiant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEtudiant;
	private String nom;
	private String prenom;
	private String cin;
	private String ecole;
	private Date dateNaissance;

	@ManyToMany(mappedBy = "etudiants", cascade = CascadeType.ALL)
	private List<Reservation> reservations = new ArrayList<>();

	// Constructors, getters, and setters

	public Etudiant() {
	}

	public Etudiant(String nom, String prenom, String cin, String ecole, Date dateNaissance) {
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.ecole = ecole;
		this.dateNaissance = dateNaissance;
	}

	// Getters and setters

	public Long getIdEtudiant() {
		return idEtudiant;
	}

	public void setIdEtudiant(Long idEtudiant) {
		this.idEtudiant = idEtudiant;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getEcole() {
		return ecole;
	}

	public void setEcole(String ecole) {
		this.ecole = ecole;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
}
