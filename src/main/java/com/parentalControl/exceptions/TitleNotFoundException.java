package com.parentalControl.exceptions;

public class TitleNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1405148628731913575L;

	public TitleNotFoundException(String message){
		super(message);
	}
	
	public String getMessage(){
		return super.getMessage();
	}
	
}
