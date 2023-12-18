<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<nav class="navbar navbar-expand-lg bg-dark body-dark"
	data-bs-theme="dark">

	<div class="container-fluid">
		<a class="navbar-brand" href="#">Group Travel</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="home.do">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="showAllDestinations.do">Show All
						Destinations</a></li>
				<li class="nav-item"><a class="nav-link" href="showAllFamilies.do">Show All
						Families</a></li>
				<li class="nav-item"><a class="nav-link" href="showAllLocations.do">Show All
						Locations</a></li>
			</ul>
			<form class="d-flex" role="search" action="individual.do">
				<input class="form-control me-2" type="text" name="destinationId"
					placeholder="Enter Destination ID" aria-label="Search By Keyword"
					required>
				<button class="btn btn-outline-warning" type="submit">Search
					By Destination ID</button>
			</form>
		</div>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
			<c:choose>
				<c:when test="${! empty sessionUser }">
					<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="logout.do">Logout</a></li>
					<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="account.do">Account</a></li>
				</c:when>
				<c:otherwise>
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="login.do">Login</a></li>
				</c:otherwise>
			</c:choose>
					</ul>
		</div>
	</div>
</nav>