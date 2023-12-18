<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Destination</title>
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
        <form action="addVacationDestination.do" method="POST">
            <input type="text" name="vacationId" value="${vacation.id}" readonly="readonly" hidden="hidden" />

            <div class="mb-3">
                <label for="familyId" class="form-label">*Vacation Destination:</label>
                <select class="form-select" name="destinationId">
                    <c:forEach items="${destinations}" var="destination">
                        <option value="${destination.id}">${destination.name} ${destination.description}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="mb-3">
                <label for="title" class="form-label">Remarks:</label>
                <input type="text" class="form-control" name="remarks" value="remarks">
            </div>
            <button class="btn btn-outline-success" type="submit">Add Destination</button>
		</form>
		
        <form action="createVacationDestination.do" method="POST">
            <input type="text" name="vacationId" value="${vacation.id}" readonly="readonly" hidden="hidden" />
            <div class="mb-3">
                <label for="title" class="form-label">*Vacation Destination:</label>
                <input type="text" class="form-control" name="name" value="name" required>
            </div>
            <div class="mb-3">
                <label for="title" class="form-label">Description:</label>
                <input type="text" class="form-control" name="description" value="description">
            </div>

            <div class="mb-3">
                <label for="title" class="form-label">Country:</label>
                <input type="text" class="form-control" name="country" value="country">
            </div>
            <div class="mb-3">
                <label for="title" class="form-label">Image:</label>
                <input type="text" class="form-control" name="imageUrl" value="image Url">
            </div>
            <div class="mb-3">
                <label for="title" class="form-label">Remarks:</label>
                <input type="text" class="form-control" name="remarks" value="remarks">
            </div>


            <button class="btn btn-outline-warning" type="submit">Create Destination</button>
        </form>

        <a href="javascript: history.back()" class="btn btn-warning mt-3">Go back</a>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
