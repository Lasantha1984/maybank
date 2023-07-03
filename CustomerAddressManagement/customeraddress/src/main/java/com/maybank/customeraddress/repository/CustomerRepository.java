package com.maybank.customeraddress.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maybank.customeraddress.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
