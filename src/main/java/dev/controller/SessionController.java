package dev.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.vm.SessionLigneVM;
import dev.domain.Session;
import dev.domain.finance.BonCommande;
import dev.domain.finance.LigneCommande;
import dev.repository.BonCommandeRepo;
import dev.repository.SessionRepo;

@RestController
@CrossOrigin
public class SessionController {

	// Ici requêtes d'acces aux tables
	private SessionRepo sessionRepo;	
	private BonCommandeRepo bonCommandeRepo;	

	private static final Logger LOG = LoggerFactory.getLogger(dev.controller.SessionController.class);

	public SessionController(SessionRepo sessionRepo, BonCommandeRepo bonCommandeRepo) {
		this.sessionRepo 		= sessionRepo;
		this.bonCommandeRepo 	= bonCommandeRepo;
	}


	/** Rechercher la liste des sessions filtrées par : 
	*    - libellé : établissement / formation / certification 
	*                salle        / entreprise
	*    - période : date de début, date de fin
	* 
	* Attention :
	* Chaque filtre est optionnel.
	* 
	* Pour les libellés on peut saisir un sous libelle
	* Pour les dates de début et de fin de session il faut qu'il y ait chevauchement 
	* avec les dates de début et de fin de session
	* 
	* @return List<SessionLigne> : liste des lignes session à afficher
	*/
	@RequestMapping(method = RequestMethod.GET, path = "SessionsFiltres") 
	public List<SessionLigneVM> getSessionFiltreParCriteres( 
			@RequestParam("etablissement") 		String etablissement, 
            @RequestParam("formation") 			String formation,
            @RequestParam("certification") 		String certif,
            @RequestParam("salle") 				String salle,
            @RequestParam("entreprise") 		String entreprise,
            @RequestParam("dateDebutSession") 	String dateDebut,
			@RequestParam("dateFinSession") 	String dateFin) {
		
		LocalDate ldDateDebut 	;
		LocalDate ldDateFin	    ;
		
		LOG.info( "*** Filtrer les Sessions par : " );
		LOG.info( "   - établissement / formation / certif ==>" + etablissement + '/' + formation + '/' + certif); 
		LOG.info( "   - salle     / entreprise             ==>" + salle + '/'+ entreprise );
		if( dateDebut.trim().equals("")) {
			ldDateDebut 	= LocalDate.parse("2000-01-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		}else {
			ldDateDebut 	= LocalDate.parse(dateDebut, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		}
		if( dateFin.trim().equals("")) {
			ldDateFin	 	= LocalDate.parse("2040-01-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		}else {
			ldDateFin	 	= LocalDate.parse(dateFin, DateTimeFormatter.ofPattern("yyyy-MM-dd"));		
		}
		LOG.info( "   - dateDebut / dateFin                ==>" + ldDateDebut + '/' + ldDateFin  );
		
								  
		/** Récupérer les infos de la BD */
// OK		List<Session> listeSessionsRepo 	= this.sessionRepo.findByCentreNomStartingWith( etablissement );
// OK		List<Session> listeSessionsRepo 	= this.sessionRepo.findByDateDebutBetween( ldDateDebut, ldDateFin);
// OK		List<Session> listeSessionsRepo 	= this.sessionRepo.findByCentreNomStartingWithAndFormationNomStartingWith( etablissement, formation);
// OK		List<Session> listeSessionsRepo 	= this.sessionRepo.findByCentreNomStartingWithAndFormationNomStartingWithAndFormationNomCertificationStartingWith( etablissement, formation, certif );
// OK		List<Session> listeSessionsRepo 	= this.sessionRepo.findByCentreNomStartingWithAndFormationNomStartingWithAndFormationNomCertificationStartingWithAndSalleNomStartingWithAndSocieteNomStartingWith( etablissement, formation, certif, salle, entreprise );
		List<Session> listeSessionsRepo 		= this.sessionRepo.findByCentreNomStartingWithAndFormationNomStartingWithAndFormationNomCertificationStartingWithAndSalleNomStartingWithAndSocieteNomStartingWithAndDateDebutBetween( etablissement, formation, certif, salle, entreprise, ldDateDebut, ldDateFin);
		
		/** Intégrer les calculs dans la liste des sessions*/
		for( Session sessionLigne : listeSessionsRepo) {
			//** Calculer les couts financiers liés aux lignes de commandes */
			List<BonCommande> listeBonCommandeRepo 		= this.bonCommandeRepo.findBySession( sessionLigne);
			Float 	calcCoutTotalHT 			= 0.0f;		
			Float 	calcChiffreAffaireTotalHT 	= 0.0f;
			Float 	calcMargeBruteHT 			= 0.0f;
			Float 	calcPourMargeBrute 			= 0.0f;
			for( BonCommande listeBonCommande : listeBonCommandeRepo) {
				for( LigneCommande listeLigneCommande : listeBonCommande.getLignes()) {
					calcCoutTotalHT += listeLigneCommande.getMontantHT();
				}
			}
			sessionLigne.setCalcCoutTotalHT(calcCoutTotalHT);
			
			//** Calculer le CA financiers */
			sessionLigne.setCalcChiffreAffaireTotalHT(calcChiffreAffaireTotalHT);
			
			// En déduire la marge brute totale
			sessionLigne.setCalcMargeBruteHT(calcMargeBruteHT);
			
			// En déduire la pourcentage de marge brute totale
			sessionLigne.setCalcPourMargeBrute(calcPourMargeBrute);	
			
		} 
		
		/** Maj de la	 liste des session envoyée */
		List<SessionLigneVM> listeSessionVM = listeSessionsRepo.stream().map(session -> new SessionLigneVM( session)).collect( Collectors.toList());
		int 	indice 						= 0;
		for( SessionLigneVM sessionLigne : listeSessionVM) {
			// Gerer l'affichage des lignes sur le front
			if( indice % 2 == 0) {
				/** Ligne de session affichée en bleu */
				sessionLigne.setValeurAttributClasseLigne("divider");
			}else {
				/** Ligne de session affichée en blanc */
				sessionLigne.setValeurAttributClasseLigne("");
			}
			
			indice++;
			LOG.info( "*** Nom de session / salle : " 
					+ sessionLigne.getNomSession() + " / " + sessionLigne.getNomSalleFormation());

		}
		
		/** Renvoyer au front les résultats */
		return listeSessionVM ;
	}


}
