package com.employee.dao;

import java.util.List;

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
		List<EmployeeModel> employeeModels= session.createQuery("from EmployeeModel e where e.email="+employeeModel.getEmail()+" AND e.password="+employeeModel.getPassword()).list();
		session.close();
		return employeeModels.get(0);
	}
}
