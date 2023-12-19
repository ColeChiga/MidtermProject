<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
<meta charset="UTF-8">
<title>All Families</title>
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
	color: dark;
	background-image:
		url('https://img.freepik.com/free-photo/cute-animals-group-white-background_23-2150038562.jpg?w=1800&t=st=1702604821~exp=1702605421~hmac=c7292b7316f5de23c1fca7bcda79e7514b9570e907ca88a124b5815859a95c3f');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	font color= dark;
}
	</style>

	<c:forEach items="${ familyList}" var="family">
		<c:if test="${family.enabled }">
		<h3>
			<img src="${family.imageUrl }"
				class="bd-placeholder-img rounded-circle" width="140" height="140"
				role="img" aria-label="Placeholder">
		</h3>
		<c:choose>
		<c:when test="${not empty sessionUser}">
		<a
			class="link-danger link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover"
			href="family.do?familyId=${family.id}">${family.name}</a>
		<h3>${family.description }</h3>
		
		<c:if test="${ sessionUser.id == 1}">
		<form action="deleteFamily.do" method="GET">
					<input type="hidden" name="familyId" value="${family.id}">
					<button type="submit" class="btn btn-danger"
						onclick="return confirm('Are you sure?')">Delete
						${family.name}</button>
				</form>
		</c:if>
		</c:when>
		<c:otherwise>
		<a
			class="link-danger link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover"
			href="login.do">${family.name}</a>
		<h3>${family.description }</h3>
		
		</c:otherwise>
		</c:choose>
		</c:if>
	</c:forEach>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>