package com.parentalControl.service.Impl;

import org.springframework.stereotype.Component;

import com.parentalControl.business.ParentalControlBusiness;
import com.parentalControl.business.impl.ParentalControlBusinessImpl;
import com.parentalControl.enums.ParentalControlLevel;
import com.parentalControl.exceptions.TechnicalFailureException;
import com.parentalControl.exceptions.TitleNotFoundException;
import com.parentalControl.service.MovieService;
import com.parentalControl.service.ParentalControlService;

@Component
public class ParentalControlServiceImpl implements ParentalControlService {

	static MovieService movieService = new MovieServiceImpl();
	static ParentalControlBusiness parentalControlBusiness = new ParentalControlBusinessImpl();

	@Override
	public boolean checkParentalControlLevel(String parentalControlLevel,
			String movieId) {
		boolean response = false;
		try {
			ParentalControlLevel parentalControlLevelPreference = ParentalControlLevel
					.findByLevel(parentalControlLevel);
			
			String movieParentalControl = movieService
					.getParentalControlLevel(movieId);
			
			response = parentalControlBusiness.validateParentalControl(
					parentalControlLevelPreference,
					ParentalControlLevel.findByLevel(movieParentalControl));
		} catch (TitleNotFoundException e) {
			new TitleNotFoundException(
					"The movie service could not find the given movie.");
		} catch (TechnicalFailureException e) {
			new TechnicalFailureException("System error");
		}
		return response;
	}

}
