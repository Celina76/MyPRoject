<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>welcome</title>
<style>
body  {
 width: 100%;
    height: 400px;
    background-image: url("resources/images/6.jpg");
   
}
</style>
</head>
<body>
<%@ include file="header.jsp" %>


	<div class="container">
  <h2>sign</h2>
  <form action="validate" method="post">
    <div class="form-group">
      <label for="username">User name:</label>
      <input type="text" class="form-control" name="username" placeholder="Enter username">
    </div>
    <div class="form-group">
      <label for="password">Password:</label>
      <input type="password" class="form-control" name="password" placeholder="Enter password">
    </div>
    <div class="checkbox">
      <label><input type="checkbox"> Remember me</label>
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  
  </form>
</div>
${successMsg}
<c:if test="${getSign }">
		<jsp:include page="sign.jsp"></jsp:include>
	</c:if>
	
	<c:if test="not empty ${errorMsg }">
<jsp:include page="sign.jsp"></jsp:include>
 
	</c:if>
	${errorMsg}
	

<%@ include file="footer.jsp" %>

		</body>
</html>