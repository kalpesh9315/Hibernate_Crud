package com.employee.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.dao.EmployeeDao;

import model.EmployeeModel;

public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeModel employeeModel=new EmployeeModel();
		employeeModel.setEmail(request.getParameter("email"));
		employeeModel.setPassword(request.getParameter("password"));
		EmployeeModel model=EmployeeDao.login(employeeModel);
		if (model!=null) {
			request.setAttribute("msg", "Login successfully done..");
			request.getRequestDispatcher("view.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		if (action.equalsIgnoreCase("submit")) {
			EmployeeModel employeeModel=new EmployeeModel();
			employeeModel.setFirstName(request.getParameter("fname"));
			employeeModel.setLastName(request.getParameter("lname"));
			employeeModel.setEmail(request.getParameter("email"));
			employeeModel.setPassword(request.getParameter("password"));
			if(employeeModel.getPassword().equals(request.getParameter("confirm_password")))
			{
				EmployeeDao.insertEmployee(employeeModel);
				request.setAttribute("msg", "Registration successfully done..");
				request.getRequestDispatcher("view.jsp").forward(request, response);
			}else {
				request.setAttribute("password", "Password is not match");
				request.getRequestDispatcher("insert.jsp").forward(request, response);
			}
		}else if (action.equalsIgnoreCase("edit")) {
			int id=Integer.parseInt(request.getParameter("id"));
			EmployeeModel employeeModel=EmployeeDao.getEmployee(id);
			request.setAttribute("employeeModel", employeeModel);
			request.getRequestDispatcher("edit.jsp").forward(request, response);
		}else if (action.equalsIgnoreCase("update")) {
			int id=Integer.parseInt(request.getParameter("id"));
			EmployeeModel employeeModel=new EmployeeModel();
			employeeModel.setId(id);
			employeeModel.setFirstName(request.getParameter("fname"));
			employeeModel.setLastName(request.getParameter("lname"));
			employeeModel.setEmail(request.getParameter("email"));
			employeeModel.setPassword(request.getParameter("password"));
			EmployeeDao.updateEmployee(employeeModel);
			response.sendRedirect("view.jsp");
		}else if (action.equalsIgnoreCase("delete")) {
			int id=Integer.parseInt(request.getParameter("id"));
			EmployeeDao.deleteEmployee(id);
			request.setAttribute("msg", "Employee deleted successfully..");
			request.getRequestDispatcher("view.jsp").forward(request, response);
		}
	}
}
