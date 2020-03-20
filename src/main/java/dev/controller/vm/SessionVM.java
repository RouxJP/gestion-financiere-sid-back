package dev.controller.vm;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dev.domain.Centre;
import dev.domain.CoursPlanifie;
import dev.domain.Formation;
import dev.domain.PeriodeFermeeSession;
import dev.domain.Salle;
import dev.domain.Session;
import dev.domain.Societe;
import dev.domain.StatutPreparation;
import dev.domain.StatutValidation;
import dev.domain.Utilisateur;
import dev.domain.notation.BilanSession;

/**
 * Structure modèlisant une session servant à communiquer avec l'extérieur (WEB API).
 */
public class SessionVM {

	/** Identifiant session */
	private Long id;

	/** centre : Centre */
	private Centre centre;

	/** societe : Societe */
	private Societe societe;

	/** Nom de la session */
	private String nom;

	/** Date de début */
	private LocalDate dateDebut;

	/** Date de fin */
	private LocalDate dateFin;

	/** Formation */
	private Formation formation;

	/** Liste des cours */
	private List<CoursPlanifie> cours = new ArrayList<>();

	/** Liste des dates fermées spécifique pour cette session */
	private List<PeriodeFermeeSession> fermes = new ArrayList<>();

	/** bilans : List de BilanSession */
	private List<BilanSession> bilans = new ArrayList<>();

	/** Salle d'informatique par défaut dans laquelle aura lieu la formation */
	private Salle salle;

	/** dateMaj : LocalDateTime */
	private LocalDateTime dateMaj;

	/** userMaj : String */
	private String userMaj;

	/** previous : Session */
	private Long idPrevious;

	/** parent : Session */
	private Long idParent;

	/** next : Session */
	private Long idNext;

	/** statutValidation : StatutValidation */
	private StatutValidation statutValidation;

	/** statutPreparation : StatutPreparation */
	private StatutPreparation statutPreparation;

	/** stagiaires : List de Utilisateur */
	private Set<Utilisateur> stagiaires = new HashSet<>();

	/** planificateurs : List de Utilisateur */
	private Set<Utilisateur> planificateurs = new HashSet<>();

	/** staffé sans : boolean */
	private boolean staffeSansConflit;

	/** nbBilans : Integer */
	private Integer nbBilans = 3;

	/** synthese : String */
	private String synthese;

	/** nbStagiaires : Integer */
	private Integer nbStagiaires;

	/** calculMoyenneParBlocs : boolean */
	private String calculMoyenneParBlocs;

	
    public SessionVM(Long id, Centre centre, Societe societe, String nom, LocalDate dateDebut, LocalDate dateFin,
			Formation formation, List<CoursPlanifie> cours, List<PeriodeFermeeSession> fermes,
			List<BilanSession> bilans, Salle salle, LocalDateTime dateMaj, String userMaj, Long idPrevious,
			Long idParent, Long idNext, StatutValidation statutValidation, StatutPreparation statutPreparation,
			Set<Utilisateur> stagiaires, Set<Utilisateur> planificateurs, boolean staffeSansConflit, Integer nbBilans,
			String synthese, Integer nbStagiaires, String calculMoyenneParBlocs) {
		super();
		this.id = id;
		this.centre = centre;
		this.societe = societe;
		this.nom = nom;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.formation = formation;
		this.cours = cours;
		this.fermes = fermes;
		this.bilans = bilans;
		this.salle = salle;
		this.dateMaj = dateMaj;
		this.userMaj = userMaj;
		this.idPrevious = idPrevious;
		this.idParent = idParent;
		this.idNext = idNext;
		this.statutValidation = statutValidation;
		this.statutPreparation = statutPreparation;
		this.stagiaires = stagiaires;
		this.planificateurs = planificateurs;
		this.staffeSansConflit = staffeSansConflit;
		this.nbBilans = nbBilans;
		this.synthese = synthese;
		this.nbStagiaires = nbStagiaires;
		this.calculMoyenneParBlocs = calculMoyenneParBlocs;
	}

    public SessionVM( Session session) {
 		super();
 		this.centre = session.getCentre();
 		this.societe = session.getSociete() ;
 		this.nom = session.getNom() ;;
 		this.dateDebut = session.getDateDebut();
 		this.dateFin = session.getDateFin();
 		this.formation = session.getFormation();
 		this.cours = session.getCours() ;
 		this.fermes = session.getFermes() ;
 		this.bilans = session.getBilans() ;
 		this.salle = session.getSalle();
 		this.dateMaj = session.getDateMaj() ;
 		this.userMaj = session.getUserMaj() ;
 		this.idPrevious = session.getIdPrevious() ;
 		this.idParent = session.getIdParent() ;
 		this.idNext = session.getIdNext() ;
 		this.statutValidation = session.getStatutValidation() ;
 		this.statutPreparation = session.getStatutPreparation() ;
 		this.stagiaires  = session.getStagiaires() ;
 		this.planificateurs  = session.getPlanificateurs() ;
 		this.staffeSansConflit  = session.isStaffeSansConflit() ;
 		this.nbBilans  = session.getNbBilans() ;
 		this.synthese  = session.getSynthese(); 
 		this.nbStagiaires  = session.getNbStagiaires(); 
 		this.calculMoyenneParBlocs  = session.getCalculMoyenneParBlocs(); 	}

	

	/** Getter
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/** Setter
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/** Getter
	 * @return the centre
	 */
	public Centre getCentre() {
		return centre;
	}


	/** Setter
	 * @param centre the centre to set
	 */
	public void setCentre(Centre centre) {
		this.centre = centre;
	}


	/** Getter
	 * @return the societe
	 */
	public Societe getSociete() {
		return societe;
	}


	/** Setter
	 * @param societe the societe to set
	 */
	public void setSociete(Societe societe) {
		this.societe = societe;
	}


	/** Getter
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}


	/** Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}


	/** Getter
	 * @return the dateDebut
	 */
	public LocalDate getDateDebut() {
		return dateDebut;
	}


	/** Setter
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}


	/** Getter
	 * @return the dateFin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}


	/** Setter
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}


	/** Getter
	 * @return the formation
	 */
	public Formation getFormation() {
		return formation;
	}


	/** Setter
	 * @param formation the formation to set
	 */
	public void setFormation(Formation formation) {
		this.formation = formation;
	}


	/** Getter
	 * @return the cours
	 */
	public List<CoursPlanifie> getCours() {
		return cours;
	}


	/** Setter
	 * @param cours the cours to set
	 */
	public void setCours(List<CoursPlanifie> cours) {
		this.cours = cours;
	}


	/** Getter
	 * @return the fermes
	 */
	public List<PeriodeFermeeSession> getFermes() {
		return fermes;
	}


	/** Setter
	 * @param fermes the fermes to set
	 */
	public void setFermes(List<PeriodeFermeeSession> fermes) {
		this.fermes = fermes;
	}


	/** Getter
	 * @return the bilans
	 */
	public List<BilanSession> getBilans() {
		return bilans;
	}


	/** Setter
	 * @param bilans the bilans to set
	 */
	public void setBilans(List<BilanSession> bilans) {
		this.bilans = bilans;
	}


	/** Getter
	 * @return the salle
	 */
	public Salle getSalle() {
		return salle;
	}


	/** Setter
	 * @param salle the salle to set
	 */
	public void setSalle(Salle salle) {
		this.salle = salle;
	}


	/** Getter
	 * @return the dateMaj
	 */
	public LocalDateTime getDateMaj() {
		return dateMaj;
	}


	/** Setter
	 * @param dateMaj the dateMaj to set
	 */
	public void setDateMaj(LocalDateTime dateMaj) {
		this.dateMaj = dateMaj;
	}


	/** Getter
	 * @return the userMaj
	 */
	public String getUserMaj() {
		return userMaj;
	}


	/** Setter
	 * @param userMaj the userMaj to set
	 */
	public void setUserMaj(String userMaj) {
		this.userMaj = userMaj;
	}


	/** Getter
	 * @return the idPrevious
	 */
	public Long getIdPrevious() {
		return idPrevious;
	}


	/** Setter
	 * @param idPrevious the idPrevious to set
	 */
	public void setIdPrevious(Long idPrevious) {
		this.idPrevious = idPrevious;
	}


	/** Getter
	 * @return the idParent
	 */
	public Long getIdParent() {
		return idParent;
	}


	/** Setter
	 * @param idParent the idParent to set
	 */
	public void setIdParent(Long idParent) {
		this.idParent = idParent;
	}


	/** Getter
	 * @return the idNext
	 */
	public Long getIdNext() {
		return idNext;
	}


	/** Setter
	 * @param idNext the idNext to set
	 */
	public void setIdNext(Long idNext) {
		this.idNext = idNext;
	}


	/** Getter
	 * @return the statutValidation
	 */
	public StatutValidation getStatutValidation() {
		return statutValidation;
	}


	/** Setter
	 * @param statutValidation the statutValidation to set
	 */
	public void setStatutValidation(StatutValidation statutValidation) {
		this.statutValidation = statutValidation;
	}


	/** Getter
	 * @return the statutPreparation
	 */
	public StatutPreparation getStatutPreparation() {
		return statutPreparation;
	}


	/** Setter
	 * @param statutPreparation the statutPreparation to set
	 */
	public void setStatutPreparation(StatutPreparation statutPreparation) {
		this.statutPreparation = statutPreparation;
	}


	/** Getter
	 * @return the stagiaires
	 */
	public Set<Utilisateur> getStagiaires() {
		return stagiaires;
	}


	/** Setter
	 * @param stagiaires the stagiaires to set
	 */
	public void setStagiaires(Set<Utilisateur> stagiaires) {
		this.stagiaires = stagiaires;
	}


	/** Getter
	 * @return the planificateurs
	 */
	public Set<Utilisateur> getPlanificateurs() {
		return planificateurs;
	}


	/** Setter
	 * @param planificateurs the planificateurs to set
	 */
	public void setPlanificateurs(Set<Utilisateur> planificateurs) {
		this.planificateurs = planificateurs;
	}


	/** Getter
	 * @return the staffeSansConflit
	 */
	public boolean isStaffeSansConflit() {
		return staffeSansConflit;
	}


	/** Setter
	 * @param staffeSansConflit the staffeSansConflit to set
	 */
	public void setStaffeSansConflit(boolean staffeSansConflit) {
		this.staffeSansConflit = staffeSansConflit;
	}


	/** Getter
	 * @return the nbBilans
	 */
	public Integer getNbBilans() {
		return nbBilans;
	}


	/** Setter
	 * @param nbBilans the nbBilans to set
	 */
	public void setNbBilans(Integer nbBilans) {
		this.nbBilans = nbBilans;
	}


	/** Getter
	 * @return the synthese
	 */
	public String getSynthese() {
		return synthese;
	}


	/** Setter
	 * @param synthese the synthese to set
	 */
	public void setSynthese(String synthese) {
		this.synthese = synthese;
	}


	/** Getter
	 * @return the nbStagiaires
	 */
	public Integer getNbStagiaires() {
		return nbStagiaires;
	}


	/** Setter
	 * @param nbStagiaires the nbStagiaires to set
	 */
	public void setNbStagiaires(Integer nbStagiaires) {
		this.nbStagiaires = nbStagiaires;
	}


	/** Getter
	 * @return the calculMoyenneParBlocs
	 */
	public String getCalculMoyenneParBlocs() {
		return calculMoyenneParBlocs;
	}


	/** Setter
	 * @param calculMoyenneParBlocs the calculMoyenneParBlocs to set
	 */
	public void setCalculMoyenneParBlocs(String calculMoyenneParBlocs) {
		this.calculMoyenneParBlocs = calculMoyenneParBlocs;
	}



}
