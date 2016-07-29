package com.parentalControl.service;

import com.parentalControl.exceptions.TechnicalFailureException;
import com.parentalControl.exceptions.TitleNotFoundException;

/**
 * 
 * @author Mauricio Moreira de Aguilar 28/07/2016 21:52:33
 *
 */
public interface MovieService {

	String getParentalControlLevel(String movieId)
			throws TitleNotFoundException, TechnicalFailureException;
}
