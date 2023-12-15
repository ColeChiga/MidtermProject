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
							<p class="opacity-75">Known for Daytona International Speedway.</p>
							<p>
								<a class="btn btn-lg btn-primary" href="http://localhost:8085/individual.do?destinationId=3">View Destination</a>
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
							<p>Famous for its golden beaches, foodie scene and Latin vibe.</p>
							<p>
								<a class="btn btn-lg btn-primary" href="http://localhost:8085/individual.do?destinationId=2">Learn more</a>
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
							<p>Known as the Theme Park Capital of the World</p>
							<p>
								<a class="btn btn-lg btn-primary" href="http://localhost:8085/individual.do?destinationId=1">Browse Destination</a>
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
				<div class="col-lg-4 card mb-3">
					<img class="bd-placeholder-img rounded-circle " width="140"
						height="140"
						src="https://img.freepik.com/free-photo/vertical-shot-wooden-passage-reflective-small-lake-mountain-range-horizon_181624-37099.jpg?w=826&t=st=1702602022~exp=1702602622~hmac=d4f363079c3e740b18c54476ea434020fe5ce016d9b95ba02b3ca1245b51f41d"
						role="img" aria-label="Placeholder">
					<c:choose>
						<c:when test="${! empty sessionUser }">
							<h2 class="fw-normal">Update Account</h2>
							<p>Some representative placeholder content for the three
								columns of text below the carousel. This is the first column.</p>
							<p>
								<a class="btn btn-secondary" href="updateAccount.do">Update
									account »</a>
							</p>
						</c:when>
						<c:otherwise>
						<h2 class="fw-normal">New Account</h2>
						<p>Join your family and make an account to link each others trips together.</p>
						<p>
							<a class="btn btn-warning" href="createAccount.do">Create
								account »</a>
						</p>
						</c:otherwise>
					</c:choose>
				</div>
				<!-- /.col-lg-4 -->
				<div class="col-lg-4 card mb-3">
					<img class="bd-placeholder-img rounded-circle" width="140"
						height="140"
						src="https://img.freepik.com/premium-photo/clear-days-aerial-view-beachs-waves-crashing-shore_410516-2232.jpg?w=1800"
						role="img" aria-label="Placeholder">
					<h2 class="fw-normal">Log in to your account</h2>
					<p>One of the team already? Then come on in and start making memories.</p>
					<p>
						<a class="btn btn-primary" href="http://localhost:8085/login.do">Log in »</a>
					</p>
				</div>
				<!-- /.col-lg-4 -->
				<div class="col-lg-4 card mb-3">
					<img class="bd-placeholder-img rounded-circle" width="140"
						height="140"
						src="https://img.freepik.com/free-photo/vertical-shot-avenue-giants-california_181624-27567.jpg?w=826&t=st=1702601113~exp=1702601713~hmac=1c2a3fa88b5a8815025aed11c5730da00a2b80a88e351b7a40bc1b807a3cfa16"
						role="img" aria-label="Placeholder">
					<h2 class="fw-normal">View all available destinations</h2>
					<p>Check out all the places others have been so far.</p>
					<p>
						<a class="btn btn-success" href="http://localhost:8085/showAllDestinations.do">View Destinations »</a>
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
						Looking for an adventure check out these Destinations. <span class="text-body-secondary"> It’ll
							blow your mind.</span>
					</h2>
					<p class="lead"></p>
				</div>
				<div class="col-md-5">
					<img
						class="bd-placeholder-img bd-placeholder-img-lg featurette-image"
						width="400" height="300" src="https://img.freepik.com/free-photo/beautiful-scenery-emerald-lake-yoho-national-park-british-columbia-canada_181624-6877.jpg?w=900&t=st=1702602171~exp=1702602771~hmac=c030f14b4afd1d7e5dcd49afe87dc28e482833d568d17dd48c78cba0aa42560f"
						role="img" aria-label="Placeholder: 500x500">
						<a href="http://localhost:8085/showAllDestinations.do"><text x="50%" y="50%" fill="var(--bs-secondary-color)" dy=".3em">Destinations</text></a>
				</div>
			</div>

			<hr class="featurette-divider">

			<div class="row featurette">
				<div class="col-md-7 order-md-2">
					<h2 class="featurette-heading fw-normal lh-1">
						Check out these Locations. <span class="text-body-secondary"> See
							for yourself.</span>
					</h2>
					<p class="lead"></p>
				</div>
				<div class="col-md-5 order-md-1">
					<img
						class="bd-placeholder-img bd-placeholder-img-lg featurette-image"
						width="400" height="300" src="https://img.freepik.com/free-photo/world-map-continent-global-support-graphic_53876-124649.jpg?w=900&t=st=1702603256~exp=1702603856~hmac=ba34c94ab6b954e420021c1ee30cb3656464fcf36d2ef977c047024d79a57038"
						role="img" aria-label="Placeholder: 500x500">
						<a href="#"><text x="50%" y="50%" fill="var(--bs-secondary-color)" dy=".3em">Locations</text></a>
				</div>
			</div>

			<hr class="featurette-divider">

			<div class="row featurette">
				<div class="col-md-7">
					<h2 class="featurette-heading fw-normal lh-1">
						Looking for an activity? <span class="text-body-secondary"> Come on over.</span>
					</h2>
					<p class="lead"></p>
				</div>
				<div class="col-md-5">
					<img
						class="bd-placeholder-img bd-placeholder-img-lg featurette-image"
						width="400" height="300" src="https://img.freepik.com/free-photo/always-fun-see-tall-ferris-wheel-when-approaching-park-holidays-full-happy-people_181624-2216.jpg?w=1480&t=st=1702603404~exp=1702604004~hmac=8fc0465936c6f3834861862a0654fa95d50036214c905baf6424315cd04650f2"
						role="img" aria-label="Placeholder: 500x500">
						<a href="#"><text x="50%" y="50%" fill="var(--bs-secondary-color)" dy=".3em">Activites</text></a>
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