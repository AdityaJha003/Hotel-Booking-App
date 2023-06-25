<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User-Login</title>
</head>
<body>
	<h3>USER LOGIN</h3>
	<form:form action="loginUser" method="post" modelAttribute="user">
	<label for="userId">UserId</label>
	<form:input type="text" path="userId"/>
	<p style="color: red">${err}</p>
	<label for="userPass">User Password</label>
	<form:input type="password" path="userPass"/>
	<p style="color: red">${error}</p>
	<br>
	<br>
	<input type="submit" value="login">
	</form:form>
	
<a href="/Hotel_Booking/register">New User Sign Up</a>	
<br><br>
<a href="/Hotel_Booking/">Take me to home page</a>
</body>
</html>