<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Order Details</title>
	</head>
	<body>
			
		<h1>Please check the Order Information and confirm the transaction</h1>
			<sf:form method="POST" modelAttribute="info">
			<c:foreach item="${model.infos}" var="info">
			<fieldset>
				<table>
					<tr>
						<th><label for="info_location">Location: </label></th>
						<td><c:out value="${info.location}" /></td>
					</tr>
					<tr>
						<th><label for="info_time">Time to meet:</label></th>
						<td><c:out value="${info.time}" /></td>
					</tr>
					<tr>
						<th><label for="info_contact">Contact Information:</label></th>
						<td><c:out value="${info.contact}" /></td>
					</tr>
					<tr>
						<th><label for="info_quantity">Quantity:</label></th>
						<td><c:out value="${info.quantity}" /></td>
					</tr>
					<tr>
						<th><a href="sale.htm"><button>Cancel</button></a></th>
						<!-- This hidden field is required for Hibernate to recognize this Product -->
						<td><sf:hidden path="id"/>
						<td><input type="submit" value="Confirm"/></td>
						<td><input type="submit" value="Refuse"/></td>
					</tr>
				</table>			
			</fieldset>
			</c:foreach>
		</sf:form>
	</body>
</html>