<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Account Status</title>
    <link rel="stylesheet" href="style.css"> <!-- Link to external CSS -->
</head>
<body>
    <div class="container">
        <%
            Integer accNo = (Integer) session.getAttribute("accNo");
            String accType = (String) session.getAttribute("accType");
            Float accBal = (Float) session.getAttribute("accBal");

            if (accNo != null && accType != null && accBal != null) {
        %>
                <h2>Account Opened Successfully!</h2>
                <p>The Account No: <strong><%= accNo %></strong></p>
                <p>The Account Type: <strong><%= accType %></strong></p>
                <p>The Account Current Balance: <strong><%= accBal %></strong></p>
        <%
            } else {
        %>
                <h2>Error: Account details not found in session.</h2>
        <%
            }
        %>

        <div class="links">
            <p><a href="Home.jsp">Home</a></p>
            <p><a href="Logout.jsp">Logout</a></p>
        </div>
    </div>
</body>
</html>
