package com.globaltech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.globaltech.bean.Employee;

public class ResignDao {

public static int resignEmployee(int employeeid) {
		
		Connection conn;
		int status=0;
		try {
			conn = RegisterDao.getConnection();
			System.out.println("connection established");
			String SQL="delete from employee where eid=? ";
			PreparedStatement pstat=conn.prepareStatement(SQL);
			pstat.setInt(1,employeeid);
			status=pstat.executeUpdate();	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
		
	}
	
}
