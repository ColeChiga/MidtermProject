<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Vacation</title>
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
        <form action="updateVacation.do" method="POST">
            <input type="text" name="userId" value="${sessionUser.id}" readonly="readonly" hidden="hidden" />
            <input type="text" name="vacationId" value="${sessionVacation.id}" readonly="readonly" hidden="hidden" />

            <div class="mb-3">
                <label for="familyId" class="form-label">*Family:</label>
                <select class="form-select" name="familyId">
                    <c:forEach items="${sessionUser.families}" var="family">
                        <option value="${family.id}">${family.name}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="mb-3">
                <label for="title" class="form-label">*Vacation Name:</label>
                <input type="text" class="form-control" name="title" value="${sessionVacation.title}" required>
            </div>

            <div class="mb-3">
                <label for="description" class="form-label">Description:</label>
                <input type="text" class="form-control" name="description" value="${sessionVacation.description}">
            </div>

            <div class="mb-3">
                <label for="imageUrl" class="form-label">Image URL:</label>
                <input type="text" class="form-control" name="imageUrl" value="${sessionVacation.imageUrl}">
            </div>
			  <div class="mb-3">
                <label for="startDate" class="form-label">*Start Date:</label>
                <input type="date" class="form-control" name="startDate" value="${sessionVacation.startDate}" required>
            </div>
            <div class="mb-3">
                <label for="endDate" class="form-label">*End Date:</label>
                <input type="date" class="form-control" name="endDate" value="${sessionVacation.endDate}" required>
            </div>
			
            <button class="btn btn-outline-success" type="submit">Update Vacation</button>
        </form>

        <a href="javascript: history.back()" class="btn btn-warning mt-3">Go back</a>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
