package com.parentalControl.exceptions;

/**
 * 
 * @author Mauricio Moreira de Aguilar 28/07/2016 21:52:12
 *
 */
public class TitleNotFoundException extends Exception {

	private static final long serialVersionUID = 1405148628731913575L;

	public TitleNotFoundException(String message) {
		super(message);
	}

	public String getMessage() {
		return super.getMessage();
	}

}
