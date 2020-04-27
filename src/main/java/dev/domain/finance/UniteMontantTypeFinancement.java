package dev.domain.finance;
/**
 * Defini l'unité utilisée pour le montant HT de la table financement_choisi 
 * ou de la table type_financement_choisi
 * @author acer
 *
 */
public enum UniteMontantTypeFinancement {

	UNITE_HEURE_STAGIAIRE("Heure-Stagiaire"),
	UNITE_JOUR_STAGIAIRE("Jour-Stagiaire"),
	UNITE_SEMAINE_STAGIAIRE("Semaine-Stagiaire"),
	UNITE_MOIS_STAGIAIRE("Mois-Stagiaire"),
	UNITE_SESSION_STAGIAIRE("Session-stagiaire"),
	UNITE_HEURE_SESSION("Heure-Session"),
	UNITE_JOUR_SESSION("Jour-Session"),
	UNITE_SEMAINE_SESSION("Semaine-Session"),
	UNITE_MOIS_SESSION("Mois-Session"),
	UNITE_SESSION("Session-Session");
	
	/** libelle : String */
	private String libelle;

	/**
	 * @param libelle
	 */
	private UniteMontantTypeFinancement(String libelle) {
		this.libelle = libelle;
	}

	/** Getter
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/** Setter
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	


}
