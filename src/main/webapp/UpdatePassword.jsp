<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Password</title>
    <link rel="stylesheet" href="Login.css">
</head>
<body>
    <h1>Update Your Password</h1>
    <form action="control" method="post" class="signup-form">
        <label>Username:</label>
        <input type="text" name="username" required><br><br>

        <label>Current Password:</label>
        <input type="password" name="password" required><br><br>

        <label>New Password:</label>
        <input type="password" name="newPassword" required><br><br>

        <input type="submit" name="submit" value="Update Password">
        <input type="hidden" name="id" value="UpdatePassword"/>
    </form>

    <p><a href="HomeLogin.html">Back to Home</a></p>
</body>
</html>
