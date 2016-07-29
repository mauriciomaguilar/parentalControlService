package com.parentalControl.service;

import com.parentalControl.enums.ParentalControlLevelEnum;

public interface ParentalControlService {

    boolean validateParentalControl(ParentalControlLevelEnum parentalControlLevelPreference,
            ParentalControlLevelEnum parentalControlLevelMovie);

    boolean checkParentalControlLevel(String parentalControlLevel, String movieId);
}
