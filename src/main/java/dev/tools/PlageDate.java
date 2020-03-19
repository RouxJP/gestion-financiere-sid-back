package org.dgn.entites;

import java.time.LocalDate;

/**
 * Représente une plage de dates délimitée par une date de début et une date de
 * fin
 * 
 * @author DIGINAMIC
 *
 */
public interface PlageDate {

	/**
	 * Date de début de l'évènement
	 * 
	 * @return LocalDate
	 */
	LocalDate getDateDebut();

	/**
	 * Date de fin de l'évènement
	 * 
	 * @return LocalDate
	 */
	LocalDate getDateFin();
}
