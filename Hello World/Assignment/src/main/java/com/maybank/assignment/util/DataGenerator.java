package com.maybank.assignment.util;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.maybank.assignment.service.GreetingService;

import org.springframework.beans.factory.annotation.Autowired;

@Component
public class DataGenerator implements CommandLineRunner {
	
	@Autowired
	GreetingService service;

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Inserting Data  ........");
		service.insertGreeting();

	}

}
