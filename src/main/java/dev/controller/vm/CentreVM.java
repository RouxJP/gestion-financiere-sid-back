package dev.controller.vm;

import dev.domain.Centre;

/**
 * Structure modèlisant un centre servant à communiquer avec l'extérieur (WEB API).
 */

public class CentreVM {
	private String nom;
	private String responsable;
	private String adresse;
	
	public CentreVM(Centre cent) {
		this.nom= cent.getNom();
		this.responsable= cent.getResponsable();
		this.adresse=cent.getAdresse();
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
	 * @return the responsable
	 */
	public String getResponsable() {
		return responsable;
	}

	/** Setter
	 * @param responsable the responsable to set
	 */
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	/** Getter
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/** Setter
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	
}
