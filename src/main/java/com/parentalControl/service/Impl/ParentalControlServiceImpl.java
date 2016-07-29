package com.parentalControl.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.parentalControl.enums.ParentalControlLevelEnum;
import com.parentalControl.exceptions.TechnicalFailureException;
import com.parentalControl.exceptions.TitleNotFoundException;
import com.parentalControl.service.MovieService;
import com.parentalControl.service.ParentalControlService;

/**
 * @author Mauricio Moreira de Aguilar 28/07/2016 21:51:14
 *
 */
@Component
public class ParentalControlServiceImpl implements ParentalControlService {

	@Autowired
	private MovieService movieService;

	@Override
	public boolean checkParentalControlLevel(String parentalControlLevel, String movieId) throws TitleNotFoundException, TechnicalFailureException {
		boolean response = false;
		ParentalControlLevelEnum parentalControlLevelPreference = ParentalControlLevelEnum.findByLevel(parentalControlLevel);

		String movieParentalControl = movieService.getParentalControlLevel(movieId);
		ParentalControlLevelEnum movieParentalControlLevel = ParentalControlLevelEnum.findByLevel(movieParentalControl);

		if (movieParentalControlLevel != null && parentalControlLevelPreference != null) {
			if (movieParentalControlLevel.getValue() <= parentalControlLevelPreference.getValue()) {
				response = true;
			}
		}
		new TechnicalFailureException("System error");
		return response;
	}

}
