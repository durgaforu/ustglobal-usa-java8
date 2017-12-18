package com.emp;

public class Employee {

	private int id;
	private String name;
	private double salary;
	private double bonus;

	public Employee(int id) {
		if (id > 0)
			this.id = id;
	}

	public int getId() {
		return id;
	}

	// public void setId(int id) {
	// this.id = id;
	// }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		if (salary <= 5000) {
			this.salary = salary;
			this.bonus = this.salary * 0.2;
		}
	}

	public double getBonus() {
		return bonus;
	}

	// public void setBonus(double bonus) {
	// this.bonus = bonus;
	// }

}
