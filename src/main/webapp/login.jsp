<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="Home.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log in</title>
</head>
<%
	if(request.getAttribute("msg")!=null){%>
		<label style="color: red;"><%=request.getAttribute("msg") %></label>
<%	}
%>
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
	<a href="view.jsp">Show Employee</a><br>
	<a href="forgotpassword.jsp">Forgot Password</a>

</body>
</html>