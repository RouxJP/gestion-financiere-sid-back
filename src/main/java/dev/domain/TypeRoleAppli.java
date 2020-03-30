package dev.domain;

/**
 * @author DIGINAMIC
 */
public enum TypeRoleAppli {

	/** ADMINISTRATEUR : TypeRole */
	ROLE_ADMINISTRATEUR("Administrateur"),
	/** ROLE_ADMIN_VISITEUR : TypeRole */
	ROLE_UTILISATEUR("Utilisateur");

	/** libelle : String */
	private String libelle;

	/**
	 * Constructor
	 * 
	 * @param libelle libellé
	 * @param id      identifiant
	 */
	private TypeRoleAppli(String libelle) {
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
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
