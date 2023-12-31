<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Account</title>
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
		url('http://m.gettywallpapers.com/wp-content/uploads/2023/04/Beautiful-Nature-Computer-Wallpaper-scaled.jpg');
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

		<form action="updateAccount.do" method="POST">
		
			<input type="text" name="userId" value="${sessionUser.id}" readonly="readonly" hidden="hidden" />
						
			<label for="title">*First Name : </label><input type="text" name="firstName" value="${sessionUser.firstName}" required><br> 
			
			<label for="title">*Last Name : </label><input type="text" name="lastName" value="${sessionUser.lastName}" required><br> 
			
			<label for="title">*Username : </label><input type="text" name="username" value="${sessionUser.username}" required><br>
			
			<label for="title">*password : </label><input type="password" name="password" value="${sessionUser.password}" required><br> 
			
			<label for="title">*Image URL : </label><input type="text" name="imageUrl" value="${sessionUser.imageUrl}"> <br> 
			
			<label for="title">*About Me : </label> <textarea rows="4" cols="50" name="aboutMe">${sessionUser.aboutMe}</textarea>
			
			<label for="title">*Address : </label> <input type="text" name="addressId" value="${sessionAddress.id}" readonly="readonly" hidden="hidden" />
			
			<label for="title">*Street : </label><input type="text" name="street" value="${sessionAddress.street}" required><br>
			
			<label for="title">*City : </label><input type="text" name="city" value="${sessionAddress.city}" required><br>
			
			<label for="title">*State : </label><input type="text" name="state" value="${sessionAddress.state}" required><br>
			
			<label for="title">*Postal Code : </label><input type="text" name="postalCode" value="${sessionAddress.postalCode}" required><br>
			
			<button class="btn btn-outline-warning" type="submit">Update Account</button>
			
		</form>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>