<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log in</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>

<body>
	<h2>Login From</h2>
	<form name="login" action="EmployeeController" method="get">
		<table>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email"> </td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="text" name="password"> </td>
			</tr>
			<tr>
				<td><input type="submit" value="login" name="action" class="btn btn-primary"></td>
			</tr>
		</table>
	</form>
	<a href="view.jsp">Show Employee</a>

</body>
</html>