<%@ include file="/WEB-INF/views/include.jsp"%>
<html>
	<head>
		<title><fmt:message key="title" /></title>
	
	</head>
	
	
	<body>
	<!--  
		<script type="text/javascript">
			function confirmDialog(){
				if(confirm("checkout?")){
					alert("Continue");
					return true;
				}
				else{
					alert("Bye");
					return false;
				}
			}
		</script>
	 -->
	
		<a href="cart.htm">cart</a> | <a href="order.html">order</a> | <a href="sales.html">sales record</a>
		<form action="demo_form.php"method="get">
			<input type="search" name="search1"/>
			<input type="submit" value="search" />
		</form>
		<h1>
			<fmt:message key="heading" />
		</h1>
		<p>
			<fmt:message key="greeting" />
			<c:out value="${model.now}" />
		</p>
		<h3>Products</h3>
		<sf:form method="POST" modelAttribute="product">
		<c:forEach items="${model.products}" var="prod">
			<input name="cart" type="checkbox" value=""/>
				<c:out value="${prod.description}" />
				<i>$<c:out value="${prod.price}" /></i>
			<a href="product/edit/${prod.id }">edit</a>
			<a href="product/delete/${prod.id }">delete</a>             
			<input type="submit" value="search" />
			<br>
			<br>
		</c:forEach>
		<label><input name="select all" type="checkbox" value="all"/>select all</label>
		</sf:form>
		
		<div style="margin-top:50px">
			<!-- a href="javascript:confirmDialog();">checkout</a-->
			<!-- input type="button" value="confirm" onclick="confirmDialog"/-->
		</div>
		
		<a href="product/add/${prod.id }">add</a>
		
		<!-- link to the increase price page -->
		<br>
		<a href="<c:url value="priceincrease.htm"/>">Increase Prices</a>
		<br>
	</body>
</html>