<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
<meta charset="UTF-8">
<title>Create Family</title>
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
}
</style>
	<br>
	<div class="mx-auto my-auto p-2" style="width: 300px">

		<h1>Create a Family</h1>

		<form action="createFamily.do" method="POST">

			<input type="text" name="familyId" value="${sessionFamily.id}"
				readonly="readonly" hidden="hidden" /> <label for="title">*Family
				Name : </label><br><input type="text" name="name" value="${sessionFamily.name}"
				required><br> <label for="title">Description :
			</label><br> <textarea rows="4" cols="50" name="description">Description</textarea>
				 <br><label for="title">Image URL : </label><br><input type="text" name="imageUrl"
				value="${sessionFamily.imageUrl}" maxlength="2000"> <br>

			<button class="btn btn-outline-warning" type="submit">Create
				Family</button>

		</form>

		<a href=" javascript: history.back()"><button
				class="btn btn-warning">Go back</button></a>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>