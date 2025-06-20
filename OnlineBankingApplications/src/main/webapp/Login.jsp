<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <link rel="stylesheet" href="Login.css">
</head>
<body>
    <h1>Indian Central Bank</h1>
    <form action="control" method="post" class="signup-form">
        <h4>Login Page</h4>
    
        <label>Username:</label>
        <input type="text" name="username" required><br><br>

        <label>Password:</label>
        <input type="password" name="password" required><br><br>

        <input type="submit" name="submit" value="Login">
        <input type="hidden" name="id" value="LogIn"/>
    </form>
</body>
</html>
