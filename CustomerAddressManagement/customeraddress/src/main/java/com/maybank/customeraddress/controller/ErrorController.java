package com.maybank.customeraddress.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ErrorController {

	  @ExceptionHandler(Exception.class)
	    public ModelAndView handleException(Exception ex) {
	        ModelAndView modelAndView = new ModelAndView("Error");
	        modelAndView.addObject("error", "An error occurred: " + ex.getMessage());
	        return modelAndView;
	    }
}
