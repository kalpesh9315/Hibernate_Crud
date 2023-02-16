package com.employee.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.EmployeeModel;

public class EmployeeUtil {
	
	 public static Session createSession() {

		 SessionFactory factory=new Configuration()
				 .addAnnotatedClass(EmployeeModel.class)
				 .configure()
				 .buildSessionFactory();
		Session session= factory.openSession();
		return session;
	}
}
