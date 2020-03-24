package dev.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.vm.CentreVM;
import dev.domain.Centre;
import dev.exception.ElementNotFoundException;
import dev.repository.CentreRepo;

@RestController

public class CentreController {
	
	private CentreRepo centreRepo;
	private static final Logger LOG = LoggerFactory.getLogger(dev.controller.CentreController.class);
	
	/**
	 * @param centreRepo
	 */
	public CentreController(CentreRepo centreRepo) {
		super();
		this.centreRepo = centreRepo;
	}

	/**
	 * Renvoie un centre spécifique à partir de son id
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, path = "Centre", params = "id")
	public ResponseEntity<CentreVM> getFromId(Long id) {
		Optional<Centre> centreOpt = this.centreRepo.findById(id);
		if (!centreOpt.isPresent()) {
			String messageErreur = "Session d'id " + id + " introuvable..";
			LOG.error(messageErreur);
			throw new ElementNotFoundException(messageErreur);
		}
		return ResponseEntity.status(HttpStatus.OK).body(new CentreVM(centreOpt.get()));
	}
	
	/** 
	 * Retourne la liste de tous les centres 
	 * 
	 * @param 
	 * @return
	 */	 
	@RequestMapping(method = RequestMethod.GET, path = "Centres")
	public List<CentreVM> getCentres() {
		LOG.info( "*** Recuperer tous les centres ***");
		List<Centre> listeCentres = this.centreRepo.findAll();
		LOG.info( listeCentres.get(0).toString());
		return listeCentres.stream().map(col -> new CentreVM(col)).collect(Collectors.toList());
	}
}
