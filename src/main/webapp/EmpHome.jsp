<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Home</title>
<h1>Welcome to Employee HomePage</h1>
</head>
<header><b><mark> Welcome ${firstName}  ${lastName} </mark></b></header>
<body>

<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");

response.setHeader("pragma", "no-cache");

response.setHeader("Expires", "0");

response.setHeader("Refresh","10; URL=Login.jsp");

%>
</body>
</html>