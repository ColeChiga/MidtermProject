<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Activity</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
        crossorigin="anonymous">
</head>
<body>
    <jsp:include page="navbar.jsp" />

    <div class="container mt-5">
        <form action="updateDestinationActivity.do" method="POST">
            <input type="text" name="destinationId" value="${destination.id}" readonly="readonly" hidden="hidden" />
            <input type="text" name="activityId" value="${activity.id}" readonly="readonly" hidden="hidden" />

       
            <div class="mb-3">
                <label for="title" class="form-label">*Destination Activity:</label>
                <input type="text" class="form-control" name="name" value="${activity.name }" required>
            </div>
            <div class="mb-3">
                <label for="title" class="form-label">Description:</label>
                <input type="text" class="form-control" name="description" value="${activity.description }">
            </div>

            <div class="mb-3">
                <label for="title" class="form-label">Estimated Time In Hours:</label>
                <input type="text" class="form-control" name="estimatedTimeInHours" value="${activity.estimatedTimeInHours }">
            </div>
            <div class="mb-3">
                <label for="title" class="form-label">Estimated Cost:</label>
                <input type="text" class="form-control" name="estimatedCost" value="${activity.estimatedCost }">
            </div>
       
            <button class="btn btn-outline-warning" type="submit">Update Activity</button>
        </form>

        <a href="javascript: history.back()" class="btn btn-warning mt-3">Go back</a>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
