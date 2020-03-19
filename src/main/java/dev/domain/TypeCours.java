package dev.domain;

/**
 * Représente les grands types de cours dispensés chez Diginamic
 * 
 * @author DIGINAMIC
 *
 */
public enum TypeCours {

	/** TECHNIQUE : TypeCours */
	TECHNIQUE("Technique"),
	/** TECHNIQUE_PRATIQUE : TypeCours */
	TECHNIQUE_PRATIQUE("Technique pratique"),
	/** TECHNIQUE_PRATIQUE : TypeCours */
	TECHNIQUE_THEORIQUE("Technique théorique"),
	/** COMMUNICATION : TypeCours */
	COMMUNICATION("Communication"),
	/** COMMUNICATION1 : TypeCours */
	COMMUNICATION1("Communication 1"),
	/** COMMUNICATION : TypeCours */
	COMMUNICATION2("Communication 2"),
	/** COMMUNICATION : TypeCours */
	SAVOIR_ETRE_BILAN("Savoir-être bilan"),
	/** TECHNIQUE : TypeCours */
	PRESENTATION("Présentation"),
	/** ANGLAIS : TypeCours */
	ANGLAIS("Anglais"),
	/** ANGLAIS : TypeCours */
	ENTREPRISE("Entreprise"),
	/** PREPARATION_ENTRETIEN : TypeCours */
	PREPARATION_ENTRETIEN("Préparation entretien");

	/** libelle : String */
	private String libelle;

	/**
	 * Constructor
	 * 
	 * @param libelle libellé
	 */
	private TypeCours(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Getter
	 * 
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * Setter
	 * 
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
