<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
<meta charset="UTF-8">
<title>Show All Destinations</title>
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
		url('http://m.gettywallpapers.com/wp-content/uploads/2022/06/World-Map-Wallpaper-HD.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	font
	color=
	white;
}
</style>

	<hr class="featurette-divider">
	<c:choose>
		<c:when test="${! empty destinationList }">
			<c:forEach var="destinationList" items="${destinationList}">
			Destination ID : ${destinationList.id}
			<input type="text" name="destinationId" value="${destinationList.id}" readonly="readonly" hidden="hidden" />
				<div class="row featurette">
					<div class="col-md-7">
						<h2 class="featurette-heading fw-normal lh-1">
							${destinationList.name} <span class="text-body-secondary">${destinationList.description}</span>
						</h2>
						<form action="showAllActivities.do" method="GET">
			<input type="text" name="destinationId" value="${destinationList.id}" readonly="readonly" hidden="hidden" />
							<button class="btn btn-outline-warning" type="submit">Show
								All Activities</button>
						</form>
						<p class="lead"></p>
					</div>
					<div class="col-md-5">
						<a href="individual.do?destinationId=${destinationList.id}"><img
							class="bd-placeholder-img bd-placeholder-img-lg featurette-image"
							width="500px" height="250px" src="${destinationList.imageUrl}"
							role="img" aria-label="Placeholder: 500x500"></a>
						<title>${destinationList.name}</title>
						<rect width="25%" height="500px" fill="var(--bs-secondary-bg)"></rect>
						<text x="50%" y="50%" fill="var(--bs-secondary-color)" dy=".3em">${destinationList.country}</text>
					</div>
				</div>
				<hr class="featurette-divider">
			</c:forEach>
		</c:when>
		<c:otherwise>
			<h1>No Destinations Found</h1>

		</c:otherwise>
	</c:choose>






	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>