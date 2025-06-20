<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Account</title>
    <link rel="stylesheet" href="SignUp.css"> <!-- Link to external CSS -->
</head>
<body>
    <h2>Delete Account</h2>
    <form action="log" method="post" class="signup-form">
        <label for="accNo">Account No:</label>
        <input type="text" name="accNo" id="accNo" required/><br><br>

        <label for="accType">Account Type:</label>
        <input type="text" name="accType" id="accType" required/><br><br>

        <input type="submit" name="submit" value="Delete Account"/>
        <input type="hidden" name="id" value="DA"/>
    </form>

    <div class="links">
        <a href="Home.jsp">Home</a><br>
        <a href="logout.jsp">Logout</a>
    </div>
</body>
</html>
