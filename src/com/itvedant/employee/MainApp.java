package com.itvedant.employee;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		
//		Connection con = DBConnect.getConnection();
//		
//		System.out.println(con);
//	
//		DBConnect.closeConnection();
		
		Scanner sc = new Scanner(System.in);
		
		EmployeeService eservice = new EmployeeService();
		
		System.out.println("Welcone to Employee Management System");
		
		while(true) {
			
			System.out.println();
			System.out.println("Kindly enter choice for operation you want to perform");
			System.out.println("1. Add Employee");
			System.out.println("2. View All Employees");
			System.out.println("3. Update Employee");
			System.out.println("4. Delete Employee");
			System.out.println("5. Search Employee");
			System.out.println("6. Exit");
			
			int userinput = sc.nextInt();
			
			if(userinput == 6) {
				System.out.println("Okay, Bye!");
				break;
			}else {
				
				int id;
				String name;
				int age;
				float salary;
				
				switch(userinput) {
				
				case 1 : System.out.println("Enter ID : ");
						 id = sc.nextInt();
						 System.out.println("Enter Name : ");
						 name = sc.next();
						 System.out.println("Enter Age : ");
						 age = sc.nextInt();
						 System.out.println("Enter Salary : ");
						 salary = sc.nextFloat();
						 
						 boolean b = eservice.insertRecord(id, name, age, salary);
						 
						 if(b) {
							 System.out.println("Data inserted");
						 }else {
							 System.out.println("Data not inserted");
						 }
				
				case 2 : List<Employee> employees = eservice.readRecord();
						 for(Employee x : employees) {
							 System.out.println(x);
						 }
						 break;
						 
				case 3 : System.out.println("Enter ID : ");
						 id = sc.nextInt();
						 
						 Employee emp = eservice.searchRecord(id);
						 System.out.println(emp);
						 
						 System.out.println();
						 
						 System.out.println("Enter choice for which field you want to update : ");
						 System.out.println("a. Name");
						 System.out.println("b. Age");
						 System.out.println("c. Salary");
						 
						 char c = sc.next().charAt(0);
						 
						 switch(c) {
						 
						 case 'a' : System.out.println("Enter Name : ");
						 			name = sc.next();
						 			emp.setName(name);
						 			break;
						 		
						 case 'b' : System.out.println("Enter Age : ");
						 			age = sc.nextInt();
						 			emp.setAge(age);
						 			break;
						 			
						 case 'c' : System.out.println("Enter Salary : ");
						 			salary = sc.nextFloat();
						 			emp.setSalary(salary);
						 			break;
						 			
						 default : System.out.println("Invalid input");
						 
						 }
						 
						 b = eservice.updateRecord(emp);
						 
						 if(b) {
							 System.out.println("Record Updated");
						 }else {
							 System.out.println("Record not updated");
						 }
						 break;
						 
				case 4 : System.out.println("Enter ID : ");
						 id = sc.nextInt();
						 
						 b = eservice.deleteRecord(id);
						 
						 if(b) {
							 System.out.println("Record deleted");
						 }else {
							 System.out.println("Record not deleted");
						 }
						 break;
						 
				case 5 : System.out.println("Enter ID : ");
						 id = sc.nextInt();
						 
						 emp = eservice.searchRecord(id);
						 
						 System.out.println(emp);
						 break;
						
				default : System.out.println("Invalid input");
				}
			}
					
		}
		
		
	}
}
