<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Hotel</title>
</head>
<body>
<div align="left">
	<h2>Hotel Info Input Form</h2>
		<br>
		<hr>
	<form:form action="insertprocess" method="post" modelAttribute="hotel">
	
	<label for="id">Hotel id</label>
	<form:input type="text" path="hotelId" />
	<br><br>
	<label for="name">Hotel Name</label>
	<form:input type="text" path="hotelName" />
	<br><br>
	<label for="location">Hotel Location</label>
	<form:input type="text" path="location" />
	<br><br>
	<label for="ratings">Hotel Ratings</label>
	<form:input type="text" path="ratings" />
	<br><br>	
	<label for="swimmingPool">Swimming pools</label>
	<form:input type="text" path="swimmingPool" />
	<br><br>		
	<label for="tourGuide">Tour Guide </label>
	<form:input type="text" path="tourGuide" />
	<br><br>
	<label for="price">Price</label>
	<form:input type="text" path="price" />
	<br><br>		
	<label for="discount">Discount</label>
	<form:input type="text" path="discount" />
	<br>
			<br>

			<input type="submit" value="submit" />
	
	</form:form>
</div>	
</body>
</html>