<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
<meta charset="UTF-8">
<title>Vacation Details</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body>
	<jsp:include page="navbar.jsp" />

	<div class="container mt-4">
		<c:choose>
			<c:when test="${not empty vacation}">
				<div class="row">
					<div class="col-md-8">
						<div class="card mb-3">
							<img src="${vacation.imageUrl}" class="card-img-top"
								alt="Vacation Image">
							<div class="card-body">
								<h5 class="card-title">${vacation.title}</h5>
								<p class="card-text">${vacation.description}</p>
								<p class="card-text">
									<small class="text-muted">Created By:
										${vacation.user.firstName} ${vacation.user.lastName}</small>
								</p>
								<p class="card-text">
									<small class="text-muted">Family: ${vacation.family.name}</small>
								</p>
									<c:forEach items="${vacation.destinations}" var="destination">
										<li class="list-group-item">Destination: ${destination.destination.name}</li>
									</c:forEach>
								
								<h6 class="card-subtitle mt-3 mb-2 text-muted">Confirmed
									Attendees:</h6>
								<ul class="list-group list-group-flush">
									<c:forEach items="${vacation.attendees}" var="attendee">
										<c:if test="${attendee.confirmed}">
											<li class="list-group-item">${attendee.user.firstName}
												${attendee.user.lastName}</li>
										</c:if>
									</c:forEach>
								</ul>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<form action="updateVacation.do" method="GET">
							<input type="hidden" name="vacationId" value="${vacation.id}">
							<button type="submit" class="btn btn-warning mb-2">Update
								Vacation</button>
						</form>
						<form action="createAttendee.do" method="GET">
							<input type="hidden" name="familyId"
								value="${vacation.family.id}"> <input type="hidden"
								name="vacationId" value="${vacation.id}">
							<button type="submit" class="btn btn-warning">Add/Remove
								Attendee</button>
						</form>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div class="alert alert-warning" role="alert">Vacation not
					found</div>
			</c:otherwise>
		</c:choose>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>
