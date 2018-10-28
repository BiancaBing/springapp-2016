<%@ include file="/WEB-INF/views/include.jsp"%>
<html>
	<head>
		<title><fmt:message key="title" /></title>
		
		<style type="css">
			
		</style>
	</head>
	
	
	<body>
		
		<a href="cart.htm">cart</a> | <a href="order.htm">order</a> | <a href="sale.htm">sales record</a>
		<h1>Sales Record</h1>
		<p>
			<fmt:message key="greeting" />
			<c:out value="${model.now}" />
		</p>
		<h3>Items</h3>
		<sf:form method="POST" modelAttribute="sale">
		<c:forEach items="${model.sales}" var="sal">
				<c:out value="name: ${sal.name}" /> | 
				<c:out value="description: ${sal.description}" /> | 
				<c:out value="quantity: ${sal.quantity}" /> | 
				<c:out value="status: ${sal.status}" /> | 
				<i>$<c:out value="price: ${sal.price}" /></i>
			<th><a href="sale/change/${sal.id }"><input type="button" value="${sal.saleprint}" /></a></th>        
			<br>
			<br>
		</c:forEach>
				
		<!-- <label><input name="select all" type="checkbox" value="all"/>select all</label> -->
		</sf:form>
	
	</body>
</html>