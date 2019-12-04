package com.globaltech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.globaltech.bean.Employee;

public class DisplayDao {
	
	public static List<Employee> viewAllEmployee() {
		
		Connection conn;
		Employee employee=null;
		List<Employee> employees=new ArrayList<Employee>();
		try {
			conn = RegisterDao.getConnection();
			String SQL="select * from employee order by eid";
			PreparedStatement pstat=conn.prepareStatement(SQL);
			ResultSet rs=pstat.executeQuery();
			while(rs.next()) {
				employee=new Employee();
				employee.setEmployeeID(rs.getInt(1));
				employee.setFirstName(rs.getString(2));
				employee.setLastName(rs.getString(3));
				employee.setDepartment(rs.getString(4));
				employee.setDate(rs.getString(5));
				employees.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
		
	}
	
	
}
