<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>

<body>
	<h2>Register From</h2>
	<form name="insert" action="EmployeeController" method="post">
		<table>
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="fname"> </td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lname"> </td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email"> </td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="text" name="password"> </td>
			</tr>
			<% if((String)request.getAttribute("password")!=null){%>
			<%= request.getAttribute("password") %><% }%>
			<tr>
				<td>Confirm Password:</td>
				<td><input type="text" name="confirm_password"> </td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" name="action" class="btn btn-primary"></td>
			</tr>
		</table>
	</form>
	<a href="view.jsp">Show Employee</a><br>
	<a href="login.jsp">Log in</a>

</body>
</html>