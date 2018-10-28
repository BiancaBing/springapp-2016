<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Order Details</title>
		<style>
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map {
        height: 100%;
      }
      /* Optional: Makes the sample page fill the window. */
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
    </style>
	</head>
	<body>
			
		<h1>Please check the Order Information and confirm the transaction</h1>
		<div id="map"></div>
		<script>
		      var map;
		      function initMap() {
		        map = new google.maps.Map(document.getElementById('map'), {
		          center: {lat: -33.888531, lng: 151.187358},
		          zoom: 18
		        });
		      }
   		 </script>
    	 <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAdnvWJa8Uwn0dC5-R6g1BK13kyH_q0Gvk&callback=initMap"
    async defer></script>		
			<sf:form method="POST" modelAttribute="sale">
			<fieldset>
				<table>
					<tr>
						<th><label for="sale_location">Location: </label></th>
						<td><sf:input path="location" /></td>
					</tr>
					<tr>
						<th><label for="sale_time">Time to meet:</label></th>
						<td><sf:input path="time" /></td>
					</tr>
					<tr>
						<th><label for="sale_contact">Contact Information:</label></th>
						<td><sf:input path="contact" /></td>
					</tr>
					<tr>
						<th><label for="sale_quantity">Quantity:</label></th>
						<td><sf:input path="quantity" /></td>
					</tr>
					<tr>			
						<td><input type="submit" value="Confirm"/></a></td>
						
					</tr>
				</table>			
			</fieldset>
			
		</sf:form>
	</body>
</html>