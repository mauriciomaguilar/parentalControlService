package com.parentalControl.exceptions;

/**
 * 
 * @author Mauricio Moreira de Aguilar 28/07/2016 21:52:09
 *
 */
public class TechnicalFailureException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8742781306658610801L;

	public TechnicalFailureException(String message) {
		super(message);
	}

	public String getMessage() {
		return super.getMessage();
	}

}
