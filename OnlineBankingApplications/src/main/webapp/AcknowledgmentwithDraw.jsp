<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Withdraw Status</title>
        <link rel="stylesheet" href="style.css"> <!-- Link to external CSS -->
    
</head>
<body>

<h2><%
    Float Balance = (Float) session.getAttribute("newBal");

    if (Balance == null || Balance == -1.0f) {
        out.println("Account not found");
    } else if (Balance == 0.0f) {
        out.println("Insufficient balance. Withdrawal failed!");
    } else if (Balance == -2.0f) {
        out.println("Minimum Account Balance needs to be 500 rupees");
    } else {
%>
</h2>
        <h2>Withdrawal Successful !!</h2>
        <p>The Account Balance: <strong><%= Balance %></strong></p>
        
<%
    }
%>

       <p> <a href = "Home.jsp">Home</a></p>
           <p><a href = "Logout.jsp">logout</a></p>
       

</body>
</html>
