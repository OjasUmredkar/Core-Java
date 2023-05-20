package core.app.emp;

import java.io.Serializable;
import java.time.LocalDate;

import Utils.Dept;

public class Emp implements Serializable {

	//id,  First Name,  Last Name,  Department,  Joining Date,  Salary
	private String id;
	private String firstName;
	private String lastName;
	private Dept deptno;
	private LocalDate joininDate;
	private double salary;
	
	public Emp(String id, String firstName, String lastName, Dept deptno, LocalDate joininDate, double salary) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.deptno = deptno;
		this.joininDate = joininDate;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", deptno=" + deptno
				+ ", joininDate=" + joininDate + ", salary=" + salary + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Dept getDeptno() {
		return deptno;
	}

	public void setDeptno(Dept deptno) {
		this.deptno = deptno;
	}

	public LocalDate getJoininDate() {
		return joininDate;
	}

	public void setJoininDate(LocalDate joininDate) {
		this.joininDate = joininDate;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}
