<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Product Info</title>
</head>
<body>
	

<div class="container">
<div style="color: teal; font-size: 30px">Product Details</div>

  <c:if test="${!empty list}">
   <table class="table table-bordered" >
   <thead>
    <tr>
     
          <td>Product_name</td>
     <td>description</td>
     <td>Supplier_name</td>
     <td>Category_name</td>
     
    </tr>
    </thead>
    
    <c:forEach items="${list}" var="prod">
     <tr>
      
      
     
      <td><c:out value="${prod.product_name}" />
      </td>
      <td><c:out value="${prod.description}" />
      </td>
      <td><c:out value="${prod.supplier_name}" />
      </td>
      <td><c:out value="${prod.supplier_name}" />
      </td>
      <td><a href="edit?product_id=${prod.product_id}">Edit</a></td>
      <td><a href="delete?product_id=${prod.product_id}">Delete</a></td>
     </tr>
    </c:forEach>
   </table>
  </c:if>







</div>

	




</body>
</html>