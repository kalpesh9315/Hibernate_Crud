<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="Home.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgot password</title>
</head>
<%
	if(request.getAttribute("msg")!=null){%>
		<label style="color: red;"><%=request.getAttribute("msg") %></label>
<%	}
%>
<body>
<h2>Forgot password</h2>
	<form name="forgotpassword" action="EmployeeController" method="post">
		<table>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email"> </td>
			</tr>
			
			<tr>
				<td><input type="submit" value="sendotp" name="action" class="btn btn-primary"></td>
			</tr>
		</table>
	</form>

</body>
</html>