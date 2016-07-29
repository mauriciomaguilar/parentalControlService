package com.parentalControl.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Mauricio Moreira de Aguilar 28/07/2016 21:51:41
 *
 */
@SpringBootApplication
@ComponentScan({ "com.parentalControl.controller",
		"com.parentalControl.service" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
