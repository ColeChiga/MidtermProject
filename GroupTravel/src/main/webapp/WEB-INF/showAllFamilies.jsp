<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
<meta charset="UTF-8">
<title>Title</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body>
	<jsp:include page="navbar.jsp" />


	<c:forEach items="${ familyList}" var="family">
		<c:if test="${family.enabled }">
		<h3>
			<img src="${family.imageUrl }"
				class="bd-placeholder-img rounded-circle" width="140" height="140"
				role="img" aria-label="Placeholder">
		</h3>
		<a
			class="link-warning link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover"
			href="family.do?familyId=${family.id}">${family.name}</a>
		<h3>${family.description }</h3>
		</c:if>
	</c:forEach>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>