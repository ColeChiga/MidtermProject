<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
<meta charset="UTF-8">
<title>${location.name}</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body>
	<jsp:include page="navbar.jsp" />
	 <input type="text" name="locationId" value="${location.id}" readonly="readonly" hidden="hidden" />
		<p>Image: <img src="${location.imageUrl}" width="400" height="400" ></p>

		<h3>Name: ${location.name}</h3>
		
		<p>Description: ${location.description}</p>
		<p>Estimated Cost: ${location.estimatedCost}</p>
		<p>Destination: <a href="individual.do?destinationId=${location.destination.id}">${location.destination.name}</a></p>
		<p>Address: ${location.address.street} ${location.address.city}, ${location.address.state} ${location.address.postalCode}</p>
		
		<p>Location Category: ${location.category.name}</p>
		<p>${location.category.description}</p>
		
		
		<form action="updateLocation.do" method="GET">
							<input type="hidden" name="locationId" value="${location.id}"> 
							<button type="submit" class="btn btn-warning">Update
								Location</button>
						</form>
	<%-- 	<form action="deleteLocation.do" method="GET">
							<input type="hidden" name="locationId" value="${location.id}"> 
							<button type="submit" class="btn btn-danger">Remove
								Location</button>
						</form> --%>

<br><br>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>

</body>
</html>