package org.example.core.java.inheritance;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author clx
 */
public class Employee extends Person {

	/**
	 * name
	 */
	private String name;
	/**
	 * hired date
	 */
	private Date hireDate;
	/**
	 * salary
	 */
	private double salary;

	public Employee() {

	}

	public Employee(String name) {
		super(name);
	}

	public Employee(String name, int year, int month, int day, double salary) {
		super(name);
		this.name = name;
		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
		this.hireDate = calendar.getTime();
		this.salary = salary;
	}

	@Override
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public double getSalary() {
		return salary;
	}

	protected void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return null;
	}

}
