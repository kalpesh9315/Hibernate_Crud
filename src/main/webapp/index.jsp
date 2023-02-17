<%@page import="model.EmployeeModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		EmployeeModel employeeModel =(EmployeeModel)session.getAttribute("e");
		if(employeeModel!=null){
	%>
	<h1 style="color: blue;">Welcome <%=employeeModel.getFirstName() %> <%=employeeModel.getLastName() %></h1>
	<%} %>
	<input type="submit" name="logout">
</body>
</html>