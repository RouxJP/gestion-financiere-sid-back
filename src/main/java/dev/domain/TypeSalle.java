package dev.domain;

/**
 * Les divers types de salles
 * 
 * @author DIGINAMIC
 *
 */
public enum TypeSalle {

	/** COMMUNICATION : TypeSalle */
	COMMUNICATION("Communication"),

	/** INFORMATIQUE : TypeSalle */
	INFORMATIQUE("Informatique");

	/** libelle : String */
	private String libelle;

	/**
	 * Constructeur
	 * 
	 * @param libelle
	 *            libellé
	 */
	private TypeSalle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Getter for libelle
	 * 
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * Setter
	 * 
	 * @param libelle
	 *            the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}
