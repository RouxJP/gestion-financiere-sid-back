package dev.controller.vm;

/**
 * Structure modèlisant une formation servant à communiquer avec l'extérieur (WEB API).
 */

public class FormationVM {

	private String nom;
	private String reference;
	private Integer duree;
	/**
	 * @param nom
	 * @param reference
	 * @param duree
	 */
	public FormationVM(String nom, String reference, Integer duree) {
		super();
		this.nom = nom;
		this.reference = reference;
		this.duree = duree;
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
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}
	/** Setter
	 * @param reference the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}
	/** Getter
	 * @return the duree
	 */
	public Integer getDuree() {
		return duree;
	}
	/** Setter
	 * @param duree the duree to set
	 */
	public void setDuree(Integer duree) {
		this.duree = duree;
	}
	
	
}
