package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Produit;
import com.example.demo.repositories.ProduitRepository;

@Service
public class ProduitService {
	
	@Autowired
	ProduitRepository produitRepository ;
	public void ajouterProduit(Produit produit) {
		produitRepository.save(produit);
	}
	public List<Produit> liste()
	{ 
		return produitRepository.findAll();
	}
	public void supprimerProduit(Integer id)
	{
		produitRepository.deleteById(id);
	}
	public Produit findById(Integer id)
	{
		return produitRepository.getOne(id);
		
	}

}
