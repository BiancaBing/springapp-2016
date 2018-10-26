<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Checkout</title>
	</head>
	<body>
			
		<h1>Please fill in the details of transaction</h1>
			<form action="checkout" method="post">
				<table>
					<tr>
						<th>Enter the location to meet the seller and complete the transaction face-to-face</th>
						<td><input type="text" name="location"/></td>
					</tr>
					<tr>
						<th>Enter the time to meet with the seller</th>
						<td><input type="text" name="time"/></td>
					</tr>
					<tr>
						<th>Please leave your contact information for the seller to find you</th>
						<td><input type="text" name="contact"/></td>
					</tr>
					<tr>
						<th><a href="cart.htm"><button>Cancel</button></a></th>
						<td><input type="submit" value="Checkout"/></td>
					</tr>
				</table>			
			</form>
	</body>
</html>