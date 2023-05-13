package tester;



import static utils.CustomerValidation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;
import java.lang.Comparable;



import com.app.customer.*;


import customeException.CustomerHandlingException;
public class CustomerMangementSystem {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			// create empty arraylist
			List<Customer> subscribers = new ArrayList<>();
			boolean exit = false;
			while (!exit) {
				System.out.println("\n1. Sign up\r\n" + "2. Sign in\r\n" + "3. Change password\r\n"
						+ "4. Unsubscribe customer\r\n" + "5. Display all customers");
				System.out.println("Enter the choice: ");

				try {

					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter the details of subscriber: " + "FirstName, LastName,"
								+ "Date of Birth, Email, Password," + " Registration Amount,  Service Plan name");
						
						Customer newCustomer = validateCustomer(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(),
								sc.nextDouble(), sc.next(), subscribers);
						// add valid customer to subscribers list
						subscribers.add(newCustomer);
						System.out.println("Customer subscribed the plan....");

						break;

					case 2:// sign in
						System.out.println("Enter the email and password to sign in: ");
						String email = sc.next();
						String password = sc.next();

						newCustomer = customerSignIn(email, password, subscribers);
						System.out.println("New subscriber added: " + newCustomer);

						break;

					case 3:
						System.out.println("Enter the emailId and password to change password: ");
						email = sc.next();
						password = sc.next();
						
						Customer sub = new Customer(email);
						
						for (Customer c : subscribers) {
							if (email.equals(c.getEmail()) && password.equals(c.seePassword())) {
								
								System.out.println("Signed in..." + "\nNow Enter the new Password");
								sub.changePassword(sc.next());
							}
						}

						break;

					case 4:
						
						System.out.println("Enter the Email of customer to remove subscriber: ");
						Customer oldCustomer = new Customer(sc.next());
						
						int index = subscribers.indexOf(oldCustomer);
						
						if (index == -1)
							throw new CustomerHandlingException("Enter the valid emial..!!!");
									
						System.out.println("Subscriber removed is : " + subscribers.remove(index));
						
						break;

					case 5:

						System.out.println("All the subscribers are: ");
						Iterator<Customer> customerItr =subscribers.iterator();
						
						if (subscribers.size() != 0) {
							while(customerItr .hasNext()) {
								System.out.println(customerItr.next());
							}
						}
						else {
							System.out.println("NO Subscribers\n");
						}
						
						break;
						
					
					    
					    
					    
					
						

						

					case 0:
						exit = true;
						break;
					}

				} catch (Exception e) {
					e.printStackTrace();
					
					// read off pending token from till end of line
					sc.nextLine();
				}

			}

		}

	}
}
