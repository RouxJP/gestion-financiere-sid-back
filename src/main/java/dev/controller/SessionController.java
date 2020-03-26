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

import dev.controller.vm.SessionLigne;
import dev.controller.vm.SessionVM;
import dev.domain.Session;
import dev.exception.ElementNotFoundException;
//import dev.exception.BadRequestException;
//import dev.exception.ElementNotFoundException;
import dev.repository.SessionRepo;

@RestController
@CrossOrigin
public class SessionController {

	// Ici requestes d'acces au tables
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

	/** Rechercher la liste des sessions filtrées par : 
	*    - libellé : établissement / formation / salle / certification / entreprise
	*    - période : date de début, date de fin
	* Chaque filtre est optionnel et pour les libellés on peut saisir un sous libelle
	* @return
	*/
	@RequestMapping(method = RequestMethod.GET, path = "SessionsFiltres") 
	public List<SessionLigne> getSessionFiltreParMatriculeNom( 
			@RequestParam("etablissement") 		String etablissement, 
            @RequestParam("formation") 			String formation,
            @RequestParam("certification") 		String certif,
            @RequestParam("salle") 				String salle,
            @RequestParam("entreprise") 		String entreprise,
            @RequestParam("dateDebutSession") 	String dateDebut,
			@RequestParam("dateFinSession") 	String dateFin) {
		LOG.info( "*** Filtrer les Sessions par " 
			        + "établissement / formation / certif / salle / entreprise / dateDebut / dateFin  : " 
		            + etablissement + '/' + formation + '/' + certif + '/' + salle + '/'+ entreprise + '/'+ dateDebut + '/' + dateFin  );
		
		List<Session> listeSessionsRepo 	= this.sessionRepo.findByNomStartingWith( formation );
		for( Session session : listeSessionsRepo) {
				LOG.info( session.getNom());
		} 
		return listeSessionsRepo.stream().map(session -> new SessionLigne( session)).collect( Collectors.toList());
	}


}
