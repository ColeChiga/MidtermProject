<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Flight</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
        crossorigin="anonymous">
</head>
<body>
    <jsp:include page="navbar.jsp" />

    <div class="container mt-5">
        <form action="createFlight.do" method="POST">
            <input type="text" name="attendeeId" value="${attendee.id}" readonly="readonly" hidden="hidden" />
            <input type="text" name="vacationId" value="${attendee.vacation.id}" readonly="readonly" hidden="hidden" />
            <input type="text" name="userId" value="${attendee.user.id}" readonly="readonly" hidden="hidden" />

            <div class="mb-3">
                <label for="familyId" class="form-label">*Flight:</label>
                <select class="form-select" name="familyId">
                    <c:forEach items="${attendee.flights}" var="flight">
                        <option value="${flight.id}">${family.airline}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="mb-3">
                <label for="title" class="form-label">*Airline:</label>
                <input type="text" class="form-control" name="airline" value="airline" required>
            </div>
            <div class="mb-3">
                <label for="imageUrl" class="form-label">Flight Number:</label>
                <input type="text" class="form-control" name="flightNumber" value="flightNumber">
            </div>

            <div class="mb-3">
                <label for="description" class="form-label">Departure:</label>
                <input type="datetime-local" class="form-control" name="departure" value="departure">
            </div>
            <div class="mb-3">
                <label for="description" class="form-label">Arrival:</label>
                <input type="datetime-local" class="form-control" name="arrival" value="arrival">
            </div>


            <button class="btn btn-outline-warning" type="submit">Create Flight</button>
        </form>

        <a href="javascript: history.back()" class="btn btn-warning mt-3">Go back</a>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
