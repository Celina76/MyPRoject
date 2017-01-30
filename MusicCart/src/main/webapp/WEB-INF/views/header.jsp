<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<div class="page-header">

			<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">MusicWorld</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="index">Home</a></li>
					<li><a href="display">products</a>
				</ul>
				<!-- 				<div class="col-sm-5"> -->
				<!-- 			<input type="search" class="form-control" name="search" -->
				<!-- 				placeholder="Search for Product"> -->

				<!-- 		</div> -->
				<ul class="nav navbar-nav navbar-right">
					<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
						<c:if test="${pageContext.request.userPrincipal.name!=null }">
							<li><h4>welcome
									${pageContext.request.userPrincipal.name }</h4></li>
						</c:if>
					</sec:authorize>
					<c:if test="${pageContext.request.userPrincipal.name==null }">
						<li><a href="login"><span
								class="glyphicon glyphicon-user"></span>Login</a></li>
					</c:if>
					<c:if test="${pageContext.request.userPrincipal.name==null }">
						<li><a href="register"><span
								class="glyphicon glyphicon-log-in"></span>Register</a></li>
					</c:if>
					<li><a href="<c:url value="cart"/>">cart</a></li>
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<li><a href="product">Add Product</a></li>
					</sec:authorize>
					<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
						<li><a href="logout"><span
								class="glyphicon glyphicon-log-out"></span>logout</a></li>
					</sec:authorize>
				</ul>
			</div>
			</nav>
		</div>
	</div>
	<script></script>
</body>
</html>