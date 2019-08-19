package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.example.demo.services.ProduitService;
import com.example.demo.services.UtilisateurService;


@Configuration
@EnableWebSecurity
@SpringBootApplication
public class FirstAppApplication extends WebSecurityConfigurerAdapter implements CommandLineRunner{
	
	@Autowired
	UtilisateurService utilisateurService;
	
	@Autowired
	ProduitService produitService;
	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/utilisateur/ajouter")
				.permitAll();

		http.csrf().disable();
	}

	public static void main(String[] args) {
		SpringApplication.run(FirstAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		
//		Utilisateur utilisateur = new Utilisateur();
//		utilisateur.setLogin("yosr");
//		utilisateur.setMdp("yosr123");
//		utilisateur.setPrenom("yosr");
//		utilisateur.setNom("Boumiza");
//		utilisateurService.ajouterUtilisateur(utilisateur);
//		
//		
//		Utilisateur utilisateur1 = new Utilisateur();
//		utilisateur1.setLogin("Aymen");
//		utilisateur1.setMdp("Aymen123");
//		utilisateur1.setPrenom("Aymen");
//		utilisateur1.setNom("gard");
//		utilisateurService.ajouterUtilisateur(utilisateur1);
//		
//		
//		Utilisateur utilisateur2 = new Utilisateur();
//		utilisateur2.setLogin("Majdi");
//		utilisateur2.setMdp("Majdi123");
//		utilisateur2.setPrenom("Majdi");
//		utilisateur2.setNom("Labidi");
//		utilisateurService.ajouterUtilisateur(utilisateur2);
//		
//		Produit produit=new Produit() ;
//		produit.setLibelle("voiture");
//		produit.setMarque("Mercedes");
//		produit.setPrix(100.200f);
//		produit.setQuantite(1);
//		produitService.ajouterProduit(produit);
//		
//
//		Produit produit1=new Produit() ;
//		produit1.setLibelle("eau");
//		produit1.setMarque("Safia");
//		produit1.setPrix(0.700f);
//		produit1.setQuantite(4);
//		produitService.ajouterProduit(produit1);
//
//		Produit produit2=new Produit() ;
//		produit2.setLibelle("telephone");
//		produit2.setMarque("Samsung");
//		produit2.setPrix(500f);
//		produit2.setQuantite(1);
//		produitService.ajouterProduit(produit2);
//		
//
//		Produit produit3=new Produit() ;
//		produit3.setLibelle("Lunettes");
//		produit3.setMarque("Guess");
//		produit3.setPrix(450f);
//		produit3.setQuantite(1);
//		produitService.ajouterProduit(produit3);
//		
//		
//	}

}
