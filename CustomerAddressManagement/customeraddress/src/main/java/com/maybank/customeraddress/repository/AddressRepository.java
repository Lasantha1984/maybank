package com.maybank.customeraddress.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maybank.customeraddress.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
  public List<Address> findAllByCustomerId(Long customerId);
}
