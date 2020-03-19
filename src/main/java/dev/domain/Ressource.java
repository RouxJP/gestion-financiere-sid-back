package dev.domain;

import java.util.List;

/**
 * Représente une ressource, comme par exemple un utilisateur ou une salle
 * 
 * @author DIGINAMIC
 *
 */
public interface Ressource {

	/**
	 * Retourne le type de la ressource
	 * 
	 * @return {@link TypeRessource}
	 */
	TypeRessource getTypeRessource();

	/**
	 * Retourne le nom de l'attribut de référence pour la ressource (exemple:
	 * email pour un utilisateur)
	 * 
	 * @return String
	 */
	String getAttribute();

	/**
	 * Retourne la valeur de l'attribut de référence pour la ressource (exemple:
	 * email pour un utilisateur)
	 * 
	 * @return String
	 */
	String getValue();

	/**
	 * Retourne la liste des indisponibilités de la ressource
	 * 
	 * @return List de AbstractPeriode
	 */
	List<? extends AbstractPeriode> getIndisponibilites();

	/**
	 * Retourne la conversion de la ressource en String
	 * 
	 * @return String
	 */
	@Override
	String toString();
}
