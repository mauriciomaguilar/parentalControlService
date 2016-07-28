package com.parentalControl.exceptions;

public class TechnicalFailureException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8742781306658610801L;

	public TechnicalFailureException(String message) {
		super(message);
	}
	
	public String getMessage(){
		return super.getMessage();
	}

}
