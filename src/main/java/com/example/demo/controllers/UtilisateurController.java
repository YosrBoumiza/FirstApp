package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Utilisateur;
import com.example.demo.requests.AuthentificationRequest;
import com.example.demo.services.UtilisateurService;



@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {
	
	
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	




	@Autowired
	private UtilisateurService utilisateurService ;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	

	
	
 	@RequestMapping(value="/list",method = RequestMethod.GET)
	public List<Utilisateur> affichage(){
 		
 		return utilisateurService.liste();
 	}
 	@RequestMapping(value="/getOneById/{id}",method = RequestMethod.GET)
	public Utilisateur getOneById(@PathVariable("id") Long id){
 		
 		return utilisateurService.findById(id);
 	}
 
 	@RequestMapping(value="/ajouter",method = RequestMethod.POST)
 	public List<Utilisateur> ajouterUtilisateur(@RequestBody Utilisateur utilisateur){
 		//BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		//String hashedPassword = passwordEncoder.encode(utilisateur.getMdp());
		
		
		utilisateur.setMdp(bCryptPasswordEncoder.encode(utilisateur.getMdp()));
		
		
 		utilisateurService.ajouterUtilisateur(utilisateur);
 		return utilisateurService.liste();
 		
 	}
 	

	
 	
// 	@RequestMapping(value="/authentification/{login}",method = RequestMethod.GET)
//	public Utilisateur authentification(@PathVariable("login") String login){
// 		
// 		return utilisateurService.getByLogin(login);
// 	}
 	@RequestMapping(value="/authentification",method = RequestMethod.POST)
 	public Utilisateur authentification(@RequestBody AuthentificationRequest auth)
 	
 	{
 		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(auth.getMdp());
		System.out.println("chaima mdp*******"+hashedPassword);
		Utilisateur user =  utilisateurService.getUserByLogin(auth.getLogin()) ;
		
		
		
		if (bCryptPasswordEncoder.matches(auth.getMdp(), user.getMdp())) {
			return user;
		}
		
		return null;
 	}
 	

 	
 	@RequestMapping(value="/deleteUtilisateur/{id}",method = RequestMethod.GET)
	public void deleteUtilisateur(@PathVariable("id") Long id){
 		
 		utilisateurService.supprimerUtilisateur(id);
 		
 	}
 	@RequestMapping(value="/updateUtilisateur",method = RequestMethod.POST)
 	public Utilisateur updateUtilisateur(@RequestBody Utilisateur utilisateur)
 	{
 		Utilisateur user =utilisateurService.findById(utilisateur.getId());
 		if(user == null)
 			return null ;
 		else
 		{
 			 utilisateurService.ajouterUtilisateur(utilisateur);
 			 return utilisateurService.findById(utilisateur.getId());
 		}
 	}
 	
 	
 
 	
	

	
	
}
