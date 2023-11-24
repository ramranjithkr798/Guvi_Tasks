package com.example.hrtest; //Creating the package with the help ok package keyword
import java.util.Scanner;
import com.example.hr.Employee; //use the created package with the help of import keyword

public class EmployeeTest {

	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the Employee name:");
		String name=scan.next();
		System.out.println("Enter the Employee id:");
		int id=scan.nextInt();
		System.out.println("Enter the Employee salary:");
		double salary=scan.nextDouble();
		Employee em=new Employee(name, id, salary);
		System.out.println("Below are the employee detials:");
		em.printName();
		em.printSalary();
		System.out.println(em.toString());
		scan.close();
	}

}
