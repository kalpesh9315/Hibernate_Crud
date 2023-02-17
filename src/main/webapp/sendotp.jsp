<%@page import="model.EmployeeModel"%>
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
	EmployeeModel employeeModel= (EmployeeModel)request.getAttribute("e");
	if(request.getAttribute("msg")!=null){%>
		<label style="color: blue;"><%=request.getAttribute("msg") %></label>
<%	}
%>
<body>
<form name="sendotp" action="EmployeeController" method="post">
		<input type="hidden" name="email" value="<%= employeeModel.getEmail()%>">
		<table>
			<tr>
				<td>Enter OTP:</td>
				<td><input type="text" name="otp"> </td>
			</tr>
			
			<tr>
				<td><input type="submit" value="forgotpassword" name="action" class="btn btn-primary"></td>
			</tr>
		</table>
	</form>
</body>
</html>