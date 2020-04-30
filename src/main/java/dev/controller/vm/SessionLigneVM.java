package dev.controller.vm;

import java.time.LocalDate;
import java.util.Locale;

import dev.domain.Session;

/**
 * Structure modèlisant une session servant à communiquer avec la WEB API : liste des sessions
 * 
 * @author JP ROUX
 * 
 */
public class SessionLigneVM {
	private static final String FORMAT_MNT 			= "%,5.0f";
	private static final String FORMAT_MNT_TOTAL 	= "%,7.0f";
	
	
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
	private Float nbrStagiairesFormation;

	/** Si les stagiaires proviennent de différentes entreprises on appelle ça une session inter-entreprises. */
	/** On met le nom de l'entreprise si il y en a qu'une, sinon INTER */
	private String nomSociete;
	
	/** Date de début de la session */
	private LocalDate dateDebutSession;

	/** Date de fin de la session */
	private LocalDate dateFinSession;

	/** Total des couts HT de la session  */
	private Float 	totCout_HT;
	private String 	libTotCout_HT;

	/** Total du chiffre d'affaire HT de la session  */
	private Float 	tot_CA_HT;
	private String 	libTot_CA_HT;

	/** Marge brute HT de la session  */
	private Float 	margeBrute_HT;
	private String 	libMargeBrute_HT;

	/** Pourcentage de marge brute de la session  */
	private Float 	pourcMargeBrute;

	/** Valeur de l'attribut class de la ligne de session */
	private String valeurAttributClasseLigne;
	
	/** Valeur de l'attribut class de td utile pour la dernière ligne ( les totaux) */
	private String valeurAttributTd;
	
	
	/**
	 * Constructeur
	 * 
	* @param Session session
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
		this.valeurAttributTd					= "";
		
		/** Calculs financiers */
		this.totCout_HT							= session.getCalcCoutTotalHT();
		this.libTotCout_HT 						= String.format( Locale.FRANCE, FORMAT_MNT,  session.getCalcCoutTotalHT()).concat( " €");

		this.tot_CA_HT 							= session.getCalcChiffreAffaireTotalHT();
		this.libTot_CA_HT 						= String.format( Locale.FRANCE, FORMAT_MNT,  session.getCalcChiffreAffaireTotalHT()).concat( " €");
		
		this.margeBrute_HT 						= session.getCalcMargeBruteHT();
		this.libMargeBrute_HT 					= String.format( Locale.FRANCE, FORMAT_MNT,  session.getCalcMargeBruteHT()).concat( " €");

		this.pourcMargeBrute 					= (float) Math.round(100 * session.getCalcPourMargeBrute());
	
		this.nomSociete 						= session.getCalcNomSociete();
		this.nomSalleFormation					= session.getCalcSalleFormation();
		this.nbrStagiairesFormation 			= session.getCalcNbrStagiairesFormation();
		
	}
	
	/**
	 * Constructeur pour la dernière ligne : totaux
	 * 
	* @param Session session
	*/
	public SessionLigneVM ( 
			String 	totNbrFormations, 	int 	totNbrJoursFormation, 	Float 	totCout_HT,
			Float	tot_CA_HT,			Float	totMargeBrute_HT, 		Float	pourcTotMargeBrute_HT,
			Float	totNbrStagiairesFormation) {
		super();

		this.nomSession 						= "TOTAL";
		this.nomCentre 							= totNbrFormations + " formations";
		this.nomFormation	 					= "";
		this.nomCertification 					= "";
		this.nbrJoursFormation 					= totNbrJoursFormation;
		this.dateDebutSession 					= null;
		this.dateFinSession 					= null;
		this.valeurAttributClasseLigne			= "bg-dgn";
		this.valeurAttributTd					= "ltr";
		
		/** Calculs financiers */
		this.totCout_HT							= totCout_HT;
		this.libTotCout_HT 						= String.format( Locale.FRANCE, FORMAT_MNT_TOTAL,  totCout_HT).concat( " €");
		
		this.tot_CA_HT 							= tot_CA_HT;
		this.libTot_CA_HT 						= String.format( Locale.FRANCE, FORMAT_MNT_TOTAL,  tot_CA_HT).concat( " €");
		
		this.margeBrute_HT 						= totMargeBrute_HT;
		this.libMargeBrute_HT 					= String.format( Locale.FRANCE, FORMAT_MNT_TOTAL,  totMargeBrute_HT).concat( " €");
		
		this.pourcMargeBrute 					= (float) Math.round(100 * pourcTotMargeBrute_HT);
	
		this.nomSociete 						= "";
		this.nomSalleFormation					= "";
		this.nbrStagiairesFormation 			= totNbrStagiairesFormation;
		
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
	public Float getNbrStagiairesFormation() {
		return nbrStagiairesFormation;
	}

	/** Setter
	 * @param nbrStagiairesFormation the nbrStagiairesFormation to set
	 */
	public void setNbrStagiairesFormation(Float nbrStagiairesFormation) {
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
	 * @return the libTotCout_HT
	 */
	public String getLibTotCout_HT() {
		return libTotCout_HT;
	}

	/** Setter
	 * @param libTotCout_HT the libTotCout_HT to set
	 */
	public void setLibTotCout_HT(String libTotCout_HT) {
		this.libTotCout_HT = libTotCout_HT;
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
	 * @return the libTot_CA_HT
	 */
	public String getLibTot_CA_HT() {
		return libTot_CA_HT;
	}

	/** Setter
	 * @param libTot_CA_HT the libTot_CA_HT to set
	 */
	public void setLibTot_CA_HT(String libTot_CA_HT) {
		this.libTot_CA_HT = libTot_CA_HT;
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
	 * @return the libMargeBrute_HT
	 */
	public String getLibMargeBrute_HT() {
		return libMargeBrute_HT;
	}

	/** Setter
	 * @param libMargeBrute_HT the libMargeBrute_HT to set
	 */
	public void setLibMargeBrute_HT(String libMargeBrute_HT) {
		this.libMargeBrute_HT = libMargeBrute_HT;
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

	/** Getter
	 * @return the valeurAttributTd
	 */
	public String getValeurAttributTd() {
		return valeurAttributTd;
	}

	/** Setter
	 * @param valeurAttributTd the valeurAttributTd to set
	 */
	public void setValeurAttributTd(String valeurAttributTd) {
		this.valeurAttributTd = valeurAttributTd;
	}


}
