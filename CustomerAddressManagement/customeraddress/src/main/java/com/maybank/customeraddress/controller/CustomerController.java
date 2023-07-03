package com.maybank.customeraddress.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maybank.customeraddress.model.Customer;
import com.maybank.customeraddress.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String getAllCustomers(Model model){
	
		model.addAttribute("customers",customerService.getAllCustomers());
		return "index";
	}
	
	@PostMapping("/save")
	public Customer save(@RequestParam Customer customer) {
		return customerService.save(customer);
		
	}

}
