<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<title>Add Products</title>
</head>
<body>
<div class="container">
<form:form class="form-horizontal" action="productadd"
			method="POST" modelAttribute="ProductInfo">

<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Product Name</label>
				<div class="col-md-4">
					<input type="text" name="Product Name"
						placeholder="Insert Product Name" class="form-control input-md"
						id="product_name"> <span class="help-block">
					</span>
				</div>
			</div>
<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">description</label>
				<div class="col-md-4">
					<input type="text" name="description"
						placeholder="description details" class="form-control input-md"
						id="description"> <span class="help-block">
					</span>
				</div>
			</div>
<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Supplier name</label>
				<div class="col-md-4">
					<input type="text" name="supplier name"
						placeholder="Supplier name" class="form-control input-md"
						id="supplier_name"> <span class="help-block">
					</span>
				</div>
			</div>

<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">category Name</label>
				<div class="col-md-4">
					<input type="text" name="category_name"
						placeholder="category name" class="form-control input-md"
						id="category_name"> <span class="help-block">
					</span>
				</div>
			</div>


<div class="form-group">
				<label class="col-md-4 control-label" for="singlebutton"> </label>
				<div class="col-md-4">
					<button class="btn btn-success" type="submit">Add Product</button>
				</div>
			</div>
			
</form:form>
</div>
<a href ="list">click here to see the list</a>
<%@ include file="footer.jsp" %>
</body>
</html>