<%@page import="model.EmployeeModel"%>
<%@page import="java.util.List"%>
<%@page import="com.employee.dao.EmployeeDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>

<%if((String)request.getAttribute("msg")!=null) {%>
<h3><%= request.getAttribute("msg") %></h3><%} %>
<body>

	<table width="100%" border="1" cellspacing="10px" cellpadding="10px">
	<tr>
		<td>ID</td>
		<td>First Name</td>
		<td>Last Name</td>
		<td>Email</td>
		<td>Action</td>
		<td>Action</td>
	</tr>
	<% 
		List<EmployeeModel> employeeModels= EmployeeDao.getAllEmployee();
		for(EmployeeModel employeeModel:employeeModels){
	%>			
	<tr>
		<td><%= employeeModel.getId() %></td>
		<td><%= employeeModel.getFirstName() %></td>
		<td><%= employeeModel.getLastName() %></td>
		<td><%= employeeModel.getEmail() %></td>
		<td>
			<form method="post" action="EmployeeController">
			<input type="hidden" name="id" value=<%=employeeModel.getId() %>>
			<input type="submit" value="edit" name="action" class="btn btn-primary">
			</form>
		</td>
		<td>
			<form method="post" action="EmployeeController">
			<input type="hidden" name="id" value=<%=employeeModel.getId() %>>
			<input type="submit" value="delete" name="action" class="btn btn-danger">
			</form>
		</td>
	</tr>			
	<% 	}
	%>
	</table>
	<a href="insert.jsp">Register</a>
</body>
</html>