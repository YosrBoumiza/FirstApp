package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Produit;


@Repository
public interface ProduitRepository extends JpaRepository<Produit,Integer>{
	
	
}
