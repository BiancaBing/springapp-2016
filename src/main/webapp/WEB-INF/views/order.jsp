<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
	<head>
		<title><fmt:message key="title" /></title>
		
		<style type="css">
			
		</style>
	</head>
	
	
	<body>
		
		<a href="cart.htm">cart</a> | <a href="order.htm">order</a> | <a href="sale.htm">sales record</a>
		<h1>My Order</h1>
		<p>
			<fmt:message key="greeting" />
			<c:out value="${model.now}" />
		</p>
		<h3>Items</h3>
		<sf:form method="POST" modelAttribute="order">
		<c:forEach items="${model.orders}" var="ord">
				<c:out value="name: ${ord.name}" /> | 
				<c:out value="description: ${ord.description}" /> | 
				<c:out value="quantity: ${ord.quantity}" /> | 
				<c:out value="status: ${ord.status}" /> | 
				<i>$<c:out value="price: ${ord.price}" /></i>
			<th><a href="order/change/${ord.id }"><input type="button" value="${ord.review}" /></a></th>        
			<br>
			<br>
		</c:forEach>
				
		</sf:form>
	
	</body>
</html>