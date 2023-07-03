package com.maybank.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.maybank.assignment.service.GreetingService;

@Controller
public class GreetingController {

	@Autowired
	GreetingService greetingService;

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String getGreeting(Model model) {

		model.addAttribute("greeting", greetingService.getGreeting());

		return "index";

	}

}
