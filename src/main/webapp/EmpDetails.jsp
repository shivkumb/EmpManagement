<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MyDetails</title>
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
th, td {
  background-color: #96D4D4;
}
</style>

</head>
<body>
<section>
<h2>My Details</h2>
<table style="width: auto;">
<thead align="center">
	<tr>
		<th>Employee ID</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Email ID</th>
		<th>Contact Number</th>
	</tr>
</thead>
<tbody align="left">
<tr>
<td>${employee.employeeID}</td>
<td>${employee.firstName}</td>
<td>${employee.lastName}</td>
<td>${employee.email}</td>
<td>${employee.contactNumber}</td>
</tr>
</tbody>

</table>

</section>
<section>
<nav> <a href="logout" >Logout</a></nav>
</section>

<%-- <%
if(session.getAttribute("username")==null)
{
	response.sendRedirect("Login.jsp");
}

response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");

response.setHeader("pragma", "no-cache");

response.setHeader("Expires", "0");
%> --%>

</body>
</html>