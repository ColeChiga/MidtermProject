<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body>
	<jsp:include page="navbar.jsp" />
	
	<style>
	body {
	color: white;
	background-image:
		url('https://img.freepik.com/free-photo/beautiful-view-greenery-bridge-forest-perfect-background_181624-17827.jpg?w=996&t=st=1702335822~exp=1702336422~hmac=a31850c515ef04268bec60f6be9179a211a49b487792d575e2258b0e92be9083');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	font color= white;
}
	</style>
<br>
<div class="col-3"></div>
<div class="col-9">
<div class="container">
	<form action="login.do" method="post">
  <div class="row">
    <div class="col-9"><h3>Sign in</h3></div>
  <div class="row">
    <div class="col-9">Username: </div>
    <div class="col-6"><input type="text" name="username"> </div>
				<div class="row">
    <div class="col-9">Password: </div>
					<div class="col-6">
						<input type="password" name="password">
					</div>
						<div class="row">
							<div class="col-4">
								<input type="submit" value="Log In">
							</div>


						</div>
					</div>
				</div>
			</div>
	</form>
</div> 
</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>