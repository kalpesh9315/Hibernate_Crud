package com.employee.dao;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.employee.util.EmployeeUtil;

import model.EmployeeModel;

public class EmployeeDao {

	public static void insertEmployee(EmployeeModel employeeModel) {
		Session session=EmployeeUtil.createSession();
		Transaction transaction= session.beginTransaction();
		session.save(employeeModel);
		transaction.commit();
		session.close();
	}
	
	public static List<EmployeeModel> getAllEmployee()
	{
		Session session= EmployeeUtil.createSession();
		List<EmployeeModel> employeeModels= session.createQuery("from EmployeeModel").list();
		session.close();
		return employeeModels;
	}
	
	public static EmployeeModel getEmployee(int id)
	{
		Session session= EmployeeUtil.createSession();
		EmployeeModel employeeModel= session.get(EmployeeModel.class, id);
		session.close();
		return employeeModel;
	}
	
	public static void updateEmployee(EmployeeModel employeeModel) {
		Session session=EmployeeUtil.createSession();
		Transaction transaction= session.beginTransaction();
		session.saveOrUpdate(employeeModel);
		transaction.commit();
		session.close();
	}
	
	public static void deleteEmployee(int id) {
		Session session=EmployeeUtil.createSession();
		Transaction transaction= session.beginTransaction();
		EmployeeModel employeeModel=session.get(EmployeeModel.class, id);
		session.delete(employeeModel);
		transaction.commit();
		session.close();
	}
	
	public static EmployeeModel login(EmployeeModel employeeModel)
	{
		Session session= EmployeeUtil.createSession();
		EmployeeModel employeeModels= (EmployeeModel)session.createQuery("from EmployeeModel e where e.email=:email and e.password=:password").setParameter("email", employeeModel.getEmail()).setParameter("password", employeeModel.getPassword()).uniqueResult();
		session.close();
		return employeeModels;
	}
	public static EmployeeModel checkEmail(String email)
	{
		Session session= EmployeeUtil.createSession();
		EmployeeModel employeeModel= (EmployeeModel)session.createQuery("from EmployeeModel e where e.email=:email").setParameter("email", email).uniqueResult();
		session.close();
		return employeeModel;
	}
	
	public static void sendEmail(String email, int otp) {
		final String senderEmail="serviceprovider8055@gmail.com";
		final String password="fwbtirjofxywluvz";
		
		Properties properties=new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		javax.mail.Session session=javax.mail.Session.getInstance(properties,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderEmail, password);
			}
		});
		
		try {
			Message message=new MimeMessage(session);
			message.setFrom(new InternetAddress(senderEmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject("OTP for forgot password");
			
			message.setText("Dear User ,"+"\n \n Your OTP for forgot password is :"+otp);
			Transport.send(message);
			System.out.println("done");
			
		}catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	public static void updatePassword(String email,String password) {
		Session session=EmployeeUtil.createSession();
		Transaction transaction= session.beginTransaction();
		EmployeeModel employeeModel=(EmployeeModel)session.createQuery("from EmployeeModel e where e.email=:email").setParameter("email", email).uniqueResult();
		employeeModel.setPassword(password);
		session.saveOrUpdate(employeeModel);
		transaction.commit();
		session.close();
	}
}
