<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Register</title>
</head>
<body>
<div align="left">
	<h2>User Register Form</h2>
		<br>
		<hr>
	<form:form action="registerProcess" method="post" modelAttribute="user">
	
	<label for="id">User id</label>
	<form:input type="text" path="userId" />
	<br><br>
	<label for="name">User Name</label>
	<form:input type="text" path="userName" />
	<br><br>
	<label for="password">User Password</label>
	<form:input type="text" path="userPass" />
	<br><br>
	<label for="phone">Phone</label>
	<form:input type="text" path="phone" />
	<br><br>	
	<label for="aadharid">Aadhar Id</label>
	<form:input type="text" path="aadharId" />
	<br><br>		

			<input type="submit" value="submit" />
	
	</form:form>
	</div>
</body>
</html>