<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-uWxY/CJNBR+1zjPWmfnSnVxwRheevXITnMqoEIeG1LJrdI0GlVs/9cVSyPYXdcSF"
	crossorigin="anonymous">

</head>

<body>
	<h2 style="text-align: center;">Welcome to Testing Shastra</h2>
	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">

				<form action="validatelogin" method="post" ${loginDetails}>
					<fieldset>
						<legend>Fill the details to login</legend>
						<section class="form-group">
							<label for="username">Username</label> <input type="text"
								class="form-control" id="username" name="username"
								aria-describedby="emailHelp" value="${loginDetails.username}">
							<!-- required="required"> -->
							<div id="emailHelp" class="form-text">We'll never share
								your details with anyone else.</div>
						</section>


						<section class="form-group">
							<label for="password">Password</label> <input type="password"
								class="form-control" id="password" name="password"
								value="${loginDetails.password}">
							<!-- required="required" -->
						</section>
						<br>
						<div>
							<button type="submit" class="btn btn-primary">Submit</button>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</body>
</html>