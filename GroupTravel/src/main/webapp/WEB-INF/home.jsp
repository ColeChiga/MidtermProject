<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<html>
<head>
<meta charset="UTF-8">
<title>Travel App</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body>

	<h1>Travel App</h1>

	<div id="carouselExampleCaptions" class="carousel slide"
		data-bs-ride="carousel">
		<div class="carousel-indicators">
			<button type="button" data-bs-target="#carouselExampleCaptions"
				data-bs-slide-to="0" class="active" aria-current="true"
				aria-label="Slide 1"></button>
			<button type="button" data-bs-target="#carouselExampleCaptions"
				data-bs-slide-to="1" aria-label="Slide 2"></button>
			<button type="button" data-bs-target="#carouselExampleCaptions"
				data-bs-slide-to="2" aria-label="Slide 3"></button>
		</div>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<a href="singleMovie.do?movieId=1"><img
					src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/59/Lake_Eola_Park_in_Orlando_02.jpg/2560px-Lake_Eola_Park_in_Orlando_02.jpg"
					class="img-fluid" style="max-width: 200px;" alt="Princess Mononoke"></a>

				<div class="carousel-caption d-none d-md-block">
					<h5>Orlando</h5>
				</div>
			</div>
			<div class="carousel-item">
				<a href="singleMovie.do?movieId=2"><img
					src="https://upload.wikimedia.org/wikipedia/commons/thumb/9/95/Downtown_Miami_Panorama_from_the_Rusty_Pelican_photo_D_Ramey_Logan.jpg/2880px-Downtown_Miami_Panorama_from_the_Rusty_Pelican_photo_D_Ramey_Logan.jpg"
					class="img-fluid" style="max-width: 200px;" alt="Serenity"></a>

				<div class="carousel-caption d-none d-md-block">
					<h5>Miami</h5>
				</div>
			</div>
			<div class="carousel-item">
				<a href="singleMovie.do?movieId=5"><img
					src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/53/Daytona_Beach_looking_north_from_pier.jpg/1920px-Daytona_Beach_looking_north_from_pier.jpg"
					class="img-fluid" style="max-width: 200px;" alt="Talladega Nights"></a>

				<div class="carousel-caption d-none d-md-block">
					<h5>Daytona Beach</h5>
				</div>
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>
