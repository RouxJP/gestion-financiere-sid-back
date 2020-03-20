package dev.domain;

/**
 * Statut de validation d'une session ou d'un cours. La session est considérée
 * comme validée lorsque tous les cours le sont.
 * 
 * @author DIGINAMIC
 *
 */
public enum StatutValidation {

	/** A_VALIDER : StatutValidation */
	A_VALIDER("A Valider"),
	/** VALIDE : StatutValidation */
	VALIDE("Validé"),
	/** REFUSE : StatutValidation */
	REFUSE("Refusé");

	/** libelle du statut : String */
	private String libelle;

	/**
	 * Constructor
	 * 
	 * @param libelle libellé du statut
	 */
	private StatutValidation(String libelle) {
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
