<%@page import="model.EmployeeModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<%  EmployeeModel employeeModel= (EmployeeModel)request.getAttribute("employeeModel"); %>
<body>
	
	<form name="update" action="EmployeeController" method="post">
		<table>
			<tr>
				<td><input type="hidden" name="id" value="<%= employeeModel.getId()%>"> </td>
			</tr>
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="fname" value="<%= employeeModel.getFirstName()%>"> </td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lname" value="<%= employeeModel.getLastName()%>"> </td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email" value="<%= employeeModel.getEmail()%>"> </td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="text" name="password" value="<%= employeeModel.getPassword()%>"> </td>
			</tr>
			<tr>
				<td><input type="submit" value="update" name="action" class="btn btn-primary"></td>
			</tr>
		</table>
	</form>

</body>
</html>