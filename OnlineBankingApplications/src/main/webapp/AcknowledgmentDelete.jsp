<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Account</title>
    <link rel="stylesheet" href="style.css"> <!-- Link to external CSS -->
</head>
<body>
 
   <h2> <%
    Float Balance = (Float) session.getAttribute("accBal");

    if (Balance == null || Balance == -1.0f) {
        out.println("Account Not Avaialble");
    } else if (Balance == 0.0f) {
        out.println("Insufficient balance. Withdrawal failed!");
    }else {
    %>
    </h2>
        <h2>Account Deleted successfully!!!</h2>
        <p>Please withdraw  Remaining Account Balance:  <strong><%= Balance %></strong></p>
    <% 
    }
    %>
    </p>
        <p> <a href = "Home.jsp">Home</a></p>
            <p><a href = "Logout.jsp">logout</a></p>
        
    

</body>
</html>
