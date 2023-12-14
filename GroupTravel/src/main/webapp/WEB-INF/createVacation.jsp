<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
<meta charset="UTF-8">
<title>Create Vacation</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body>
	<jsp:include page="navbar.jsp" />

	<form action="createVacation.do" method="POST">
		
			<input type="text" name="userId" value="${sessionUser.id}" readonly="readonly" hidden="hidden" />
						
			<label for="title">*Family: </label>
					<select name="familyId">
			<c:forEach items= "${sessionUser.families}" var="family">
					<option  value="${family.id}" >${family.name }</option>
			</c:forEach>
			</select>
			<br> 
			
			<label for="title">*Vacation Name : </label><input type="text" name="title" value="" required><br> 			
			
			<label for="title">Description : </label><input type="text" name="description" value="" ><br> 
			
			<label for="title">Image URL : </label><input type="text" name="imageUrl" value=""> <br> 
			
			<button class="btn btn-outline-warning" type="submit">Create Vacation</button>
			
		</form>
		
		<a href=" javascript: history.back()"><button class="btn btn-warning">Go back</button></a>

    <script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>