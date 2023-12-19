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
	<style>
body {
	color: black;
	background-image:
		url('http://m.gettywallpapers.com/wp-content/uploads/2021/12/Cool-Desktop-Wallpaper.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	font
	color=
	black;
}
</style>
	<div class="row align-items-start container-fluid">
		<input type="text" name="locationId" value="${location.id}"
			readonly="readonly" hidden="hidden" />
		<div class="col align-self-start">
			<p>
				Image: <img src="${location.imageUrl}" width="400" height="400">
			</p>
		</div>
		<div class="col align-self-center">
			<h3>Name: ${location.name}</h3>

			<p>Description: ${location.description}</p>
			<p>Estimated Cost: ${location.estimatedCost}</p>
			<p>
				Destination: <a
					href="individual.do?destinationId=${location.destination.id}">${location.destination.name}</a>
			</p>
			<p>Address: ${location.address.street} ${location.address.city},
				${location.address.state} ${location.address.postalCode}</p>

			<p>Location Category: ${location.category.name}</p>
			<p>${location.category.description}</p>
		</div>
		<div class="col align-self-center">
			<c:if test="${ not empty sessionUser}">
			<form action="updateLocation.do" method="GET">
				<input type="hidden" name="locationId" value="${location.id}">
				<button type="submit" class="btn btn-warning">Update
					Location</button>
			</form>
			</c:if>
			<c:if test="${ sessionUser.id == 1}">
			<form action="deleteLocation.do" method="GET">
				<input type="hidden" name="locationId" value="${location.id}">
				<button type="submit" class="btn btn-danger">Remove
					Location</button>
			</form>
			</c:if>

		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>

</body>
</html>