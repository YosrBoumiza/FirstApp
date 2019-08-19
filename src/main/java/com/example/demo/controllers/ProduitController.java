package com.example.demo.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Produit;
import com.example.demo.entities.Utilisateur;
import com.example.demo.services.ProduitService;
import com.example.demo.services.UtilisateurService;

@RestController
@RequestMapping("/produit")
public class ProduitController {
	
	@Autowired
	private ProduitService produitService ;
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public List<Produit> affichage(){
 		
 		return produitService.liste();
 	}
 	@RequestMapping(value="/deleteProduit/{id}",method = RequestMethod.GET)
	public void deleteUtilisateur(@PathVariable("id") Integer id){
 		
 		produitService.supprimerProduit(id);
 		
 	}
 	@RequestMapping(value="/updateProduit",method = RequestMethod.POST)
 	public Produit updateProduit(@RequestBody Produit produit)
 	{
 		Produit p =produitService.findById(produit.getId());
 		if(p == null)
 			return null ;
 		else
 		{
 			 produitService.ajouterProduit(produit);
 			 return produitService.findById(produit.getId());
 		}

 	}
 	@RequestMapping(value="/ajouter/{id}",method = RequestMethod.POST)
	public List<Produit> ajouterProduit(@RequestBody Produit produit,@PathVariable("id") Long id ){

 		Utilisateur user = utilisateurService.findById(id);
 		produit.setUtilisateur(user);
 		produitService.ajouterProduit(produit);
 		return produitService.liste();
 		
 	}
}