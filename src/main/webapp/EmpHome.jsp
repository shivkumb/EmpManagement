<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Home</title>
<h1>Welcome to Employee HomePage</h1> 
</head>
<header><b><mark> Welcome ${empDetails.firstName}  ${empDetails.lastName}</mark></b></header>
<nav><a href="getSelfDetails?employeeID=${empDetails.employeeID}">view my details</a></nav>
<section>
<nav> <a href="logout" >Logout</a></nav>
</section>

<body>
<%
if(session.getAttribute("username")==null)
{
	response.sendRedirect("Login.jsp");
}

response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");

response.setHeader("pragma", "no-cache");

response.setHeader("Expires", "0");
%>
</body>
</html>