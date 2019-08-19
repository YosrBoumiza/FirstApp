package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Utilisateur;


@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> { 
	
	@Query("SELECT u FROM utilisateur u where u.login  = :login and u.mdp= :mdp")
	Utilisateur getUserByLogin(@Param("login") String login,@Param("mdp") String mdp);
	
	@Query("SELECT u FROM utilisateur u where u.login  = :login")
	Utilisateur getByLogin(@Param("login") String login);



}

