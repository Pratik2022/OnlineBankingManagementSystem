<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Deposit Money</title>
    <link rel="stylesheet" href="style.css"> <!-- Link to external CSS -->
</head>
<body>
    <div class="container">
        <h2>Amount Deposited Successfully!</h2> 

        <%
            Float newBal = (Float) session.getAttribute("updatedBal");
            Integer accNo = (Integer) session.getAttribute("accNo");
        %>

        <% if (newBal == null || accNo == null) { %>
            <p>Error: Account details are missing. Please try again.</p>
        <% } else { %>
            <p>The Account No: <strong><%= accNo %></strong></p>
            <p>The Updated Balance: <strong><%= newBal %></strong></p>
        <% } %>

        <div class="links">
            <p><a href="Home.jsp">Home</a></p>
            <p><a href="Logout.jsp">LogOut</a></p>
        </div>
    </div>
</body>
</html>
