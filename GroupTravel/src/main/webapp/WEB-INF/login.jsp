<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
</head>
<body>
<jsp:include page="navbar.jsp"/>

<style>
    body {
        color: white;
        background-image: url('https://img.freepik.com/free-photo/beautiful-view-greenery-bridge-forest-perfect-background_181624-17827.jpg?w=996&t=st=1702335822~exp=1702336422~hmac=a31850c515ef04268bec60f6be9179a211a49b487792d575e2258b0e92be9083');
        background-repeat: no-repeat;
        background-attachment: fixed;
        background-size: cover;
    }
    .transparent-card {
        background-color: rgba(255, 255, 255, 0.5); 
        border: none;
    }
</style>

<br>
<div class="mx-auto p-2" style="max-width: 400px;">
    <div class="card text-dark transparent-card">
        <div class="card-body">
            <h3 class="card-title text-center">Sign In</h3>
            <form action="login.do" method="post">
                <div class="mb-3">
                    <label for="username" class="form-label">Username:</label>
                    <input type="text" class="form-control" id="username" name="username">
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password:</label>
                    <input type="password" class="form-control" id="password" name="password">
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary">Log In</button>
                </div>
            </form>
        </div>
    </div>
    <div class="card text-dark transparent-card mt-3">
        <div class="card-body">
            <h3 class="card-title text-center">Sign Up</h3>
            <div class="text-center">
                <small><a href="createAccount.do">Don't have an account? Sign Up</a></small>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
