package com.globaltech.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.globaltech.bean.Employee;

public class RegisterDao {

	public static Connection getConnection(){
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static int registerEmployee(Employee employee) {
		
		Connection conn;
		int status=0;
		try {
			conn = getConnection();
			System.out.println("connection established");
			String SQL="insert into employee(eid,fname,lname,doj,dept) values(?,?,?,?,?)";
			PreparedStatement pstat=conn.prepareStatement(SQL);
			pstat.setInt(1,employee.getEmployeeID());
			pstat.setString(2,employee.getFirstName());
			pstat.setString(3,employee.getLastName());
			pstat.setString(4,employee.getDate());
			pstat.setString(5,employee.getDepartment());
			
			status=pstat.executeUpdate();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
		
	}
	
}
