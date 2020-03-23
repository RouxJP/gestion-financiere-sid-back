package dev.domain;

//import org.dgn.planification.sessions.StatutValidation;

/**
 * Un évènement est toute entité ayant une date de début et une date de fin
 * 
 * @author DIGINAMIC
 *
 */
public interface Evenement extends Comparable<Evenement>, PlageDate {

	@Override
	default int compareTo(Evenement o) {
		if (getDateDebut() == null || o.getDateDebut() == null) {
			return 0;
		}
		return getDateDebut().compareTo(o.getDateDebut());
	}

	/**
	 * Retourne l'identifiant de l'évènement de départ
	 * 
	 * @return Long
	 */
	Long getId();

	/**
	 * Nom de l'évènement (nom de la session, de l'indisponibilité, du cours,
	 * etc.)
	 * 
	 * @return String
	 */
	String getNom();

	/**
	 * Retourne le nom de la ressource associée à un évènement. Exemple: nom de
	 * la session pour un cours planifié, ou le nom de l'utilisateur pour une
	 * indisponibilité du formateur.
	 * 
	 * @return String
	 */
	String getRessource();

	/**
	 * Retourne le centre associé à l'évènement
	 * 
	 * @return Centre
	 */
	Centre getCentre();

	/**
	 * Retourne le type d'évènement
	 * 
	 * @return {@link TypeEvenement}
	 */
	TypeEvenement getType();

	/**
	 * Retourne le statut de validation de l'évènement
	 * 
	 * @return {@link StatutValidation}
	 */
	StatutValidation getStatutValidation();
}
