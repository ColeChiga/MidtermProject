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
									<small class="text-muted">Family:
										${vacation.family.name}</small>
								</p>

								<h6 class="card-subtitle mt-3 mb-2 text-muted">Confirmed
									Attendees:</h6>
								<ul class="list-group list-group-flush">
									<c:forEach items="${vacation.attendees}" var="attendee">
										<c:if test="${attendee.confirmed}">

												<li class="list-group-item">${attendee.user.firstName}
													${attendee.user.lastName}</li>
												<c:if test="${not empty attendee.location}">
												<c:if test="${attendee.location.active}">
													<h6>Hotel:</h6>
													<a href="individualLocation.do?locationId=${attendee.location.id}">${attendee.location.name}</a> ${attendee.location.description}

														<form action="removeHotel.do" method="POST">
														<input type="hidden" name="vacationId"
															value="${attendee.vacation.id}">
														<input type="hidden" name="userId"
															value="${attendee.user.id}">
														<button type="submit" class="btn btn-outline-danger btn-sm">remove hotel
															</button>
														</form>
														</c:if>
												</c:if>

											<c:if test="${not empty attendee.flights}">
												<ul class="list-group list-group-flush">
													<c:forEach items="${ attendee.flights}" var="flight">
														${flight.airline}, Departs: ${flight.departure}, Arrival: ${flight.arrival}
													</c:forEach>
												</ul>
											</c:if>
									
</c:if>
									</c:forEach>
									<c:forEach items="${vacation.attendees}" var="attendee">
										<c:if test="${not attendee.confirmed}">
											<h6 class="card-subtitle mt-3 mb-2 text-muted">Unconfirmed
												Attendees</h6>
											<li class="list-group-item">${attendee.user.firstName}
												${attendee.user.lastName}</li>

										</c:if>

									</c:forEach>
								</ul>
								<h6 class="card-subtitle mt-3 mb-2 text-muted">Destinations:</h6>
								<ul class="list-group list-group-flush">
									<c:forEach items="${destinations}" var="destination">
										<c:if test="${not empty destination}">
											<c:if test="${destination.active}">
												<li class="list-group-item">
													<form action="removeVacationDestination.do" method="POST">
														<a
															href="individual.do?destinationId=${destination.destination.id}">${destination.destination.name},
															${destination.destination.description}</a>

														<%-- ${destination.remarks} <input type="hidden"
															name="vacationId" value="${vacation.id}"> <input
															type="hidden" name="destinationId" --%>

														${destination.remarks}
														<ul class="list-group list-group-flush">
															<c:forEach items="${destination.destination.activity}"
																var="activity">
													${activity.name} 
												</c:forEach>
															<ul>
																<h6>Locations:</h6>
																<c:forEach items="${destination.destination.location}" var="location">
																<c:if test="${attendee.location.active}">
																	
																	<li><a
																		href="individualLocation.do?locationId=${location.id}">${location.name}</a>
																		${location.description} ${location.category.name}</li>
																		</c:if>
																</c:forEach>
</ul>
														</ul>
														<input type="hidden" name="vacationId"
															value="${vacation.id}"> <input type="hidden"
															name="destinationId"
															value="${destination.destination.id}">
														<button type="submit" class="btn btn-danger mb-2 btn-sm"
															onclick="return confirm('Are you sure?')">Remove
															destination</button>
													</form>

													<form action="createDestinationVote.do" method="POST">
														<input type="hidden" name="familyId"
															value="${vacation.family.id}"> <input
															type="hidden" name="vacationId" value="${vacation.id}">
														<input type="hidden" name="destinationId"
															value="${destination.destination.id}"> <input
															type="radio" name="vote" value="true" checked>
														Yes <input type="radio" name="vote" value="false">
														No
														<button type="submit">Vote</button>
														<textarea rows="4" cols="50" name="voteRemarks"
															placeholder="Add Remarks"></textarea>

														<ul>

															<c:forEach var="vote"
																items="${destination.destinationVotes}">
																<li>${vote.attendee.user.firstName}
																	${vote.attendee.user.lastName}: ${vote.vote ? 'Yes' : 'No'}
																</li>
															</c:forEach>
														</ul>

													</form>



												</li>
											</c:if>

										</c:if>
										<br>
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
						<form action="createVacationDestination.do" method="GET">
							<input type="hidden" name="familyId"
								value="${vacation.family.id}"> <input type="hidden"
								name="vacationId" value="${vacation.id}">
							<button type="submit" class="btn btn-warning">Add
								Destination</button>
						</form>

						<form action="createVacationComment.do" method="GET">
							<input type="hidden" name="familyId"
								value="${vacation.family.id}"> <input type="hidden"
								name="vacationId" value="${vacation.id}">
							<textarea rows="4" cols="50" name="comment" value="Add Comment"></textarea>
							<button type="submit" class="btn btn-warning">Add
								Comment</button>
						</form>
						<ul class="list-group list-group-flush">
							<c:forEach items="${vacation.vacationComments}" var="comment">
														 ${comment.user.firstName} ${comment.user.lastName}: ${comment.comment}  
								<form action="removeComment.do" method="POST">
									<input type="hidden" name="commentId" value="${comment.id}"><input
										type="hidden" name="vacationId" value="${vacation.id}">
									<button type="submit"
										class="btn btn-outline-danger mb-2 btn-sm"
										onclick="return confirm('Are you sure?')">Remove
										comment</button>
								</form>
								<br>
							</c:forEach>


						</ul>

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
