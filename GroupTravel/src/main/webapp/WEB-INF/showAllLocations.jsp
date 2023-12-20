<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
<meta charset="UTF-8">
<title>Show All Locations</title>
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
	color: white;
	background-image:
		url('http://m.gettywallpapers.com/wp-content/uploads/2022/06/USA-Map-Background-Photos.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	font color= white;
}
	</style>

	<hr class="featurette-divider">
	<c:choose>
		<c:when test="${! empty locationList }">
			<c:forEach var="location" items="${locationList}">
			<c:if test="${location.active}">
				<div class="row featurette">
					<div class="col-md-7">
						<h2 class="featurette-heading fw-normal lh-1">
							${location.name} <span class="text-body-secondary">${location.description}</span>
						</h2>
						<h3>Category: ${location.category.name} ${location.category.description}</h3>
						<h4>Estimated Cost: ${location.estimatedCost}</h4>
						<h4>Destination: ${location.destination.name} ${location.destination.description}</h4>
						<h4>Address: ${location.address.street} ${location.address.city} ${location.address.state}</h4>

						<p class="lead"></p>
					</div>
					<div class="col-md-5 ">
						<a href="individualLocation.do?locationId=${location.id}"><img
							class="bd-placeholder-img bd-placeholder-img-lg featurette-image"
							width="500px" height="250px" src="${location.imageUrl}"
							role="img" aria-label="Placeholder: 500x500"></a>
						<title>${location.name}</title>
						<rect width="25%" height="500px" fill="var(--bs-secondary-bg)"></rect>
						<h5 style="color: black ">${location.name}</h5>
					</div>
				</div>
		<hr class="featurette-divider">
		</c:if>
	</c:forEach>
		</c:when>
		<c:otherwise>
			<h1>No Destinations Found</h1>

		</c:otherwise>
	</c:choose>
			<c:if test="${ not empty sessionUser}">
		<form action="createLocation.do" method="GET">
							<input type="hidden" name="vacationId" value="-1"> 
							<button type="submit" class="btn btn-warning">Create
								Location</button>
						</form>
						</c:if>




	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>