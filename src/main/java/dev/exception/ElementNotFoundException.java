package dev.exception;

public class ElementNotFoundException extends RuntimeException {
	/**
	 * Constructeur
	 */
	public ElementNotFoundException() {
	}

	public ElementNotFoundException(String message) {
		super("Erreur: " + message);
	}

	private static final long serialVersionUID = 1L;
}
