package dev.domain;

import java.util.Optional;
import java.util.stream.Stream;

import org.dgn.utils.evaluation.Criteria;

/**
 * Représente les 3 types de notes: SAVOIR, SAVOIR_FAIRE et SAVOIR_ETRE
 * 
 * @author DIGINAMIC
 *
 */
public enum TypeNote implements Criteria {

	/** SAVOIR : TypeNote */
	SAVOIR("Savoir", 0),
	/** SAVOIR_FAIRE : TypeNote */
	SAVOIR_FAIRE("Savoir faire", 1),
	/** SAVOIR_ETRE : TypeNote */
	SAVOIR_ETRE("Savoir être", 2);

	/** libelle : String */
	private String libelle;

	/** ordre : int */
	private int ordre;

	/**
	 * Constructor
	 * 
	 * @param libelle libellé
	 * @param ordre ordre d'affichage
	 */
	private TypeNote(String libelle, int ordre) {
		this.libelle = libelle;
		this.ordre = ordre;
	}

	/**
	 * Recherche un type de note par libellé (exemple: Savoir être)
	 * 
	 * @param libelle libellé recherché
	 * @return Optional de {@link TypeNote}
	 */
	public static Optional<TypeNote> getByLibelle(String libelle) {

		return Stream.of(values()).filter(typeNote -> typeNote.getLibelle().equals(libelle)).findFirst();
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

	/**
	 * Getter
	 * 
	 * @return the ordre
	 */
	public int getOrdre() {
		return ordre;
	}

	/**
	 * Setter
	 * 
	 * @param ordre the ordre to set
	 */
	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}
}
