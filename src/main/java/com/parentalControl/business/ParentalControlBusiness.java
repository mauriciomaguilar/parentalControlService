package com.parentalControl.business;

import com.parentalControl.enums.ParentalControlLevel;

public interface ParentalControlBusiness {

	boolean validateParentalControl(ParentalControlLevel parentalControlLevelPreference, ParentalControlLevel parentalControlLevelMovie);
}
