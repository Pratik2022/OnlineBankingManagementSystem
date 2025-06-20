<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LogOut</title>
<%
  session.invalidate();
  RequestDispatcher rd = request.getRequestDispatcher("HomeLogin.html");
  rd.forward(request,response);
%>
<
</html>