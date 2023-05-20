package Tester;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import static Utils.ValidationRules.*;
import core.app.emp.Emp;
import static Utils.IOUtils.*;

public class EmployeeManagementSystem {

	public static void main(String[] args) {
		
		
//		1. Hire new emp\r\n" + "2. List all emp details\r\n" + "3. Promote an emp\r\n"
//		+ "4. Delete emp details\r\n" + "5. Sort emps as per join date n display the same.\r\n"
//		+ "0. Exit
		
		try(Scanner sc=new Scanner(System.in)){
			System.out.println("Enter the filename: ");
			String fileName=sc.next();
			Map<String,Emp> empMap=restoreEmp(fileName);
			
			
			boolean exit=false;
			System.out.println("1. Hire new emp\r\n" + "2. List all emp details\r\n" + "3. Promote an emp\r\n"
					+ "4. Delete emp details\r\n" + "5. Sort emps as per join date n display the same.\r\n"
					+ "0. Exit");
			while(!exit) {
				try {
					System.out.println("Enter the choice: ");
					switch(sc.nextInt()) {
					case 1:
						//String id, String firstName, String lastName, String dept, String joinDate, double salary,Map<String,Emp> empMap) throws EmpException {
						System.out.println("Enter the details of employees: id, firstName, lastName, dept, joinDate, salary");
						String id=sc.next();
						Emp emp=validateEmployee(id,sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble(),empMap);
						empMap.put(id, emp);
						break;
						
					case 2:
						System.out.println("Employees are");
						empMap.forEach((s,e)->System.out.println(e));
						break;
						
					case 3:
						System.out.println("Enter the id of employee to promote: ");
						id=sc.next();
						System.out.println("Enter the date to promote the employees: ");
						LocalDate jdate= LocalDate.parse(sc.next());
						empMap
						.values()
						.stream()
						.filter((f)-> f.getJoininDate().isBefore(jdate))
						.forEach((s) -> s.setSalary(s.getSalary()*1.1));
						
						
						
						break;
						
						
						
					case 4: 
						System.out.println("Enter the employee id to delete the employee: ");
						empMap.remove(sc.next());
						break;
						
					case 5:
						System.out.println("Sorting as per join date: ");
						empMap.values()
						.stream()
						.sorted((e1,e2)-> e1.getJoininDate().compareTo(e2.getJoininDate()))
						.forEach(s->System.out.println(s));
						break;
						
					case 0:
						storeEmp(fileName,empMap);
						System.out.println("exiting.....");
						break;
					}
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			
			
			
			
		}

	}

}
