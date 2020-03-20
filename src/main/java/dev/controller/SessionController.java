package dev.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.vm.SessionVM;
import dev.domain.Session;
import dev.exception.ElementNotFoundException;
//import dev.exception.BadRequestException;
//import dev.exception.ElementNotFoundException;
import dev.repository.SessionRepo;

@RestController
@CrossOrigin
public class SessionController {

	private SessionRepo sessionRepo;

	private static final Logger LOG = LoggerFactory.getLogger(dev.controller.SessionController.class);

	public SessionController(SessionRepo sessionRepo) {
		this.sessionRepo = sessionRepo;
	}

	/**
	 * Renvoie un Session spécifique à partir de son id
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, path = "Session", params = "id")
	public ResponseEntity<SessionVM> getFromId(Long id) {
		Optional<Session> sessionOpt = this.sessionRepo.findById(id);
		if (!sessionOpt.isPresent()) {
			String messageErreur = "Session d'id " + id + " introuvable..";
			LOG.error(messageErreur);
			throw new ElementNotFoundException(messageErreur);
		}
		return ResponseEntity.status(HttpStatus.OK).body(new SessionVM(sessionOpt.get()));
	}
	
	/** 
	 * Retourne la liste de tous les Sessions 
	 * 
	 * @param 
	 * @return
	 */	 
	@RequestMapping(method = RequestMethod.GET, path = "Sessions")
	public List<SessionVM> getSessions() {
		LOG.info( "*** Recuperer tous les Sessions ***");
		List<Session> listeSessions = this.sessionRepo.findAll();
		LOG.info( listeSessions.get(0).toString());
		return listeSessions.stream().map(col -> new SessionVM(col)).collect(Collectors.toList());
	}

	/**
	 * Renvoie de tous les  Sessions commencant par 
	 * établissement, formation, certif, salle, entreprise, période (date deb, date fin)
	 * passés en paramètre
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, path = "SessionsFiltres") 
	public List<SessionVM> getSessionFiltreParMatriculeNom( 
			@RequestParam("etablissement") 	String etablissement, 
            @RequestParam("formation") 		String formation,
            @RequestParam("certif") 		String certif,
            @RequestParam("salle") 			String salle,
            @RequestParam("entreprise") 	String entreprise,
            @RequestParam("dateDebut") 		String dateDebut,
			@RequestParam("prenom") 		String dateFin) {
		LOG.info( "*** Filtrer les Sessions par " 
			        + "établissement / formation / certif / salle / entreprise / dateDebut / dateFin  : " 
		            + etablissement + '/' + formation + '/' + certif + '/' + salle + '/'+ entreprise + '/'+ dateDebut + '/' + dateFin  );
		List<Session> listeSessions = null ;
// TO-DO
//		   this.sessionRepo.findByMatriculeStartingWithAndNomStartingWithAndPrenomStartingWith( 
//		   + etablissement, formation, certif, salle, entreprise, dateDebut, dateFin);
		return listeSessions.stream().map(Session -> new SessionVM( Session)).collect(Collectors.toList());
	}


}
