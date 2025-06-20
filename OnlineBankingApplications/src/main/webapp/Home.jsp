<%@ page language="java" import="java.util.Date" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>NetBanking Dashboard</title>
    <link rel="stylesheet" href="Home.css">
</head>
<body>
    <div class="welcome-msg">
    

        <h2>Welcome to Indian Central Bank</h2>
        <%
            String username = (String)session.getAttribute("username");
            if(username != null){
        %>
            <h4>Welcome, <%= username %></h4>
        <%
            }
        %>
    </div>

    <ul class="menu">
        <li><a href="OpenAccount.jsp">Open Account</a></li>
        <li><a href="Deposit.jsp">Deposit Amount</a></li>
        <li><a href="BalEnquiry.jsp">Balance Enquiry</a></li>
        <li><a href="Withdrawl.jsp">Withdraw Amount</a></li>
        <li><a href="Delete.jsp">Close Account</a></li>
        <li><a href="Logout.jsp">Logout</a></li>
    </ul>

    <div class="date-time">
        <h4>Current Date and Time:</h4>
        <p><%= new Date() %></p>
    </div>
</body>
</html>
