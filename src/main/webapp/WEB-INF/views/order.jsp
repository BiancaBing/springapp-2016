<%@ include file="/WEB-INF/views/include.jsp"%>
<html>
	<head>
		<title><fmt:message key="title" /></title>
		
		<style type="css">
			
		</style>
	</head>
	
	
	<body>
		
		<a href="cart.htm">cart</a> | <a href="order.htm">order</a> | <a href="sales.htm">sales record</a>
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
			<!--<a href="order/edit/${ord.id }">edit</a> -->			      
			<th><a href="order/change/${ord.id }"><input type="button" value="${ord.review}" /></a></th>        
			<br>
			<br>
		</c:forEach>
				
		<!-- <label><input name="select all" type="checkbox" value="all"/>select all</label> -->
		</sf:form>
	
	</body>
</html>