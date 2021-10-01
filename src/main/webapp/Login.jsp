<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<h2>Welcome to Testing Shstra</h2>
</head>
<body>
<form action="validatelogin" method="post">
        <fieldset>
          <legend>Login to App</legend>
          <section>
          <label for="username">Username: </label>
          <input type="text" id="username" name="username" required>
        </section>
        <section>
            <label for="password">Password: </label>
            <input type="text" id="password" name="password" required>
          </section>
          <input type="submit" value="Submit">
        </fieldset>
      </form>
      
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");  // HTTP 1.1

response.setHeader("pragma", "no-cache");  // HTTP 1.0

response.setHeader("Expires", "0"); 	// proxies

%>
</body>
</html>