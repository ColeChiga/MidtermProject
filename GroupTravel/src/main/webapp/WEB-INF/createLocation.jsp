<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Location</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
        crossorigin="anonymous">
</head>
<body>
    <jsp:include page="navbar.jsp" />

    <div class="container mt-5">
        <form action="createLocation.do" method="POST">
            <input type="text" name="vacationId" value="${vacationId}" readonly="readonly" hidden="hidden" />

            <div class="mb-3">
                <label for="destinationId" class="form-label">*Location Destination:</label>
                <select class="form-select" name="destinationId">
                    <c:forEach items="${ destinations}" var="destination">
                        <option value="${destination.id}">${destination.name} ${destination.description}</option>
                    </c:forEach>
                </select>
            </div>
		
            <div class="mb-3">
                <label for="title" class="form-label">*Location name:</label>
                <input type="text" class="form-control" name="locationName" value="name" required>
            </div>
            <div class="mb-3">
                <label for="title" class="form-label">Location Description:</label>
                <input type="text" class="form-control" name="locationDescription" value="Location Description">
            </div>

            <div class="mb-3">
                <label for="title" class="form-label">*Estimated Cost</label>
                <input type="number" step="0.01" min="0.00" class="form-control" name="estimatedCost" value="00.00" data-type="currency" required>
            </div>
             <div class="mb-3">
                <label for="title" class="form-label">Image URL</label>
                <input type="text" step="0.01" min="0.00" class="form-control" name="imageUrl" value="image Url">
            </div>
            
            
            
             	<div class="mb-3">
                <label for="locationCategoryId" class="form-label">*Location category:</label>
                    <input type="text" class="form-control" list="locationCategory" name="categoryName"/>
                    <datalist id="locationCategory">
                    <c:forEach items="${categoryList}" var="category">
                        <option value= "${category.name}"> ${category.description}</option>
                    </c:forEach>
                    </datalist>
				<div class="mb-3">
					<label for="title" class="form-label">Category Description:</label> <input
						type="text" class="form-control" name="categoryDescription"
						value="category description">
				</div>
			</div>
            
            <div class="mb-3">
                <label for="title" class="form-label">Address:</label>
				
				<label for="title">*Street : </label><input type="text" name="street" value="street" required><br>
				
				<label for="title">*City : </label><input type="text" name="city" value="city" required><br>
				
				<label for="title">*State : </label><input type="text" name="state" value="state" required><br>
				
				<label for="title">*Postal Code : </label><input type="text" name="postalCode" value="postal Code" required><br>
            </div>
       
            <button class="btn btn-outline-warning" type="submit">Create Location</button>
        </form>

        <a href="javascript: history.back()" class="btn btn-warning mt-3">Go back</a>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
