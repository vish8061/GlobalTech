package com.globaltech.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.globaltech.bean.Employee;
import com.globaltech.dao.DisplayDao;
import com.globaltech.dao.RegisterDao;
import com.globaltech.dao.ResignDao;

/**
 * Servlet implementation class Controller_Servlet
 */
@WebServlet("/Controller_Servlet")
public class Controller_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Controller_Servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("go");
		String action1 = request.getParameter("do");
		//response.getWriter().println(action);
		//response.getWriter().println(action1);
		if(action!=null) {
		if(action.equals("Register")) {
			
			request.getRequestDispatcher("Register.jsp").forward(request, response);
			
			}
		
		if(action.equals("Display")) {
			
			List<Employee> employees=DisplayDao.viewAllEmployee();
			//response.getWriter().print("EmployeeID"+" "+"FirstName"+" "+"LastName"+" "+"DateOfJoining"+" "+"Department");
			for(int index=0;index<employees.size();index++) {
				
				response.getWriter().print(employees.get(index).getEmployeeID()+" ");
				response.getWriter().print(employees.get(index).getFirstName()+" ");
				response.getWriter().print(employees.get(index).getLastName()+" ");
				response.getWriter().print(employees.get(index).getDate()+" ");
				response.getWriter().print(employees.get(index).getDepartment());
				response.getWriter().println();
				
				
			}
		
			//request.getRequestDispatcher("Display.jsp").forward(request, response);
			//response.getWriter().println("Display");
			}
		
		if(action.equals("Resign")) {
			
			request.getRequestDispatcher("Resign.jsp").forward(request, response);
			response.getWriter().println("Resign");
			}
		}
		
		if(action1!=null) {
			
			
		if(action1.equals("Register")) {
			response.getWriter().println(" in servlet registration");
			Employee employee=new Employee();
			employee.setEmployeeID(Integer.parseInt(request.getParameter("employeeid")));
			employee.setFirstName(request.getParameter("firstname"));
			employee.setLastName(request.getParameter("lastname"));
			employee.setDate(request.getParameter("dateofjoining"));
			employee.setDepartment(request.getParameter("department"));
		
			int status=RegisterDao.registerEmployee(employee);
			if(status>0) {
				response.getWriter().println("welcome to globaltech.....");
			}
			else {
				response.getWriter().println(" not welcome to globaltech.....");
			}
			
			
		
		
		}
		
		
		if(action1.equals("Display")) {
			
			
			}
		
		
		if(action1.equals("Resign")) {
	
			int employeeid=Integer.parseInt(request.getParameter("employeeid"));
			int status=ResignDao.resignEmployee(employeeid);
			if(status>0) {
				response.getWriter().println(" you have resigned from GlobalTech ;(  ");
			}
			else {
				response.getWriter().println("Something went wrong... pls try again..redirecting you to Resign page");
				response.setHeader("Refresh", "5; URL=http://localhost:9080/GlobalTech/Controller_Servlet?go=Display");
			}
			
		}
		
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
