package dev.domain;

import java.time.LocalDate;

import org.apache.commons.lang3.time.DateUtils;

/**
 * Représente un élément de planning
 * 
 * @author DIGINAMIC
 */
public interface PlanningElement {

	/**
	 * Retourne la date de début
	 * 
	 * @return LocalDate
	 */
	LocalDate getDateDebut();

	/**
	 * Retourne la date de fin
	 * 
	 * @return LocalDate
	 */
	LocalDate getDateFin();

	/**
	 * Retourne la durée
	 * 
	 * @return int
	 */
	default int getDuree() {
		return DateUtils.getDureeOuvree(getDateDebut(), getDateFin());
	}

	/**
	 * Retourne le libellé
	 * 
	 * @return String
	 */
	String getLibelle();

	/**
	 * Retourne le nom de l'intervenant
	 * 
	 * @return Utilisateur
	 */
	default Utilisateur getIntervenant() {
		return new Utilisateur(0L, "", "", "");
	}

	/**
	 * Retourne la modalité pédagogique
	 * 
	 * @return {@link ModalitePedagogique}
	 */
	default ModalitePedagogique getModalitePedagogique() {
		return new ModalitePedagogique("");
	}

	/**
	 * Retourne un attribut à afficher dans le planning
	 * 
	 * @return String
	 */
	default String getAttribut1() {
		return "";
	}

	/**
	 * Retourne un attribut à afficher dans le planning
	 * 
	 * @return String
	 */
	default String getAttribut2() {
		return "";
	}

	/**
	 * Retourne un attribut à afficher dans le planning
	 * 
	 * @return String
	 */
	default String getAttribut3() {
		return "";
	}
}
