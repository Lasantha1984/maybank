package com.maybank.customeraddress.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.maybank.customeraddress.model.Address;
import com.maybank.customeraddress.model.Customer;
import com.maybank.customeraddress.service.AddressService;
import com.maybank.customeraddress.service.CustomerService;

@Controller
public class AddressController {
	
	@Autowired
	AddressService addressService;
	
	@Autowired
	CustomerService customerService;

	@PostMapping("/update")
	public String update(
			@RequestParam("addressId") Long addressId,
			@RequestParam("street") String street,
			@RequestParam("city") String city,
			@RequestParam("postalCode") int postalCode,
			@RequestParam("customerId") Long customerId,
			Model model) {
		Address address = new Address();
		address.setId(addressId);
		address.setStreet(street);
		address.setCity(city);
		address.setPostalCode(postalCode);
		Customer customer = customerService.getCustomerById(customerId);
		address.setCustomer(customer);
		addressService.update(address);
		formatAddresses(model, customer.getFullName(), customerId);
		return "addresses";
	}
	
	@PostMapping("/delete")
	public String delete(
			@RequestParam("addressId") Long addressId,
			@RequestParam("customerId") Long customerId,
			Model model) {
		Address address = new Address();
		address.setId(addressId);
		Customer customer = customerService.getCustomerById(customerId);
		address.setCustomer(customer);
		addressService.delete(addressId);
		formatAddresses(model, customer.getFullName(), customerId);
		return "addresses";
	}
	@GetMapping("/addAddress")
	public String addAddress(
			@RequestParam("customerId") Long customerId,
			Model model) {
		model.addAttribute("addressId","");
		model.addAttribute("street","");
		model.addAttribute("city","");
		model.addAttribute("postalCode","");
		model.addAttribute("customerId",customerId);
		return "address";
	}
	
	
	@RequestMapping("/getAddressesByCustomerId")
	public String getAddressesByCustomerId(@RequestParam("customerId") Long customerId,@RequestParam("fullName") String fullName,Model model) {
		formatAddresses(model, fullName, customerId);
		return "addresses";
	}
	
	@PostMapping("/updateAddress")
	public String updateAddress(
			@RequestParam("addressId") Long addressId,
			@RequestParam("street") String street,
			@RequestParam("city") String city,
			@RequestParam("postalCode") String postalCode,
			@RequestParam("customerId") Long customerId,
			Model model) {
		model.addAttribute("addressId",addressId);
		model.addAttribute("street",street);
		model.addAttribute("city",city);
		model.addAttribute("postalCode",postalCode);
		model.addAttribute("customerId",customerId);
		return "address";
	}
	
	private void formatAddresses(Model model,String fullName,Long customerId) {
		List<Address> addressess = addressService.getAddressesByCustomerId(customerId);
		model.addAttribute("addresses",addressess);
		model.addAttribute("fullName",fullName);
		model.addAttribute("customerId",customerId);
	}
}
