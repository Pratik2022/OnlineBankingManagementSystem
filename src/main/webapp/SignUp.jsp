<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sign Up Page</title>
    <link rel="stylesheet" href="Login.css"> <!-- External CSS -->
</head>
<body>
    <h1>Indian Cental Bank</h1>
    <form action="control" method="Post" class="signup-form">
    <h4>Create a new account</h4>
        <label>Username:</label>
        <input type="text" name="username" required><br><br>

        <label>Password:</label>
        <input type="password" name="password" required><br><br>

        <label>Security Question:</label>
        <input type="text" name="sqn" required><br><br>

        <label>Security Answer:</label>
        <input type="text" name="sqa" required><br><br>

        <input type="submit" name="submit" value="Sign Up">
        <input type="hidden" name="id" value="SignUp"/>
    </form>
</body>
</html>
