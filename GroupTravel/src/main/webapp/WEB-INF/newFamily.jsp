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
		url('https://image.cnbcfm.com/api/v1/image/106016751-1562954520333gettyimages-908178810.jpeg?v=1644429267');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	font
	color=
	black;
}
</style>
	<br>
	<div class="row align-items-start container-fluid">
		<!-- 		<div class="mx-auto my-auto p-2" style="width: 200px"> -->


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
		</div>

		<div class="col align-self-center">

			<a href=" account.do"><button class="btn btn-warning">Account</button></a>
			<a href=" family.do?familyId=${sessionFamily.id}"><button
					class="btn btn-warning">Family Page</button></a> <a
				href=" javascript: history.back()"><button
					class="btn btn-warning">Go back</button></a>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>