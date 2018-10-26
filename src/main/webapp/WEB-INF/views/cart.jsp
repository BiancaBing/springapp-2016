<%@ include file="/WEB-INF/views/include.jsp"%>
<html>
	<head>
		<title><fmt:message key="title" /></title>
	
	</head>
	
	
	<body>
	  
		<!--  <script type="text/javascript">
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
		</script>  -->
		
	 	<script language="JavaScript">
	 		function selectall(source) {
	 		  checkboxes = document.getElementsByName('foo');
	 		  for(var i=0, n=checkboxes.length;i<n;i++) {
	 		    checkboxes[i].checked = source.checked;
	 		  }
	 		}
		</script>
	
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
			<input name="foo" type="checkbox" value=""/>
				<c:out value="${prod.description}" />
				<c:out value="seller: ${prod.seller}" />
				<i>$<c:out value="${prod.price}" /></i>
			<a href="product/edit/${prod.id }">edit</a>
			<a href="product/delete/${prod.id }">delete</a>             
			<input type="submit" value="search" />
			<br>
			<br>
		</c:forEach>
		
		<input type="checkbox" onClick="selectall(this)" /> Select All<br/>
		
		<!-- <label><input name="select all" type="checkbox" value="all"/>select all</label> -->
		</sf:form>
		
		<div style="margin-top:50px">
			<form action="add" method="post">
				Location: <input type="text" name="location"/>
				Time: <input type="text" name="time"/>
				Contact: <input type="text" name="contact"/>
				<input type="submit" value="Checkout"/>
			</form>
		</div>
		
		<a href="product/add/${prod.id }">add</a>
	
	</body>
</html>