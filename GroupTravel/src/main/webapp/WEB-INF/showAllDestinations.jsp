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

	<hr class="featurette-divider">
	<c:choose>
		<c:when test="${! empty destinationList }">
			<c:forEach var="destinationList" items="${destinationList}">

				<div class="row featurette">
					<div class="col-md-7">
						<h2 class="featurette-heading fw-normal lh-1">
							${destinationList.name} <span class="text-body-secondary">Insert
								funny comment</span>
						</h2>

						<p class="lead"></p>
					</div>
					<div class="col-md-5">
						<img
							class="bd-placeholder-img bd-placeholder-img-lg featurette-image img-fluid mx-auto"
							width="500px" height="500px" src="${destinationList.imageUrl}"
							role="img" aria-label="Placeholder: 500x500">
						<title>${destinationList.name}</title>
						<rect width="25%" height="500px" fill="var(--bs-secondary-bg)"></rect>
						<text x="50%" y="50%" fill="var(--bs-secondary-color)" dy=".3em">500x500</text>
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