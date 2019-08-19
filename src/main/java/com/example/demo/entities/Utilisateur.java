package com.example.demo.entities;



import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity(name = "utilisateur")
public class Utilisateur implements Serializable{
	
	/**
	 * 
	 */
	@OneToMany(mappedBy="utilisateur")
	private Set<Produit> produits;
	
	public Set<Produit> getProduits() {
		return produits;
	}
	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id ; 
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	private String nom ;
	private String prenom ;
	private String login ;
	private String mdp ;
	
	public Utilisateur(String nom,String prenom,String login,String mdp)
	{

		this.login=login;
		this.mdp=mdp;
		this.nom=nom;
		this.prenom=prenom ;
	}
	public Utilisateur()
	{
		id=0;
		nom="" ;
		prenom="" ;
		mdp="" ;
		login="" ; 
		
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
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

}