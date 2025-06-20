<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Forget Password</title>
    <link rel="stylesheet" href="Login.css">
</head>
<body>
    <h1>Forget Password</h1>
    <form action="control" method="post" class="signup-form">
        <label>Username:</label>
        <input type="text" name="username" required><br><br>

        <label>Security Question:</label>
        <input type="text" name="sqn" required><br><br>

        <label>Security Answer:</label>
        <input type="text" name="sqa" required><br><br>

        <input type="submit" name="submit" value="Recover Password">
        <input type="hidden" name="id" value="Forget"/>
    </form>

    <p><a href="HomeLogin.html">Back to Home</a></p>
</body>
</html>
