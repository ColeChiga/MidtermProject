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

    <div class="container mt-5">
        <form action="updateDestinationActivity.do" method="GET">
            <input type="text" name="destinationId" value="${destination.id}" readonly="readonly" hidden="hidden" />

            <div class="mb-3">
                <label for="destinationId" class="form-label">*Current Destination Activities:</label>
                <select class="form-select" name="activityId">
                    <c:forEach items="${ activities}" var="activity">
                        <option value="${activity.id}">${activity.name} ${activity.description}</option>
                        <br>
                    </c:forEach>
                </select>
            <button class="btn btn-outline-success" type="submit" onclick="return confirm('Are you sure?')">Update Activity</button>
            </div>
		</form>
		
        <form action="createDestinationActivity.do" method="POST">
            <input type="text" name="destinationId" value="${destination.id}" readonly="readonly" hidden="hidden" />
            <div class="mb-3">
                <label for="title" class="form-label">*Destination Activity:</label>
                <input type="text" class="form-control" name="name" placeholder="name" required>
            </div>
            <div class="mb-3">
                <label for="title" class="form-label">Description:</label>
                <input type="text" class="form-control" name="description" placeholder="description">
            </div>

            <div class="mb-3">
                <label for="title" class="form-label">Estimated Time In Hours:</label>
                <input type="text" class="form-control" name="estimatedTimeInHours" placeholder="Estimated Time In Hours">
            </div>
            <div class="mb-3">
                <label for="title" class="form-label">Estimated Cost:</label>
                <input type="text" class="form-control" name="estimatedCost" placeholder="estimatedCost">
            </div>
       
            <button class="btn btn-outline-warning" type="submit">Create Activity</button>
        </form>

        <a href="javascript: history.back()" class="btn btn-warning mt-3">Go back</a>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
