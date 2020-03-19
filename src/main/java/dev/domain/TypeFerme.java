package dev.domain;

/**
 * Représente les types de jours fermés
 * 
 * @author DIGINAMIC
 *
 */
public enum TypeFerme {

	/** FERME_DIGINAMIC : Fermeture Diginamic */
	FERME_DIGINAMIC("Fermeture Diginamic"),
	/** FERME_SESSION : Fermeture Session */
	FERME_SESSION("Fermeture Session"),
	/** FERME_UTLISATEUR : Congé/Indisponibilité utilisateur */
	FERME_UTILISATEUR("Congés");

	/** libelle : String */
	private String libelle;

	/**
	 * Constructor
	 * 
	 * @param libelle libellé
	 */
	private TypeFerme(String libelle) {
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
