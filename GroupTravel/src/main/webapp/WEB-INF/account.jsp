<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account</title>
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
		url('https://img.freepik.com/free-photo/beautiful-shot-crystal-clear-lake-snowy-mountain-base-during-sunny-day_181624-5459.jpg?w=996&t=st=1702339490~exp=1702340090~hmac=caa52a0f569d9fc76ba6ea20f19451ea908e1889768173984421aec9e5ccdc6d');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	font
	color=
	black;
}
</style>
	<br>
	<div class="mx-auto p-2" style="width: 200px">
		<h1>Hello ${sessionUser.firstName}</h1>

		<!--First Name  -->
		<p>First Name: ${sessionUser.firstName}</p>
		<!-- Last Name -->
		<p>Last Name: ${sessionUser.lastName}</p>
		<!-- Username -->
		<p>Username: ${sessionUser.username}</p>
		<!-- Address -->
		<p>Address: ${sessionUser.address.street}
			${sessionUser.address.city}, ${sessionUser.address.state}
			${sessionUser.address.postalCode}</p>

		<!-- Family -->
		<h3>Families:</h3>
		<c:forEach items="${sessionUser.families}" var="family">
			<input type="hidden" name="familyId" value="${family.id}" >
			<a
				class="link-warning link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover"
				href="family.do?familyId=${family.id}">${family.name}</a>
			<br>
		</c:forEach>

		<!-- Vacations -->
		<h3>Vacations:</h3>
		<c:forEach items="${sessionUser.vacations}" var="vacation">
			<a
				class="link-warning link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover"
				href="vacation.do?vacationId=${vacation.id}">${vacation.title}</a>
			<br>
		</c:forEach>

		<!--About Me-->
		<h1>About Me</h1>
		<!--Image URL -->
		<img src="${sessionUser.imageUrl}" width="400" height="400" />
		<p>${sessionUser.aboutMe}</p>


		<!-- Comments -->

		<form action="updateAccount.do">
			<input type="hidden" name="userId" value=${sessionUser.id} >
			<button type="submit" class="btn btn-warning">Update Account</button>
		</form>

		<form action="deleteAccount.do" method="GET">
			<input type="hidden" name="userId" value=${sessionUser.id} >
			<button type="submit" class="btn btn-danger"
				onclick="return confirm('Are you sure?')">Delete
				${sessionUser.firstName}'s Account</button>
		</form>
	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>