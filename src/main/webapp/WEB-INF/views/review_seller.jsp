<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Order Details</title>
		<style>
      
    	</style>
	</head>
	
	<body>
		<h1 style="color:blue;text-align:center">Product Review</h1>
			<sf:form method="POST" modelAttribute="sale">
			<fieldset>
				<table>
					<tr>
						<th><label for="sale_review">Review: </label></th>
						<td><sf:input path="review" /></td>
					</tr>
					<tr>
						<!-- th><a href="sale.htm"><button>Cancel</button></a></th -->
						<!-- This hidden field is required for Hibernate to recognize this Product -->
				
						<td><input type="submit" value="Confirm"/></a></td>
						
					</tr>
				</table>			
			</fieldset>
			
		</sf:form>
	</body>
</html>