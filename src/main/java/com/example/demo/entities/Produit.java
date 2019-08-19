package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity(name = "produit")

public class Produit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private int id ; 
	private String libelle ;
	private String marque ;
	private float prix ; 
	private int quantite ;
	
	
	@JsonIgnore
	@ManyToOne(
          fetch = FetchType.LAZY,
          optional = false)
    @JoinColumn(name="utilisateur_id", nullable=false)
    private Utilisateur utilisateur;
	
	public Produit()
	{
		id=0;
		libelle="" ;
		marque="" ;
		prix=0.0f ;
		quantite=0 ; 
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	} 
	
	
}	
