<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>welcome</title>
  </head> 
 

 <style>
 body
 {
 width: 100%;
	height: 400px;
	background-image: url("resources/images/6.jpg");
/* 	background-size: cover; */
	}
	

  
  </style>
</head>
<body >
 <%@ include file="header.jsp" %> 

<div class="container">
<form:form action="sign">
<div class="form-group">
<label for="email">Email:</label>
<input type="email" class="form-control" name="email" placeholder="Enter Email">

</div>

<div class="form-group">
<label for="password">PassWord:</label>
<input type="password" class="form-control" name="password" placeholder="Enter Password">

</div>

<div class="checkbox">
<label><input type="checkbox">Remeber Me</label>

</div>
<button type="submit" class="btn btn-default">Submit</button>


</form:form>
</div>


















<%@ include file="footer.jsp" %>

		</body>
</html>