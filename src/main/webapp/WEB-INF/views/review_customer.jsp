<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Write a review</title>
	</head>
	<body>
			
		<h1>Product Review:</h1>
		<form action="review" method="post" modelAttribute="order">
			 <input type="text" name="review" />
			 <br>
			 <br>
			<input type="submit" value="Add"/>
		</form>
	</body>
</html>