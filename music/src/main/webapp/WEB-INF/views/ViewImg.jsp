<%@include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
		<div class="row text-center">
			
			<div class="col-xs-4 col-sm-3">
				<div class="thumbnail">
					<a href="#"><img
						src="<c:url value='resources/images/${product.image}.jpg'/>"
						alt="music" class="img-responsive"
						style="width: 4000px; height: 370px" /></a>
					<p>
					
					<h1>${product.price}</h1>
					</p>
					<p>
					<h2>${product.quantity}</h2>
					</p>

					<p>
					<h3>${product.description}</h3>
					</p>
					<sec:authorize access="hasRole('ROLE_USER')">
					<a href="addtocart?cart=${product.product_id}"><button type="button" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span>Add to Cart</button></a>

					<button type="button" class="btn btn-danger">Buy Now</button></sec:authorize>
				</div>
			</div>
			<%-- </c:forEach> --%>
		</div>
	</div>
</body>
</html>