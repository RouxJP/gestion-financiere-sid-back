package dev.domain.exceptions;

/**
 * Exception générée lors des traitements sur les dates
 * 
 * @author DIGINAMIC
 *
 */
public class DateException extends Exception {

	/** serialVersionUID : long */
	private static final long serialVersionUID = 1528714294096953347L;

	/**
	 * Constructor
	 * 
	 */
	public DateException() {
	}

	/**
	 * Constructor
	 * 
	 * @param message message d'erreur
	 */
	public DateException(String message) {
		super(message);
	}
}
