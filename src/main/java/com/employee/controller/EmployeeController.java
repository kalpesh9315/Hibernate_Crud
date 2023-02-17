package com.employee.controller;

import java.io.IOException;
import java.util.Random;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.employee.dao.EmployeeDao;

import model.EmployeeModel;

public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int otp=0;   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeModel employeeModel=new EmployeeModel();
		employeeModel.setEmail(request.getParameter("email"));
		employeeModel.setPassword(request.getParameter("password"));
		EmployeeModel model=EmployeeDao.login(employeeModel);
		if (model!=null) {
			HttpSession httpSession=request.getSession();
			httpSession.setAttribute("e", model);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "Invalid Email or password..");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		Random random=new Random();
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
				request.setAttribute("msg", "Password is not match");
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
		}else if(action.equalsIgnoreCase("sendotp")) {
			String email=request.getParameter("email");
			EmployeeModel employeeModel=EmployeeDao.checkEmail(email);
			if(employeeModel!=null) {
				otp=random.nextInt(10000);
				EmployeeDao.sendEmail(employeeModel.getEmail(), otp);
				request.setAttribute("e", employeeModel);
				request.setAttribute("email", email);
				request.setAttribute("msg", "Enter OTP which is send to the email id..");
				request.getRequestDispatcher("sendotp.jsp").forward(request, response);
			}else {
				request.setAttribute("msg", "Email id not registered..");
				request.getRequestDispatcher("forgotpassword.jsp").forward(request, response);
			}
		}else if(action.equalsIgnoreCase("forgotpassword")) {
			String email=request.getParameter("email");
			int userOtp=Integer.parseInt(request.getParameter("otp"));
			if(userOtp==otp) {
				request.setAttribute("email", email);
				request.getRequestDispatcher("changepassword.jsp").forward(request, response);
			}else {
				request.setAttribute("email", email);
				request.setAttribute("msg", "Enter valid OTP");
				request.getRequestDispatcher("sendotp.jsp").forward(request, response);
			}
		}else if(action.equalsIgnoreCase("changepassword")) {
			String email=request.getParameter("email");
			String newPassword=request.getParameter("newpassword");
			String confirmNewPassword=request.getParameter("confirmnewpassword");
			if(newPassword.equals(confirmNewPassword)) {
				EmployeeDao.updatePassword(email, confirmNewPassword);
				request.setAttribute("msg", "Password updated successfully..");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else {
				request.setAttribute("msg", "NewPassword and ConfirmNewPassword is not match");
				request.getRequestDispatcher("changepassword.jsp").forward(request, response);
			}
		}
	}
}
