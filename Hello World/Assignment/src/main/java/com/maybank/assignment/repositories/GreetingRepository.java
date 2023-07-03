package com.maybank.assignment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maybank.assignment.model.Greeting;

public interface GreetingRepository extends JpaRepository<Greeting, Integer> {

	
}
