package com.parentalControl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.parentalControl.service.ParentalControlService;

@RestController
public class ParentalControlController {

    @Autowired
    ParentalControlService parentalControlBusiness;

    @RequestMapping("/parentalControlService")
    public boolean process(@RequestParam(value = "controlLevel", defaultValue = "") String parentalControlLevel,
            @RequestParam(value = "movieId", defaultValue = "") String movieId) {

        return parentalControlBusiness.checkParentalControlLevel(parentalControlLevel.toUpperCase(), movieId);

    }
}
