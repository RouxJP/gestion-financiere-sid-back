package dev.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import dev.domain.Utilisateur;
import dev.repository.UtilisateurRepo;



@RestController
public class UtilisateurController {
	
	private UtilisateurRepo utilisateurRepo;
	private static final Logger LOG = LoggerFactory.getLogger(dev.controller.UtilisateurController.class);

	
	
	public UtilisateurController(UtilisateurRepo utilisateurRepo) {
		super();
		this.utilisateurRepo= utilisateurRepo;
	}
	
	/**
	 * GET utilisateurs : méthode qui récupere les utilisateurs 
	 * 
	 * @return liste d'utilisateurs 
	 */
	@GetMapping()
	public List<Utilisateur> listerUtilisateurs() {
		return this.utilisateurRepo.findAll();
	}
}
