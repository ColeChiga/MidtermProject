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

		<p>Name: ${location.name}</p>
		
		<p>Description: ${location.description}</p>
		
		<p>: ${location.category.name}</p>
		<p>: ${location.category.description}</p>
		
		
		<form action="updateLocation.do" method="GET">
							<input type="hidden" name="locationId" value="${location.id}"> 
							<button type="submit" class="btn btn-warning">update
								Location</button>
						</form>



	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>

</body>
</html>