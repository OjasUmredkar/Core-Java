package Utils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Map;

import Custom_Exception.EmpException;
import core.app.emp.Emp;

public class ValidationRules {
	
	public static Emp validateEmployee(String id, String firstName, String lastName, String dept, String joinDate, double salary,Map<String,Emp> empMap) throws EmpException {
		
		duplicateEmployee(id, empMap);
		Dept department=parseDept(dept);
		LocalDate joiningDate=parseJoinDate(joinDate);
		
		
		return new Emp(id, firstName, lastName, department, joiningDate, salary);
		
	}
	
	
	
	public static void duplicateEmployee(String id,Map<String,Emp> empMap) throws EmpException {
		if(empMap.containsKey(id)){
			throw new EmpException("Duplicate Employee");
		}
	}
	
	public static  Dept parseDept(String dept) throws IllegalArgumentException{
		return Dept.valueOf(dept.toUpperCase());
			
		
	}
	
	public static LocalDate parseJoinDate(String joinDate) throws DateTimeParseException {
		return LocalDate.parse(joinDate);
		
		
		
	}
}
