package com.example.demo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Utilisateur;
import com.example.demo.repositories.UtilisateurRepository;


@Service
public class UtilisateurService {
	
	@Autowired
	private UtilisateurRepository utilisateurrepository ;

	
	public List<Utilisateur> liste()
	{ 
		return utilisateurrepository.findAll();
	}
	public Utilisateur findById(Long id)
	{
		return utilisateurrepository.getOne(id);
		
	}
	
	public void ajouterUtilisateur(Utilisateur utilisateur) {
		utilisateurrepository.save(utilisateur);
	}
	public Utilisateur getByLogin(String login,String mdp)
	{
		return utilisateurrepository.getUserByLogin(login,mdp);
	}
	
	public Utilisateur getUserByLogin(String login)
	{
		return utilisateurrepository.getByLogin(login);
	}
	
	public void supprimerUtilisateur(Long id)
	{
		utilisateurrepository.deleteById(id);
	}

	

	
}
