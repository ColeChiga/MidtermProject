<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
<meta charset="UTF-8">
<title>${destination.name}</title>
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
		<input type="text" name="destinationId" value="${destination.id}"
			readonly="readonly" hidden="hidden" />
		<div class="col align-self-start">
			<p>
				Image: <img src="${destination.imageUrl}" width="400" height="400">
			</p>
		</div>
		<div class="col align-self-center">
			<p>Name: ${destination.name}</p>

			<p>Description: ${destination.description}</p>

			<p>Country: ${destination.country}</p>
			<c:forEach items="${ destination.activity}" var="activity">
	${activity.name }
</c:forEach>

			<h6>Locations:</h6>
			<c:forEach items="${destination.location}" var="location">
			         <c:if test="${location.active}">
				<li><a href="individualLocation.do?locationId=${location.id}">${location.name}</a>
					${location.description} ${location.category.name}</li>
					</c:if>
			</c:forEach>

			</ul>
		</div>
		<div class="col align-self-center">
		
			<form action="removeDestinationActivity.do" method="POST">
				<c:forEach items="${ destination.activity}" var="activity">
				<c:if test="${ sessionUser.id == 1}">
					<input type="text" name="destinationId" value="${destination.id}"
						readonly="readonly" hidden="hidden" />
					<input type="text" name="activityId" value="${activity.id}"
						readonly="readonly" hidden="hidden" />
					<button class="btn btn-outline-danger" type="submit"
						onclick="return confirm('Are you sure?')">Remove Activity</button>
          </c:if>
	Activity Name: ${activity.name } Description: ${activity.description }

	<br>
				</c:forEach>
			</form>

		<c:if test="${ not empty sessionUser}">
			<form action="createActivity.do" method="GET">
				<input type="hidden" name="destinationId" value="${destination.id}">
				<input type="hidden" name="activityId" value="${activity.id}">
				<button type="submit" class="btn btn-warning">Add Activity</button>
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