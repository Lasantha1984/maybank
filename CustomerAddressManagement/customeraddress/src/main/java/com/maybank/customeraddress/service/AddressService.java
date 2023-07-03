package com.maybank.customeraddress.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.maybank.customeraddress.model.Address;
import com.maybank.customeraddress.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepository;
	public Address update(Address address) {
		
		return addressRepository.save(address);
	}
	public List<Address> getAddressesByCustomerId(Long customerId) {
	
		return addressRepository.findAllByCustomerId(customerId);
	}
	public void delete(Long addressId) {
		addressRepository.deleteById(addressId);
		
	}

}
