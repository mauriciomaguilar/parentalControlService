package com.parentalControl.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.parentalControl.business.ParentalControlBusiness;
import com.parentalControl.enums.ParentalControlLevel;
import com.parentalControl.exceptions.TechnicalFailureException;
import com.parentalControl.exceptions.TitleNotFoundException;
import com.parentalControl.service.MovieService;

@Component
public class ParentalControlBusinessImpl implements ParentalControlBusiness {

    @Autowired
    private MovieService movieService;

    @Override
    public boolean validateParentalControl(ParentalControlLevel customerPreference,
            ParentalControlLevel movieParentalControl) {
        boolean isAllowed = false;

        if (movieParentalControl != null && customerPreference != null) {
            if (movieParentalControl.getValue() <= customerPreference.getValue()) {
                isAllowed = true;
            }
        }
        return isAllowed;
    }

    @Override
    public boolean checkParentalControlLevel(String parentalControlLevel, String movieId) {
        boolean response = false;
        try {
            ParentalControlLevel parentalControlLevelPreference = ParentalControlLevel
                    .findByLevel(parentalControlLevel);

            String movieParentalControl = movieService.getParentalControlLevel(movieId);

            response = validateParentalControl(parentalControlLevelPreference,
                    ParentalControlLevel.findByLevel(movieParentalControl));
        } catch (TitleNotFoundException e) {
            new TitleNotFoundException("The movie service could not find the given movie.");
        } catch (TechnicalFailureException e) {
            new TechnicalFailureException("System error");
        }
        return response;
    }

}
