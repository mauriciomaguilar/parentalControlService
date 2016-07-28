package com.parentalControl.business.impl;

import org.springframework.stereotype.Component;

import com.parentalControl.business.ParentalControlBusiness;
import com.parentalControl.enums.ParentalControlLevel;

@Component
public class ParentalControlBusinessImpl implements ParentalControlBusiness {

	@Override
	public boolean validateParentalControl(
			ParentalControlLevel customerPreference,
			ParentalControlLevel movieParentalControl) {
		boolean isAllowed = false;

		if (movieParentalControl != null && customerPreference != null) {
			if (movieParentalControl.getValue() <= customerPreference
					.getValue()) {
				isAllowed = true;
			}
		}
		return isAllowed;
	}

}
