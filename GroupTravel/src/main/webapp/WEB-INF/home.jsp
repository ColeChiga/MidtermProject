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
<jsp:include page="navbar.jsp" />
	<main>

		<div id="myCarousel" class="carousel slide mb-6"
			data-bs-ride="carousel">
			<div class="carousel-indicators">
				<button type="button" data-bs-target="#myCarousel"
					data-bs-slide-to="0" class="" aria-label="Slide 1"></button>
				<button type="button" data-bs-target="#myCarousel"
					data-bs-slide-to="1" aria-label="Slide 2" class=""></button>
				<button type="button" data-bs-target="#myCarousel"
					data-bs-slide-to="2" aria-label="Slide 3" class="active"
					aria-current="true"></button>
			</div>
			<div class="carousel-inner">
				<div class="carousel-item">
					<img
						src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/53/Daytona_Beach_looking_north_from_pier.jpg/1920px-Daytona_Beach_looking_north_from_pier.jpg"
						class="img-fluid" style="width: 100%; height: 500px"
						alt="Talladega Nights">
					<div class="container">
						<div class="carousel-caption text-start">
							<h1>Daytona Beach, Florida</h1>
							<p class="opacity-75">Some representative placeholder content
								for the first slide of the carousel.</p>
							<p>
								<a class="btn btn-lg btn-primary" href="#">Sign up today</a>
							</p>
						</div>
					</div>
				</div>
				<div class="carousel-item">
					<img
						src="https://upload.wikimedia.org/wikipedia/commons/thumb/9/95/Downtown_Miami_Panorama_from_the_Rusty_Pelican_photo_D_Ramey_Logan.jpg/2880px-Downtown_Miami_Panorama_from_the_Rusty_Pelican_photo_D_Ramey_Logan.jpg"
						class="img-fluid" style="width: 100%; height: 500px"
						alt="Serenity">
					<div class="container">
						<div class="carousel-caption">
							<h1>Miami, Florida</h1>
							<p>Some representative placeholder content for the second
								slide of the carousel.</p>
							<p>
								<a class="btn btn-lg btn-primary" href="#">Learn more</a>
							</p>
						</div>
					</div>
				</div>
				<div class="carousel-item active">
					<img
						src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/59/Lake_Eola_Park_in_Orlando_02.jpg/2560px-Lake_Eola_Park_in_Orlando_02.jpg"
						class="img-fluid" style="width: 100%; height: 500px"
						alt="Princess Mononoke">
					<div class="container">
						<div class="carousel-caption text-end">
							<h1>Orlando, Florida</h1>
							<p>Some representative placeholder content for the third
								slide of this carousel.</p>
							<p>
								<a class="btn btn-lg btn-primary" href="#">Browse gallery</a>
							</p>
						</div>
					</div>
				</div>
			</div>
			<button class="carousel-control-prev" type="button"
				data-bs-target="#myCarousel" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="#myCarousel" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Next</span>
			</button>
		</div>


		<!-- Marketing messaging and featurettes
  ================================================== -->
		<!-- Wrap the rest of the page in another container to center all the content. -->

		<div class="container marketing">

			<!-- Three columns of text below the carousel -->
			<div class="row">
				<div class="col-lg-4">
					<img class="bd-placeholder-img rounded-circle" width="140"
						height="140"
						src="https://upload.wikimedia.org/wikipedia/commons/thumb/9/95/Downtown_Miami_Panorama_from_the_Rusty_Pelican_photo_D_Ramey_Logan.jpg/2880px-Downtown_Miami_Panorama_from_the_Rusty_Pelican_photo_D_Ramey_Logan.jpg"
						role="img" aria-label="Placeholder">
					
					<h2 class="fw-normal">New Account</h2>
					<p>Some representative placeholder content for the three
						columns of text below the carousel. This is the first column.</p>
					<p>
						<a class="btn btn-secondary" href="#">Create account »</a>
					</p>
				</div>
				<!-- /.col-lg-4 -->
				<div class="col-lg-4">
					<svg class="bd-placeholder-img rounded-circle" width="140"
						height="140" xmlns="http://www.w3.org/2000/svg" role="img"
						aria-label="Placeholder" preserveAspectRatio="xMidYMid slice"
						focusable="false">
						<title>Placeholder</title><rect width="100%" height="100%"
							fill="var(--bs-secondary-color)"></rect></svg>
					<h2 class="fw-normal">Log in to your account</h2>
					<p>Another exciting bit of representative placeholder content.
						This time, we've moved on to the second column.</p>
					<p>
						<a class="btn btn-secondary" href="#">Log in »</a>
					</p>
				</div>
				<!-- /.col-lg-4 -->
				<div class="col-lg-4">
					<svg class="bd-placeholder-img rounded-circle" width="140"
						height="140" xmlns="http://www.w3.org/2000/svg" role="img"
						aria-label="Placeholder" preserveAspectRatio="xMidYMid slice"
						focusable="false">
						<title>Placeholder</title><rect width="100%" height="100%"
							fill="var(--bs-secondary-color)"></rect></svg>
					<h2 class="fw-normal">View all available destinations</h2>
					<p>And lastly this, the third column of representative
						placeholder content.</p>
					<p>
						<a class="btn btn-secondary" href="#">View Destinations »</a>
					</p>
				</div>
				<!-- /.col-lg-4 -->
			</div>
			<!-- /.row -->


			<!-- START THE FEATURETTES -->

			<hr class="featurette-divider">

			<div class="row featurette">
				<div class="col-md-7">
					<h2 class="featurette-heading fw-normal lh-1">
						First featurette heading. <span class="text-body-secondary">It’ll
							blow your mind.</span>
					</h2>
					<p class="lead"></p>
				</div>
				<div class="col-md-5">
					<svg
						class="bd-placeholder-img bd-placeholder-img-lg featurette-image img-fluid mx-auto"
						width="500" height="500" xmlns="http://www.w3.org/2000/svg"
						role="img" aria-label="Placeholder: 500x500"
						preserveAspectRatio="xMidYMid slice" focusable="false">
						<title>Placeholder</title><rect width="100%" height="100%"
							fill="var(--bs-secondary-bg)"></rect>
						<text x="50%" y="50%" fill="var(--bs-secondary-color)" dy=".3em">500x500</text></svg>
				</div>
			</div>

			<hr class="featurette-divider">

			<div class="row featurette">
				<div class="col-md-7 order-md-2">
					<h2 class="featurette-heading fw-normal lh-1">
						Oh yeah, it’s that good. <span class="text-body-secondary">See
							for yourself.</span>
					</h2>
					<p class="lead"></p>
				</div>
				<div class="col-md-5 order-md-1">
					<svg
						class="bd-placeholder-img bd-placeholder-img-lg featurette-image img-fluid mx-auto"
						width="500" height="500" xmlns="http://www.w3.org/2000/svg"
						role="img" aria-label="Placeholder: 500x500"
						preserveAspectRatio="xMidYMid slice" focusable="false">
						<title>Placeholder</title><rect width="100%" height="100%"
							fill="var(--bs-secondary-bg)"></rect>
						<text x="50%" y="50%" fill="var(--bs-secondary-color)" dy=".3em">500x500</text></svg>
				</div>
			</div>

			<hr class="featurette-divider">

			<div class="row featurette">
				<div class="col-md-7">
					<h2 class="featurette-heading fw-normal lh-1">
						And lastly, this one. <span class="text-body-secondary">Checkmate.</span>
					</h2>
					<p class="lead"></p>
				</div>
				<div class="col-md-5">
					<svg
						class="bd-placeholder-img bd-placeholder-img-lg featurette-image img-fluid mx-auto"
						width="500" height="500" xmlns="http://www.w3.org/2000/svg"
						role="img" aria-label="Placeholder: 500x500"
						preserveAspectRatio="xMidYMid slice" focusable="false">
						<title>Placeholder</title><rect width="100%" height="100%"
							fill="var(--bs-secondary-bg)"></rect>
						<text x="50%" y="50%" fill="var(--bs-secondary-color)" dy=".3em">500x500</text></svg>
				</div>
			</div>

			<hr class="featurette-divider">

			<!-- /END THE FEATURETTES -->

		</div>
		<!-- /.container -->


		<!-- FOOTER -->
		<footer class="container">
			<p class="float-end">
				<a href="#">Back to top</a>
			</p>
		</footer>
	</main>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>