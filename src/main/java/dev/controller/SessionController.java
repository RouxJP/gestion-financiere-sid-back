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
import dev.domain.CoursPlanifie;
import dev.domain.Session;
import dev.domain.SessionStagiaire;
import dev.repository.CoursPlanifieRepo;
import dev.repository.SessionRepo;
import dev.repository.SessionStagiaireRepo;

/**
 * Ensemble des API pour communiquer avec le front pour la liste des sessions
 * 
 * @author JP ROUX
 * 
 */

@RestController
@CrossOrigin
public class SessionController {

	// Ici requêtes d'acces aux tables
	private SessionRepo 			sessionRepo;	
	private SessionStagiaireRepo 	sessionStagiaireRepo;	
	private CoursPlanifieRepo 		coursPlanifieRepo;	

	private static final Logger LOG = LoggerFactory.getLogger(dev.controller.SessionController.class);

	public SessionController(	SessionRepo 			sessionRepo, 
								CoursPlanifieRepo 		coursPlanifieRepo,
								SessionStagiaireRepo 	sessionStagiaireRepo) {
		this.sessionRepo 			= sessionRepo;		
		this.coursPlanifieRepo 		= coursPlanifieRepo;
		this.sessionStagiaireRepo 	= sessionStagiaireRepo;
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
// OK		List<Session> listeSessionsRepo 		= this.sessionRepo.findByCentreNomStartingWithAndFormationNomStartingWithAndFormationNomCertificationStartingWithAndSalleNomStartingWithAndSocieteNomStartingWithAndDateDebutBetweenOrDateFinBetween( etablissement, formation, certif, salle, entreprise, ldDateDebut, ldDateFin, ldDateDebut, ldDateFin);
		List<Session> listeSessionsRepo1 		= this.sessionRepo.findByCentreNomStartingWithAndFormationNomStartingWithAndFormationNomCertificationStartingWithAndSalleNomStartingWithAndSocieteNomStartingWithAndDateDebutBetween( etablissement, formation, certif, salle, entreprise, ldDateDebut, ldDateFin );
		List<Session> listeSessionsRepo2 		= this.sessionRepo.findByCentreNomStartingWithAndFormationNomStartingWithAndFormationNomCertificationStartingWithAndSalleNomStartingWithAndSocieteNomStartingWithAndDateFinBetween( etablissement, formation, certif, salle, entreprise, ldDateDebut, ldDateFin );
		LOG.info( "listeSessionsRepo1 : " + listeSessionsRepo1.size()); 
		LOG.info( "listeSessionsRepo2 : " + listeSessionsRepo2.size());
		/** La 2ème liste est concaténée à la première */
		for( Session session2 : listeSessionsRepo2) {
			boolean dejaPresente = false ;
			for( Session session1 : listeSessionsRepo1) {
				if( session1.getId() == session2.getId()) {
					dejaPresente = true;
					break;
				}
			}
			if( ! dejaPresente) {
				listeSessionsRepo1.add( session2);
			}
		}

		
		/** Intégrer les calculs dans la liste des sessions*/
		for( Session sessionLigne : listeSessionsRepo1) {
			/** Calculer la societe, la salle, la moyenne de stagiaire */
			sessionLigne.setCalcNomSociete( sessionLigne.calculerNomSociete());
			sessionLigne.setCalcSalleFormation( sessionLigne.calculerSalleFormation( sessionLigne.getNom()));
			sessionLigne.setCalcNbrStagiairesFormation( sessionLigne.calculerMoyenneStagiairesFormation());
			
			/** Calculer les coûts HT, CA HT et marges */
			Float 	calcCoutTotalHT 			= 0.0f;		
			Float 	calcChiffreAffaireTotalHT 	= 0.0f;
			Float 	calcMargeBruteHT 			= 0.0f;
			Float 	calcPourMargeBrute 			= 0.0f;
			
			// *** Calculer le coût HT  d'une session */
			List<CoursPlanifie> coursPlanifies = this.coursPlanifieRepo.findBySession( sessionLigne) ;
			for( CoursPlanifie coursPlanifie : coursPlanifies ) {
				calcCoutTotalHT += coursPlanifie.calc_Cout_HT_coursPlanifie();
				LOG.info( "Session-Formatteur-Cout : " + 
						coursPlanifie.getSession().getId() + " - " +
						coursPlanifie.getFormateur().getId()  + " - " +
						coursPlanifie.calc_Cout_HT_coursPlanifie());
			}
			sessionLigne.setCalcCoutTotalHT( calcCoutTotalHT);
			
			//** Calculer le CA HT de la session */
			List<SessionStagiaire> sessionStagiaires = this.sessionStagiaireRepo.findBySession( sessionLigne) ;
			for( SessionStagiaire sessionStagiaire : sessionStagiaires ) {
				calcChiffreAffaireTotalHT += sessionStagiaire.calc_CA_HT_typeFinChoisiStagiaire();
				LOG.info( "Session-Stagiaire-CA : " + 
						sessionStagiaire.getSession().getId() + " - " +
						sessionStagiaire.getStagiaire().getId() + " - " +
						sessionStagiaire.calc_CA_HT_typeFinChoisiStagiaire());
			}
			sessionLigne.setCalcChiffreAffaireTotalHT( calcChiffreAffaireTotalHT);
			
			// En déduire la marge brute totale
			calcMargeBruteHT = calcChiffreAffaireTotalHT - calcCoutTotalHT ;
			sessionLigne.setCalcMargeBruteHT( calcMargeBruteHT);
			
			// En déduire la pourcentage de marge brute totale
			calcPourMargeBrute = calcMargeBruteHT/ calcChiffreAffaireTotalHT;
			sessionLigne.setCalcPourMargeBrute( calcPourMargeBrute);	
						
		} 
		
		/** Gérér l'affichage des lignes de sessions en blanc/bleu */
		/** Calculer les totaux */
		List<SessionLigneVM> listeSessionVM = listeSessionsRepo1.stream().map(session -> new SessionLigneVM( session)).collect( Collectors.toList());
		int 	indice 						= 0;
		int		totNbrFormation          	= 0 ;
		int		totJourFormation          	= 0 ;
		Float	totStagiaireFormation       = 0.0f ;
		Float	tot_CA_HT_Formation         = 0.0f ;
		Float	tot_Cout_HT_Formation       = 0.0f ;
		
		for( SessionLigneVM sessionLigne : listeSessionVM) {
			// Gerer l'affichage des lignes sur le front
			if( indice % 2 == 0) {
				/** Ligne de session affichée en bleu */
				sessionLigne.setValeurAttributClasseLigne("divider");
			}else {
				/** Ligne de session affichée en blanc */
				sessionLigne.setValeurAttributClasseLigne("");
			}

			/** Calculer les totaux */
			totNbrFormation++ ;
			totJourFormation          	+= sessionLigne.getNbrJoursFormation() ;
			totStagiaireFormation       += sessionLigne.getNbrStagiairesFormation() ;
			tot_CA_HT_Formation         += sessionLigne.getTot_CA_HT() ;
			tot_Cout_HT_Formation       += sessionLigne.getTotCout_HT() ;
					
			indice++;
			LOG.info( "*** Nom de session / salle : " 
					+ sessionLigne.getNomSession() + " / " + sessionLigne.getNomSalleFormation());

		}
		Float	totMargeBrute_HT		= 0.0f;
		Float	pourcTotMargeBrute_HT	= 0.0f;
		
		totMargeBrute_HT= tot_CA_HT_Formation - tot_Cout_HT_Formation ;
		pourcTotMargeBrute_HT= totMargeBrute_HT /  tot_CA_HT_Formation ;
		
		SessionLigneVM 	sessionLigneTotaux 	= 
				new SessionLigneVM( 
						String.valueOf( totNbrFormation), 
						totJourFormation, 		tot_Cout_HT_Formation,
						tot_CA_HT_Formation,	totMargeBrute_HT, 		pourcTotMargeBrute_HT,
						totStagiaireFormation);
		listeSessionVM.add( sessionLigneTotaux) ;
		
		/** Renvoyer au front les résultats */
		return listeSessionVM ;
	}



}
