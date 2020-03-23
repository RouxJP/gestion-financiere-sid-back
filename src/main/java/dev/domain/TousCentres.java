package dev.domain;

/**
 * Représente "Tous les centres", autrement dit une donnée pour laquelle on a
 * besoin de la rattacher à tous les centres, comme une fermeture DIGINAMIC.
 * 
 * @author DIGINAMIC
 *
 */
public class TousCentres extends Centre {

	/** TOUS : String */
	private static final String TOUS = "Tous";

	/**
	 * Constructor
	 * 
	 */
	public TousCentres() {
		super(TOUS);
	}

}
