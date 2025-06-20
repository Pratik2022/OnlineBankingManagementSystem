<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Open Account</title>
    <link rel="stylesheet" href="SignUp.css">
</head>
<body>
    <h2>Open New Account</h2>
    <form action="log" method="post" class="signup-form">
        <label for="accType">Account Type:</label>
        <input type="text" name="accType" id="accType" required/><br><br>

        <label for="amount">Amount:</label>
        <input type="text" name="amount" id="amount" required/><br><br>

        <input type="submit" name="submit" value="Open Account"/>
        <input type="hidden" name="id" value="OA"/>
    </form>
</body>
</html>
