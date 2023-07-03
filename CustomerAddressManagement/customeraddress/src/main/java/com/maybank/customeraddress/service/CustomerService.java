package com.maybank.customeraddress.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maybank.customeraddress.model.Customer;
import com.maybank.customeraddress.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	public ArrayList<Customer> getAllCustomers() {
		
		return (ArrayList<Customer>) customerRepository.findAll();
	}

	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	public Customer getCustomerById(Long customerId) {
		
		return customerRepository.findById(customerId).get();
	}

}
