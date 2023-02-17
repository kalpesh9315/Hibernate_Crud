<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="Home.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
</head>
<%
	if(request.getAttribute("msg")!=null){%>
		<label style="color: red;"><%=request.getAttribute("msg") %></label>
<%	}
%>
<body>
	<h2>Change Password From</h2>
	<form name="changepassword" action="EmployeeController" method="post">
	<input type="hidden" name="email" value="<%=request.getAttribute("email") %>">
		<table>
			<tr>
				<td>New Password:</td>
				<td><input type="password" name="newpassword"> </td>
			</tr>
			<tr>
				<td>Confirm New Password:</td>
				<td><input type="password" name="confirmnewpassword"> </td>
			</tr>
			<tr>
				<td><input type="submit" value="changepassword" name="action" class="btn btn-primary"></td>
			</tr>
		</table>
	</form>
</body>
</html>