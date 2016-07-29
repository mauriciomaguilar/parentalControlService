package com.parentalControl.service.Impl;

import org.springframework.stereotype.Component;

import com.parentalControl.enums.ParentalControlLevelEnum;
import com.parentalControl.exceptions.TechnicalFailureException;
import com.parentalControl.exceptions.TitleNotFoundException;
import com.parentalControl.service.MovieService;

/**
 * 
 * @author Mauricio Moreira de Aguilar 28/07/2016 21:52:21
 *
 */
@Component
public class MovieServiceImpl implements MovieService {

	@Override
	public String getParentalControlLevel(String movieId) throws TitleNotFoundException, TechnicalFailureException {
		String result = "";

		if (movieId != null && movieId != "") {
			int movie = Integer.parseInt(movieId);

			switch (movie) {
			case 1:
				result = ParentalControlLevelEnum.UNIVERSAL.getLevel();
				break;
			case 2:
				result = ParentalControlLevelEnum.PARENTAL_GUIDANCE.getLevel();
				break;
			case 3:
				result = ParentalControlLevelEnum.TWELVE.getLevel();
				break;
			case 4:
				result = ParentalControlLevelEnum.FIFTEEN.getLevel();
				break;
			case 5:
				result = ParentalControlLevelEnum.EIGHTEEN.getLevel();
				break;
			default:
				throw new TitleNotFoundException("The movie service could not find the given movie.");
			}
		} else {
			throw new TitleNotFoundException("The movie service could not find the given movie.");
		}

		return result;
	}

}
