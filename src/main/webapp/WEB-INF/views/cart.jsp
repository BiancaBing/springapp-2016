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
	
	 	<script language="JavaScript">
	 		function selectall(source) {
	 		  checkboxes = document.getElementsByName('foo');
	 		  for(var i=0, n=checkboxes.length;i<n;i++) {
	 		    checkboxes[i].checked = source.checked;
	 		  }
	 		}
	 		
	 		function confirmd() {  
	 			            var msg = "Decide to delete?";  
	 			            if (confirm(msg)==true){  
	 			                return true;  
	 			            }else{  
	 			                return false;  
	 			            }  
	 			        }  
		</script>
		
		<a href="cart.htm">cart</a> | <a href="order.htm">order</a> | <a href="sale.htm">sales record</a>
		<h1>
			<fmt:message key="heading" />
		</h1>
		<p>
			<fmt:message key="greeting" />
			<c:out value="${model.now}" />
		</p>
		<h3>Items</h3>
		<sf:form method="POST" modelAttribute="cart">
		<c:forEach items="${model.carts}" var="prod">
			<input name="foo" type="checkbox" value="${prod.id}"/>
				<c:out value="name: ${prod.name}" /> | 
				<c:out value="description: ${prod.description}" /> | 
				<c:out value="seller: ${prod.seller}" /> |
				<c:out value="quantity: ${prod.quantity}" /> | 
				<i>$<c:out value="price: ${prod.price}" /></i>
			<a href="cart/edit/${prod.id }">edit</a>
			<a href="cart/delete/${prod.id }" onclick="return confirmd()">delete</a>             
			<br>
			<a href="cart/checkout/${prod.id }">checkout</a>
			<br>
		</c:forEach>
		
		
		
	<!--  <input type="checkbox" onClick="selectall(this)" /> Select All<br/>
		</sf:form>
		
				<a href="cart/checkout">checkout</a>-->
		
		<a href="cart/add/${prod.id }">add</a>  
	
	</body>
</html>