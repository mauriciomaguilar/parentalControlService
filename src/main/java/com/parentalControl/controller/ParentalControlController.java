package com.parentalControl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.parentalControl.service.ParentalControlService;
import com.parentalControl.service.Impl.ParentalControlServiceImpl;

@RestController
public class ParentalControlController {
	
	private final String result="Result: ";
	private final String movie=" - MovieId: ";

    @RequestMapping("/parentalControlService")
    public String greeting(@RequestParam(value="controlLevel", defaultValue="") String parentalControlLevel,@RequestParam(value="movieId",defaultValue="") String movieId) {
    	
    	ParentalControlService test = new ParentalControlServiceImpl();
    	return result +test.checkParentalControlLevel(parentalControlLevel, movieId)+ movie+movieId;
    	
    }
}
