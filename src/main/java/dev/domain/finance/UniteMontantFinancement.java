package dev.domain.finance;
/**
 * Defini l'unité utilisée pour le montant HT de la table financement_choisi 
 * ou de la table type_financement_choisi
 * @author acer
 *
 */
public enum UniteMontantFinancement {

	MNT_HOR_STAGIAIRE("Montant horaire par stagiaire"),
	MNT_HOR_GROUPE("Montant horaire par groupe"),
	MNT_FOR_SESSION("Montant forfaitaire par session");

	/** libelle : String */
	private String libelle;

	/**
	 * @param libelle
	 */
	private UniteMontantFinancement(String libelle) {
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
