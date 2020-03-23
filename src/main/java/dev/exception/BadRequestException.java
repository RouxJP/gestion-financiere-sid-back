package dev.exception;

public class BadRequestException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur
	 */
	public BadRequestException() {
	}

	public BadRequestException(String message) {
		super("Bad request: " + message);
	}

}
