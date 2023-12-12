<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
<meta charset="UTF-8">
<title>Vacation</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body>
	<jsp:include page="navbar.jsp" />

	<form action="vacation.do" method="GET">


		<c:forEach items="${ sessionVacation}" var="vacation">

			<h3>
				<img src="${vacation.imageUrl }">
			</h3>
			<h3>${vacation.title }</h3>
			<h3>${vacation.description }</h3>



			<p>${vacation.user.firstName }</p>
			<p>${vacation.user.lastName }</p>
			<p>${vacation.family.name}</p>
		<c:forEach items="${vacation.destinations}" var="destination">
			<p>${destination.destination.name}</p>
		</c:forEach>
			


			<%--  <c:forEach items="${ vacation.vacations}" var="vacation">
	
		<a
				class="link-warning link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover"
				href="home.do">${vacation.title}</a>
	
	</c:forEach>--%>
		</c:forEach>


	</form>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>
</body>
</html>