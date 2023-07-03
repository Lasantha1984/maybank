package com.maybank.assignment.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "greeting")
public class Greeting {
	
	@Id
	private int id;
	@Column(name = "greet")
	private String greet;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGreet() {
		return greet;
	}

	public void setGreet(String greet) {
		this.greet = greet;
	}

	
	
	
	
	

}
