package com.parentalControl.service.Impl;

import java.util.Random;

import org.springframework.stereotype.Component;

import com.parentalControl.enums.ParentalControlLevelEnum;
import com.parentalControl.exceptions.TechnicalFailureException;
import com.parentalControl.exceptions.TitleNotFoundException;
import com.parentalControl.service.MovieService;

@Component
public class MovieServiceImpl implements MovieService {

	@Override
	public String getParentalControlLevel(String movieId)
			throws TitleNotFoundException, TechnicalFailureException {

		int level = new Random().nextInt(ParentalControlLevelEnum.values().length);
		return ParentalControlLevelEnum.values()[level].getLevel();
	}

}
