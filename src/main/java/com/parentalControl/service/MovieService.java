package com.parentalControl.service;

import com.parentalControl.exceptions.TechnicalFailureException;
import com.parentalControl.exceptions.TitleNotFoundException;

public interface MovieService {

	String getParentalControlLevel(String movieId) throws TitleNotFoundException, TechnicalFailureException;
}
