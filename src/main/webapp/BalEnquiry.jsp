<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Balance Enquiry</title>
    <link rel="stylesheet" href="SignUp.css">
</head>
<body>
    <h1>Balance Enquiry</h1>
    <form action="log" method="post" class="signup-form">
        <label for="accNo">Account No:</label>
        <input type="text" name="accNo" id="accNo" required/><br><br>

        <label for="accType">Account Type:</label>
        <input type="text" name="accType" id="accType" required/><br><br>

        <input type="submit" name="submit" value="Check Balance"/>
        <input type="hidden" name="id" value="BE"/>
    </form>

    <div class="links">
        <a href="Home.jsp">Home</a><br>
        <a href="HomeLogin.html">Logout</a><br>
    </div>
</body>
</html>
