<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Registration</title>
<style>
body {
	width: 100%;
	height: 400px;
	background-image: url("resources/images/a.jpg");
	background-size: cover;
}
</style>
</head>
<body>
	<%@ include file="header.jsp"%>

	<div class="container">
		<form:form class="form-horizontal" role="form " action="RegisterIns"
			method="POST" modelAttribute="user">
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">First
					Name</label>
				<div class="col-md-4">
					<input type="text" name="firstname"
						placeholder="Insert your First Name" class="form-control input-md"
						id="UserInfo-firstname"> <span class="help-block">
					</span>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Last
					Name</label>
				<div class="col-md-4">
					<input type="text" name="lastname"
						placeholder="Insert your Last Name" class="form-control input-md"
						id="UserInfo-lastname"> <span class="help-block">
					</span>
				</div>
			</div>
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">UserName</label>
				<div class="col-md-4">
					<input type="text" name="User Name" placeholder="insert UserName"
						class="form-control input-md" id="UserInfo-username"> <span
						class="help-block"> </span>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Email</label>
				<div class="col-md-4">
					<input type="email" name="email" placeholder="Insert your Email"
						class="form-control input-md" id="UserInfo-email"> <span
						class="help-block"> </span>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Password</label>
				<div class="col-md-4">
					<input type="password" name="password"
						placeholder="Insert your Password" class="form-control input-md"
						id="UserInfo-password"> <span class="help-block">
					</span>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Confirm
					Password</label>
				<div class="col-md-4">
					<input type="password" name="password"
						placeholder="Confirm your Password" class="form-control input-md"
						id="UserInfo-confirmpwd"> <span class="help-block">
					</span>
				</div>
			</div>

			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="singlebutton"> </label>
				<div class="col-md-4">
					<button class="btn btn-success" type="submit" name="action">Register</button>
				</div>
			</div>
		</form:form>
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>