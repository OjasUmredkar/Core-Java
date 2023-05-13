package com.app.customer;

import java.time.LocalDate;

public class Customer {
	private int id;
	private String firstName,lastName,email,password;
	private double registAmount;
	private LocalDate dob;
	private ServicePlan plan;
	private static int idGen;
	
	public Customer(String firstName, String lastName, LocalDate dob, String email, String password, double registAmount,
			 ServicePlan plan) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.registAmount = registAmount;
		this.dob = dob;
		this.plan = plan;
		this.id=++idGen;
	}
	
	

	//for verification 
	public Customer (String email) {
		this.email=email;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", email=" + email
				 + ", registAmount=" + registAmount +  ", plan=" + plan + "]";
	}

	//for Pk based equality testing
	@Override
	public boolean equals(Object o) {
		
		if(o instanceof Customer) { //to avoid classcats exception
			return this.email.equals(((Customer)o).email);
		}
		
		
		return false;
	}
	
	
	


	public String getEmail() {
		return email;
	}

	public String seePassword() {
		return password;
	}
	
	public void changePassword(String password) {
		this.password = password;
	}

	
	
	
	
}
