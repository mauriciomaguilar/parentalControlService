package com.parentalControl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.parentalControl.exceptions.TechnicalFailureException;
import com.parentalControl.exceptions.TitleNotFoundException;
import com.parentalControl.service.ParentalControlService;

/**
 * 
 * @author Mauricio Moreira de Aguilar 28/07/2016 21:51:59
 *
 */
@RestController
public class ParentalControlController {

	@Autowired
	ParentalControlService parentalControlBusiness;

	@RequestMapping("/parentalControlService")
	public boolean process(@RequestParam(value = "controlLevel", defaultValue = "") String parentalControlLevel,
			@RequestParam(value = "movieId", defaultValue = "") String movieId) {

		try {
			return parentalControlBusiness.checkParentalControlLevel(parentalControlLevel.toUpperCase(), movieId);
		} catch (TitleNotFoundException e) {
			e.printStackTrace();
		} catch (TechnicalFailureException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
