<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete User</title>
    <link rel="stylesheet" href="Login.css">
</head>
<body>
    <h1>Delete User Account</h1>
    <form action="control" method="post" class="signup-form">
        <label>Username:</label>
        <input type="text" name="username" required><br><br>

        <label>Password:</label>
        <input type="password" name="password" required><br><br>

        <input type="submit" name="submit" value="Delete Account">
        <input type="hidden" name="id" value="Delete"/>
    </form>

    <p><a href="HomeLogin.html">Back to Home</a></p>
</body>
</html>
