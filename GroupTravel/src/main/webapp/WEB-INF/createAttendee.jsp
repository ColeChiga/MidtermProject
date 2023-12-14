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

	<form action="createAttendee.do" method="POST">
		
			<input type="text" name="vacationId" value="${vacation.id}" readonly="readonly" hidden="hidden" />
						
			<label for="title">*Attendee Name : </label><select name="userId">
			<c:forEach items= "${family.users}" var="user">
					<option  value="${user.id}" >${user.firstName},${user.lastName}</option>
			</c:forEach>
			</select>
			<br> 
			
			<label for="title">Remarks : </label><input type="text" name="remarks" ><br> 
			
			<label for="title">Is Attending? : </label><input type="checkbox" name="confirmed"> <br> 
			
			<button class="btn btn-outline-warning" type="submit">Create Attendee</button>
			
		</form>
		
		<a href=" javascript: history.back()"><button class="btn btn-warning">Go back</button></a>

    <script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>