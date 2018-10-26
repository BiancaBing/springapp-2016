<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Edit an old product on this page</title>
	</head>
	<body>
			
		<h1>You can edit the product shown below</h1>
		<sf:form method="POST" modelAttribute="cart">
			<fieldset>
				<table>
					<tr>
						<!--<th><label for="cart_description">Description:</label></th>-->
						<!--<td><sf:input path="description"/></td> -->
						<th><label for="cart_quantity">Quantity:</label></th>
						<td><sf:input path="quantity"/></td> 
					</tr>
					<tr>
						<!--<th><label for="cart_seller">Seller:</label></th>-->
						<!--<td><sf:input path="seller"/></td>-->
					</tr>
					<tr>
						<!--<th><label for="cart_price">Price</label></th>-->
						<!--<td><sf:input path="price"/></td>-->
					</tr>
					<tr>
						<th><a href="cart.htm"><button>Cancel</button></a></th>
						<!-- This hidden field is required for Hibernate to recognize this Product -->
						<td><sf:hidden path="id"/>
						<td><input type="submit" value="Done"/></td>
					</tr>
				</table>			
			</fieldset>
		</sf:form>
	</body>
</html>