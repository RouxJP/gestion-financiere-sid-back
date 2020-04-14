package dev.controller.vm;

import java.time.LocalDate;

import dev.domain.Session;

/**
 * Structure modèlisant une session servant à communiquer avec la WEB API : liste des sessions
 */
public class SessionLigneVM {

	/** Identifiant de la session */
	private String nomSession;
	
	/** Nom du Centre */
	private String nomCentre;

	/** Nom de la ,formation */
	private String nomFormation;

	/** Nom de la certification */
	private String nomCertification;

	/** Nom de la salle de formation : si il y en a plusieurs on affiche celle qui représente le plus de jour */
	private String nomSalleFormation;

	/** Nombre de jour de la formation */
	private Integer nbrJoursFormation;

	/** Nombre de stagiaire de la formation : moyenne des stagiaires de la session au prorata du temps passé */
	private Integer nbrStagiairesFormation;

	/** Si les stagiaires proviennent de différentes entreprises on appelle ça une session inter-entreprises. */
	/** On met le nom de l'entreprise si il y en a qu'une, sinon INTER */
	private String nomSociete;
	
	/** Date de début de la session */
	private LocalDate dateDebutSession;

	/** Date de fin de la session */
	private LocalDate dateFinSession;

	/** Total des couts HT de la session  */
	private Float totCout_HT;

	/** Total du chiffre d'affaire HT de la session  */
	private Float tot_CA_HT;

	/** Marge brute HT de la session  */
	private Float margeBrute_HT;

	/** Pourcentage de marge brute de la session  */
	private Float pourcMargeBrute;

	/** Valeur de l'attribut class de la ligne de session */
	private String valeurAttributClasseLigne;
	
	/**
	* @param pourcMargeBrute
	*/
	public SessionLigneVM( Session session) {
		super();
		this.nomSession 						= session.getNom();
		this.nomCentre 							= session.getCentre().getNom();
		this.nomFormation	 					= session.getFormation().getNom();
		this.nomCertification 					= session.getFormation().getNomCertification();
		this.nbrJoursFormation 					= session.getFormation().getDuree();
		this.dateDebutSession 					= session.getDateDebut();
		this.dateFinSession 					= session.getDateFin();
		this.valeurAttributClasseLigne			= "";
		
		/** Calculs financiers */
		this.nomSociete 						= session.calculerNomSociete()	;	

		/** TODO */
		this.nomSalleFormation 					= session.getCalcSalleFormation();
		this.nbrStagiairesFormation 			= session.getCalcNbrStagiairesFormation();
		this.totCout_HT 						= session.getCalcCoutTotalHT();
		this.tot_CA_HT 							= session.getCalcChiffreAffaireTotalHT();
		this.margeBrute_HT 						= session.getCalcMargeBruteHT();
		this.pourcMargeBrute 					= session.getCalcPourMargeBrute();
	}
	
		
	/** Getter
	 * @return the nomSession
	 */
	public String getNomSession() {
		return nomSession;
	}

	/** Setter
	 * @param nomSession the nomSession to set
	 */
	public void setNomSession(String nomSession) {
		this.nomSession = nomSession;
	}

	/** Getter
	 * @return the nomCentre
	 */
	public String getNomCentre() {
		return nomCentre;
	}

	/** Setter
	 * @param nomCentre the nomCentre to set
	 */
	public void setNomCentre(String nomCentre) {
		this.nomCentre = nomCentre;
	}

	/** Getter
	 * @return the nomFormation
	 */
	public String getNomFormation() {
		return nomFormation;
	}
	/** Setter
	 * @param nomFormation the nomFormation to set
	 */
	public void setNomFormation(String nomFormation) {
		this.nomFormation = nomFormation;
	}
	/** Getter
	 * @return the nomCertification
	 */
	public String getNomCertification() {
		return nomCertification;
	}

	/** Setter
	 * @param nomCertification the nomCertification to set
	 */
	public void setNomCertification(String nomCertification) {
		this.nomCertification = nomCertification;
	}

	/** Getter
	 * @return the nomSalleFormation
	 */
	public String getNomSalleFormation() {
		return nomSalleFormation;
	}

	/** Setter
	 * @param nomSalleFormation the nomSalleFormation to set
	 */
	public void setNomSalleFormation(String nomSalleFormation) {
		this.nomSalleFormation = nomSalleFormation;
	}

	/** Getter
	 * @return the nbrJoursFormation
	 */
	public Integer getNbrJoursFormation() {
		return nbrJoursFormation;
	}

	/** Setter
	 * @param nbrJoursFormation the nbrJoursFormation to set
	 */
	public void setNbrJoursFormation(Integer nbrJoursFormation) {
		this.nbrJoursFormation = nbrJoursFormation;
	}

	/** Getter
	 * @return the nbrStagiairesFormation
	 */
	public Integer getNbrStagiairesFormation() {
		return nbrStagiairesFormation;
	}

	/** Setter
	 * @param nbrStagiairesFormation the nbrStagiairesFormation to set
	 */
	public void setNbrStagiairesFormation(Integer nbrStagiairesFormation) {
		this.nbrStagiairesFormation = nbrStagiairesFormation;
	}

	/** Getter
	 * @return the nomSociete
	 */
	public String getNomSociete() {
		return nomSociete;
	}

	/** Setter
	 * @param nomSociete the nomSociete to set
	 */
	public void setNomSociete(String nomSociete) {
		this.nomSociete = nomSociete;
	}

	/** Getter
	 * @return the dateDebutSession
	 */
	public LocalDate getDateDebutSession() {
		return dateDebutSession;
	}

	/** Setter
	 * @param dateDebutSession the dateDebutSession to set
	 */
	public void setDateDebutSession(LocalDate dateDebutSession) {
		this.dateDebutSession = dateDebutSession;
	}

	/** Getter
	 * @return the dateFinSession
	 */
	public LocalDate getDateFinSession() {
		return dateFinSession;
	}

	/** Setter
	 * @param dateFinSession the dateFinSession to set
	 */
	public void setDateFinSession(LocalDate dateFinSession) {
		this.dateFinSession = dateFinSession;
	}

	/** Getter
	 * @return the totCout_HT
	 */
	public Float getTotCout_HT() {
		return totCout_HT;
	}

	/** Setter
	 * @param totCout_HT the totCout_HT to set
	 */
	public void setTotCout_HT(Float totCout_HT) {
		this.totCout_HT = totCout_HT;
	}

	/** Getter
	 * @return the tot_CA_HT
	 */
	public Float getTot_CA_HT() {
		return tot_CA_HT;
	}

	/** Setter
	 * @param tot_CA_HT the tot_CA_HT to set
	 */
	public void setTot_CA_HT(Float tot_CA_HT) {
		this.tot_CA_HT = tot_CA_HT;
	}

	/** Getter
	 * @return the margeBrute_HT
	 */
	public Float getMargeBrute_HT() {
		return margeBrute_HT;
	}

	/** Setter
	 * @param margeBrute_HT the margeBrute_HT to set
	 */
	public void setMargeBrute_HT(Float margeBrute_HT) {
		this.margeBrute_HT = margeBrute_HT;
	}

	/** Getter
	 * @return the pourcMargeBrute
	 */
	public Float getPourcMargeBrute() {
		return pourcMargeBrute;
	}

	/** Setter
	 * @param pourcMargeBrute the pourcMargeBrute to set
	 */
	public void setPourcMargeBrute(Float pourcMargeBrute) {
		this.pourcMargeBrute = pourcMargeBrute;
	}


	/** Getter
	 * @return the valeurAttributClasseLigne
	 */
	public String getValeurAttributClasseLigne() {
		return valeurAttributClasseLigne;
	}


	/** Setter
	 * @param valeurAttributClasseLigne the valeurAttributClasseLigne to set
	 */
	public void setValeurAttributClasseLigne(String valeurAttributClasseLigne) {
		this.valeurAttributClasseLigne = valeurAttributClasseLigne;
	}


   

}
