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
<body onload='document.loginForm.username.focus();'>
 <%@ include file="header.jsp" %> 
<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
<div class="container">
<form:form action="sign" modelAttribute="UserInfo">
<div class="form-group">
<label for="jusername">UserName:</label>
<input type="text" class="form-control" name="jusername" placeholder="Enter username">

</div>

<div class="form-group">
<label for="jpassword">PassWord:</label>
<input type="password" class="form-control" name="jpassword" placeholder="Enter Password">

</div>

<div class="checkbox">
<label><input type="checkbox">Remeber Me</label>

</div>
<button type="submit" class="btn btn-default">Submit</button>

 <input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />

</form:form>
</div>


















<%@ include file="footer.jsp" %>

		</body>
</html>