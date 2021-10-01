<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AdminHome</title>
</head>
<body>
<header><b><mark> Welcome ${firstName}  ${lastName} </mark></b></header>
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");

response.setHeader("pragma", "no-cache");

response.setHeader("Expires", "0");

response.setHeader("Refresh","10; URL=Login.jsp");

%>
</body>
</html>