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
<%-- 		<form:form class="form-horizontal" role="form " action="RegisterIns" --%>
<%-- 			method="POST" commandName="user"> --%>
<!-- 			<h2>Registration</h2> -->
<!-- 			<div class="form-group"> -->
<!-- 				<label for="UserName" class="col-sm-3 control-label">UserName</label> -->
<!-- 				<div class="col-sm-9"> -->
<%-- 					<form:input type="text" name="Name" placeholder="UserName" --%>
<%-- 						class="form-control" path="username" autofocus /> --%>
<!-- 					<span class="help-block"> UserName</span> -->
<!-- 				</div> -->
<!-- 			</div> -->

<!-- 			<div class="form-group"> -->
<!-- 				<label for="email" class="col-sm-3 control-label">Email</label> -->
<!-- 				<div class="col-sm-9"> -->
<%-- 					<form:input type="email" id="email" placeholder="Email" --%>
<%-- 						class="form-control" path="email" /> --%>
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="form-group"> -->
<!-- 				<label for="password" class="col-sm-3 control-label">Password</label> -->
<!-- 				<div class="col-sm-9"> -->
<%-- 					<form:input type="password" id="password" placeholder="Password" --%>
<%-- 						path="password" class="form-control" /> --%>
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="form-group"> -->
<!-- 				<label for="country" class="col-sm-3 control-label">Country</label> -->
<!-- 				<div class="col-sm-9"> -->
<%-- 					<form:input type="text" id="country" class="form-control" --%>
<%-- 						path="country" /> --%>



<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<!-- /.form-group --> -->
<!-- 			<div class="form-group"> -->
<!-- 				<label class="control-label col-sm-3">Gender</label> -->
<!-- 				<div class="col-sm-6"> -->
<!-- 					<div class="row"> -->
<!-- 						<div class="col-sm-4"> -->
<%-- 							<label class="radio-inline"> <form:input type="radio" --%>
<%-- 									id="femaleRadio" value="Female" path="gender" />Female --%>
<!-- 							</label> -->
<!-- 						</div> -->
<!-- 						<div class="col-sm-4"> -->
<%-- 							<label class="radio-inline"> <form:input type="radio" --%>
<%-- 									id="maleRadio" value="Male" path="gender" />Male --%>
<!-- 							</label> -->
<!-- 						</div> -->
<!-- 						<div class="col-sm-4"> -->
<%-- 							<label class="radio-inline"> <form:input type="radio" --%>
<%-- 									id="TransGenderRadio" value="TransGender" path="gender" />TransGender --%>
<!-- 							</label> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="form-group"> -->
<!-- 				<div class="col-sm-9 col-sm-offset-3"> -->
<!-- 					<button type="submit" class="btn btn-primary btn-block" -->
<!-- 						name="action">Register</button> -->
<!-- 				</div> -->
<!-- 			</div> -->



			
<form:form class="form-horizontal" action='RegisterIns' method="POST"
				commandName="user">
				<fieldset>
					<div id="legend">
						<legend class="">Register</legend>
					</div>
					<div class="control-group">
						 <label class="control-label" for="username">Username</label>
						<div class="controls">
							<input type="text" id="UserInfo-username" name="username" placeholder=""
								class="input-xlarge">
							<p class="help-block">Username can contain any letters or
								numbers, without spaces</p>
						</div>
					</div>

					<div class="control-group">
						 <label class="control-label" for="email">E-mail</label>
						<div class="controls">
							<input type="text" id="UserInfo-email" name="email" placeholder=""
								class="input-xlarge">
							<p class="help-block">Please provide your E-mail</p>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="password">Password</label>
						<div class="controls">
							<input type="password" id="UserInfo-password" name="password"
								placeholder="" class="input-xlarge">
							<p class="help-block">Password should be at least 4
								characters</p>
						</div>
					</div>

					<div class="control-group">
						
						<div class="controls">
							<button class="btn btn-success" type="submit" name="action">Register</button>
						</div>
					</div>
				</fieldset>
			
		</form:form>
		 <a href="list">Click Here to see User List</a>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>