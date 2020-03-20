package dev.exception;

public class ForbiddenOperationException extends RuntimeException {
	/**
	 * Constructeur
	 */
	public ForbiddenOperationException() {
	}

	public ForbiddenOperationException(String message) {
		super("Opération interdite: " + message);
	}

	private static final long serialVersionUID = 1L;

}
