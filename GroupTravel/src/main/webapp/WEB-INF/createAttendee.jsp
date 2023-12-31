<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
<meta charset="UTF-8">
<title>Create Attendee</title>
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

	<form action="createAttendee.do" method="POST">
		<input type="text" name="vacationId" value="${vacation.id}"
			readonly="readonly" hidden="hidden" /> 
			<label for="title">*AttendeeName : </label>
		<c:choose>
		<c:when test="${sessionUser.id == vacation.user.id}">
			<select name="userId">
			<c:forEach items="${family.users}" var="user">
				<c:if test="${not vacation.userIsAttendee(user.id) }">
					<option value="${user.id}">${user.firstName},
						${user.lastName}</option>
				</c:if>
			</c:forEach>
		</select>
		<br>
			</c:when>
			<c:otherwise>
			<input type="text" name="userId" value="${sessionUser.id}" readonly="readonly" hidden="hidden">
			<h6>${sessionUser.firstName} ${sessionUser.lastName}</h6>
			
			</c:otherwise>
			</c:choose>
		 <label for="title">Remarks : </label><input type="text"
			name="remarks"><br> <label for="title">Is
			Attending? : </label><input type="checkbox" name="confirmed"> <br>
		
		
		
		<label for="title">Hotel: </label>
			<select
			name="hotelId">
				<option value="-1">None</option>
			<c:forEach items="${hotels}" var="hotel">
			<c:if test="${hotel.active}">
				<option value="${hotel.id}">${hotel.name}</option>
				</c:if>
			</c:forEach>
		</select>
<br>
		
		
		
		<label for="title">Flying  </label>	
			<input type="radio" name="flight" value="true" checked> Yes 
			<input type="radio" name="flight" value="false"> No
			
			
		<button class="btn btn-outline-warning" type="submit">Create
			Attendee</button>

	</form>
	
	<c:choose>
		<c:when test="${sessionUser.id == vacation.user.id}">
	<c:forEach items="${vacation.attendees}" var="attendee">
		<div>
			Name: ${attendee.user.firstName} ${attendee.user.lastName}
			<form action="removeAttendee.do" method="GET">
				<input type="hidden" name="userId" value="${attendee.user.id}">
				<input type="hidden" name="vacationId" value="${vacation.id}">
				<button type="submit" class="btn btn-danger"
					onclick="return confirm('Are you sure?')">Delete Attendee</button>
			</form>
		</div>
	</c:forEach>
</c:when>
<c:otherwise>

Name: ${sessionUser.firstName} ${sessionUser.lastName}
			<form action="removeAttendee.do" method="GET">
				<input type="hidden" name="userId" value="${sessionUser.id}">
				<input type="hidden" name="vacationId" value="${vacation.id}">
				<button type="submit" class="btn btn-danger"
					onclick="return confirm('Are you sure?')">Delete Attendee</button>
			</form>

</c:otherwise>
</c:choose>
	<a href=" javascript: history.back()"><button
			class="btn btn-warning">Go back</button></a>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>