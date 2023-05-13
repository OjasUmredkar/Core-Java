package utils;
import com.app.customer.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import com.app.customer.Customer;

import customeException.CustomerHandlingException;

public class CustomerValidation {
	//add  static method to invoke all validation rules
	public static Customer validateCustomer(String firstName, String lastName,String dob, String email, String password, double registAmount,
			 String plan,List<Customer> customerList)
					throws CustomerHandlingException {
		
		//checks for duplicate emails
		checkForDup(email, customerList);
		
		//parse and validate entered plan 
		ServicePlan servePlan=parseValidatePlanAndRegAmount(plan,registAmount);
		
		
		//verifies customer age by date of birth (dob)
		LocalDate dateOfBirth=verifyCustomerAge(dob);
		
		
		//returns the valid customer details in the form of instance of customer
		return new Customer(firstName, lastName, dateOfBirth, email, password,registAmount , servePlan);
		
		
		
	}
	
	
	
	
	public static void checkForDup(String newEmailid, List<Customer> customerList) 
			throws CustomerHandlingException {

		Customer newCustomer = new Customer(newEmailid);
		if (customerList.contains(newCustomer)) {
			throw new CustomerHandlingException("Duplicate Customer...!!!");
		}
		System.out.println("No Duplicate Customer Found");
	}
	
	
	//to check for valid enums
	/*
	 * public static ServicePlan parseValidateServicePlan(String planName) throws
	 * IllegalArgumentException{
	 * 
	 * return ServicePlan.valueOf(planName.toUpperCase());
	 * 
	 * }
	 * 
	 * 
	 * //add static method to validate registration amount matching with the plan
	 * public static void validatePlanCost(double registrationAmount,ServicePlan
	 * planName) throws {
	 * 
	 * if(registrationAmount!=planName.getPlanCost()) { throw new
	 * CustomerHandlingException("Invalid registration amount...!!! ") }
	 * System.out.println("Your Plan subscribed plan: "+planName); }
	 */
	
	//to check for valid enums
	public static ServicePlan parseValidatePlanAndRegAmount(String planName,double registrationAmount) 
			throws IllegalArgumentException,CustomerHandlingException
	{
		ServicePlan plan=ServicePlan.valueOf(planName.toUpperCase());
		
		if(registrationAmount!=plan.getPlanCost()) {
			throw new CustomerHandlingException("Invalid registration amount...!!! "); 
		}
			  
		return plan;
		
	}
	
		
	public static LocalDate verifyCustomerAge(String dob) throws CustomerHandlingException {

		LocalDate dateOfBirth = LocalDate.parse(dob);

//  Period.between -> gets the period between dob and curdate and getyears-> gets the no. of years form period                                 
		int age = ( Period.between(dateOfBirth, LocalDate.now()) ).getYears();
		//System.out.println(age);
		if (age<=21) {
			throw new CustomerHandlingException("Age of Customer is below 21");
		}

		return dateOfBirth;
	}
	
	public static Customer customerSignIn(String email,String password,List<Customer> customerList) throws CustomerHandlingException {
		
		int index=customerList.indexOf(new Customer(email));
		if(index==-1)
			throw new CustomerHandlingException("Invalid Email, login failed!!!");
		Customer newCustomer=customerList.get(index);
		
		if(!newCustomer.seePassword().equals(password)) {
			throw new CustomerHandlingException("Invalid Password, login failed");
			
		}
		
		return newCustomer;
	}
	
	
	
}
