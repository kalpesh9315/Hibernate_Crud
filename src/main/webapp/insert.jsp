<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="Home.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	if(request.getAttribute("msg")!=null){%>
		<label style="color: red;"><%=request.getAttribute("msg") %></label>
<%	}
%>
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
			<tr>
				<td>Confirm Password:</td>
				<td><input type="text" name="confirm_password"> </td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Submit" name="action" class="btn btn-primary"></td>
			</tr>
		</table>
	</form>
	<a href="view.jsp">Show Employee</a><br>
</body>
</html>