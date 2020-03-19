package dev.domain;

/**
 * @author DIGINAMIC
 */
public enum TypeRole {

	/** ADMINISTRATEUR : TypeRole */
	ROLE_ADMINISTRATEUR("Administrateur", 1L),
	/** PLANIFICATEUR : TypeRole */
	ROLE_PLANIFICATEUR("Planificateur", 2L),
	/** FORMATEUR : TypeRole */
	ROLE_FORMATEUR("Formateur", 3L),
	/** STAGIAIRE : TypeRole */
	ROLE_STAGIAIRE("Stagiaire", 4L),
	/** VISITEUR : TypeRole */
	ROLE_VISITEUR("Visiteur", 5L),
	/** ROLE_ADMIN_VISITEUR : TypeRole */
	ROLE_VISITEUR_ADMIN("Visiteur admin", 6L);

	/** id : Long */
	private Long id;

	/** libelle : String */
	private String libelle;

	/**
	 * Constructor
	 * 
	 * @param libelle libellé
	 * @param id      identifiant
	 */
	private TypeRole(String libelle, Long id) {
		this.id = id;
		this.libelle = libelle;
	}

	/**
	 * Getter for id
	 * 
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Setter
	 * 
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
