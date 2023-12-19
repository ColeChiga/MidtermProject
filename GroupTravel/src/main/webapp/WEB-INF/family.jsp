<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
<meta charset="UTF-8">
<title>Family</title>
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
		url('https://www.savoredjourneys.com/wp-content/uploads/2014/09/bora-bora-beach.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	font
	color=
	black;
}
</style>
	<br>
		<div class = "row align-items-start container-fluid">
<!-- 		<div class="mx-auto my-auto p-2" style="width: 200px"> -->

			<c:forEach items="${ sessionFamily}" var="family">

			<div class="col align-self-start">
				<h3>
					<img class="bd-placeholder-img rounded-circle" width="250"
						height="250" src="${family.imageUrl }" role="img"
						aria-label="Family Image">
				</h3>
			</div>
			<div class="col align-self-center">
			<h2>${family.name }</h2>
				<h4>${family.description }</h4>
				

				<!--Join Family button  -->

				<h4>Family Members</h4>
				<ul>
				<c:forEach items="${ family.users}" var="user">
					<c:if test="${user.enabled }">
						<li>${user.firstName } ${user.lastName }</li>

					</c:if>
				</c:forEach>
				</ul>
				<h4>Vacations</h4>
				<ul>
				<c:forEach items="${ family.vacations}" var="vacation">
					<li>
					<a
						class="link-dark link-offset-2 link-underline-opacity-0 link-underline-opacity-100-hover"
						href="vacation.do?vacationId=${vacation.id}">${vacation.title}</a>
					</li>
				</c:forEach>
				</ul>

				</div>
			<div class="col align-self-center">
			
				<c:if test="${family.users.contains(sessionUser)}">
				<form action="createVacation.do">
					<input type="hidden" name="userId" value=${sessionUser.id} >
					<button type="submit" class="btn btn-warning">Create
						Vacation</button>
				</form>
				</c:if>
				<c:if test="${not family.users.contains(sessionUser)}">
				<form action="updateFamily.do" method="POST">
					<input type="hidden" name="familyId" value=${family.id} > <input
						type="hidden" name="userId" value=${sessionUser.id} >
					<button type="submit" class="btn btn-warning">Add Yourself</button>
				</form>
				</c:if>
				<c:if test="${sessionUser.id == family.user.id}">
				<form action="updateFamilyValues.do" method="GET">
					<input type="hidden" name="familyId" value=${family.id} >
					<button type="submit" class="btn btn-warning">Update
						Family</button>
				</form>

				<form action="deleteFamily.do" method="GET">
					<input type="hidden" name="familyId" value="${family.id}">
					<button type="submit" class="btn btn-danger"
						onclick="return confirm('Are you sure?')">Delete
						${family.name}</button>
				</form>
				</c:if>
			</div>
			</c:forEach>
			
		</div>

		<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>
