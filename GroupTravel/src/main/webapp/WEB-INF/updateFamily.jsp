<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
<meta charset="UTF-8">
<title>Update Family</title>
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
		url('https://media.istockphoto.com/id/1300296030/photo/tropical-beach-palm-trees-sea-wave-and-white-sand.jpg?s=612x612&w=0&k=20&c=6xdlJDxSp5FVUpQC7AOt3ooHYPd3-gTQNF6lmwX5krk=');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	font
	color=
	black;
}
</style>
	<br>
	<div class="mx-auto p-2" style="width: 300px">

		<h1>Update ${sessionFamily.name}</h1>
		
		<form action="updateFamilyValues.do" method="POST">

			<input type="text" name="familyId" value="${sessionFamily.id}"
				readonly="readonly" hidden="hidden" /> <label for="title">*Family
				Name : </label><br><input type="text" name="name" value="${sessionFamily.name}"
				required><br> <label for="title">Description :
			</label><br><input type="text" name="description"
				value="${sessionFamily.description}"><br> <label
				for="title">Image URL : </label><br><input type="text" name="imageUrl"
				value="${sessionFamily.imageUrl}" maxlength="2000"> <br>

			<button class="btn btn-outline-warning" type="submit">Update
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