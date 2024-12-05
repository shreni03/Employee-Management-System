package com.itvedant.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

	static Connection con = DBConnect.getConnection();
	
	public List<Employee> readRecord(){
		
		List<Employee> employees = new ArrayList<Employee>();
		
		String query = "Select * from employee";
		
		try {
			
			Statement stats = con.createStatement();
			ResultSet rs = stats.executeQuery(query);
			
			while(rs.next()) {
				
				Employee emp = new Employee();
				
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setAge(rs.getInt("age"));
				emp.setSalary(rs.getFloat("salary"));
				
				employees.add(emp);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return employees;
	}
	
	
	public Boolean insertRecord(int id, String name, int age, float salary) {
		
		String query = "insert into employee values(?, ?, ?, ?)";
		
		try {
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setInt(3, age);
			ps.setFloat(4, salary);
			
			int i = ps.executeUpdate();
			
			if(i > 0) {
				return true;
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return false;
	}
	
	
	public Employee searchRecord(int id) {
		
		Employee emp = new Employee();
		
		String query = "Select * from employee where id = ?";
		
		try {
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setAge(rs.getInt("age"));
				emp.setSalary(rs.getFloat("salary"));
			}
			
			
		} catch (Exception e) {
			System.out.println();
		}
		
		return emp;		
	}
	
	
	public boolean deleteRecord(int id) {
		
		String query = "delete from employee where id = ?";
		
		try {
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			
			int i = ps.executeUpdate();
			
			if(i > 0) {
				return true;
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return false;
	}
	
	
	public boolean updateRecord(Employee emp) {
		
		
		String query = "Update employee set name = ?, age = ?, salary = ? where id = ?";
		
		try {
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, emp.getName());
			ps.setInt(2, emp.getAge());
			ps.setFloat(3, emp.getSalary());
			ps.setInt(4, emp.getId());
			
			int i = ps.executeUpdate();
			if(i > 0) {
				return true;
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return false;
	}
}
