package com.example.hr;

public class Employee {

	String name;
	int id;
	double salary;
	
	public Employee(String name, int id, double salary) {
		super();
		this.name = name;
		this.id = id;
		this.salary = salary;
	}
	public void printName() {
		System.out.println("Employee Name is :"+name);
	}
	public void printSalary() {
		System.out.println("Employee Salary is :"+salary);
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", salary=" + salary + "]";
	}
}
