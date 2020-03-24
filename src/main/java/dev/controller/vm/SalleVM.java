package dev.controller.vm;

/**
 * Structure modèlisant une salle servant à communiquer avec l'extérieur (WEB API).
 */


public class SalleVM {
	
	private String nom;

	/**
	 * @param nom
	 */
	public SalleVM(String nom) {
		super();
		this.nom = nom;
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
	
	

}
