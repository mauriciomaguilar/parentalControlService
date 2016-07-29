package com.parentalControl.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.parentalControl.enums.ParentalControlLevelEnum;
import com.parentalControl.exceptions.TechnicalFailureException;
import com.parentalControl.exceptions.TitleNotFoundException;
import com.parentalControl.service.MovieService;
import com.parentalControl.service.ParentalControlService;

@Component
public class ParentalControlServiceImpl implements ParentalControlService {

    @Autowired
    private MovieService movieService;

    @Override
    public boolean validateParentalControl(ParentalControlLevelEnum customerPreference,
            ParentalControlLevelEnum movieParentalControl) {
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
            ParentalControlLevelEnum parentalControlLevelPreference = ParentalControlLevelEnum
                    .findByLevel(parentalControlLevel);

            String movieParentalControl = movieService.getParentalControlLevel(movieId);

            response = validateParentalControl(parentalControlLevelPreference,
                    ParentalControlLevelEnum.findByLevel(movieParentalControl));
        } catch (TitleNotFoundException e) {
            new TitleNotFoundException("The movie service could not find the given movie.");
        } catch (TechnicalFailureException e) {
            new TechnicalFailureException("System error");
        }
        return response;
    }

}
