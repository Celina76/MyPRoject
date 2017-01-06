<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>User List Info</title>
</head>
<body>
<c:if test="{!empty List}"/>
<table>
 <tr>
     
     <td>UserName</td>
     <td>email</td>
     <td>password</td>
     <td>Edit</td>
     <td>Delete</td>
    
</tr>
 <c:forEach items="${List}" var="user">
 <tr>
      
      <td><c:out value="${user.username}" />
      </td>
      <td><c:out value="${user.email}" />
      </td>
      <td><c:out value="${user.password}" />
      </td>
      
      <td><a href="edit?id=${user.userid}">Edit</a></td>
      <td><a href="delete?id=${user.userid}">Delete</a></td>
  </tr>  
    </c:forEach>











</table>











</body>
</html>