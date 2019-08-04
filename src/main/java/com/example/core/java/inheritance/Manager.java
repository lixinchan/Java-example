package com.example.core.java.inheritance;

/**
 * @author clx
 */
public class Manager extends Employee {

	/**
	 * bonus
	 */
	private double bonus;

	public Manager(double bonus) {
		this.bonus = bonus;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	protected double getSalary(double salary, double bonus) {
		return salary + bonus;
	}
}
