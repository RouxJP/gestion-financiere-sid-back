package dev.domain;

/**
 * Représente les évènements par défaut qu'on va notamment faire apparaitre dans le composant
 * calendrier.
 * 
 * @author DIGINAMIC
 *
 */
public enum TypeEvenement {

	/** CONGE_OFFICIEL : Congé officiel */
	CONGE_OFFICIEL("Congé officiel"),
	/** FERMETURE : Fermeture Diginamic */
	FERMETURE("Fermeture Diginamic"),
	/** INDISPO_SESSION : Fermeture session */
	INDISPO_SESSION("Fermeture session"),
	/** INDISPO_FORMATEUR : Indisponiblité formateur */
	INDISPO_FORMATEUR("Indisponiblité formateur"),
	/** INDISPO_SALLE : Indisponibilité de la salle */
	INDISPO_SALLE("Indisponibilité de la salle"),
	/** SESSION : Session */
	SESSION("Session"),
	/** COURS : Cours */
	COURS("Cours");

	/** libelle : String */
	private String libelle;

	/**
	 * Constructor
	 * 
	 * @param libelle libellé
	 */
	private TypeEvenement(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Recherche un type d'évènement par libellé
	 * 
	 * @param libelle libellé
	 * @return {@link TypeEvenement}
	 */
	public static TypeEvenement findByLibelle(String libelle) {

		for (TypeEvenement type : values()) {
			if (type.getLibelle().equals(libelle)) {
				return type;
			}
		}
		return null;
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
