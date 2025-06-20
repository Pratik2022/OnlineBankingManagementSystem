<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Balance Enquiry</title>
    <link rel="stylesheet" href="style.css"> <!-- Link to external CSS -->
</head>
<body>

    <%
        Integer accNo = (Integer)session.getAttribute("accNo");
        String accType = (String)session.getAttribute("accType");
        Float accBal = (Float) session.getAttribute("accBal");
    
    %>
        <p>The Account No: <strong><%= accNo %></strong></p>
        <p>The Account Type: <strong><%= accType %></strong></p>
    
        <p>The Account Current Balance: <strong><%= accBal %></strong></p>
        
        <p><a href = "Home.jsp">Home</a></p>
        <p><a href = "Logout.jsp">logout</a></p>
        

</body>
</html>
