<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
	
	</head>
 
	<body>
		<div class="content">
			<fieldset>
				<legend>Confirm Details</legend>
				<!-- for triggering webflow events using links,
					 the eventId to be triggered is given in "href" attribute as:
				 -->
				<a href="${flowExecutionUrl}&_eventId_home">Home</a><br /><br />
				<form:form modelAttribute="user">
					<form:label path="firstname">FirstName:</form:label>${user.firstname}
					<br /><br />
					<form:label path="lastname">LastName:</form:label>${user.lastname}
					<br /><br />
					<form:label path="username">UserName:</form:label>${user.username}
					<br /><br />
					<form:label path="email">Email Id:</form:label>${user.email}
					<br /><br />
					<form:label path="password">Password:</form:label>${user.password}
					<br /><br />
					<form:label path="confirmfwd">confirmpassword:</form:label>${user.confirmpwd}
					<br /><br />
					<!-- for triggering webflow events using form submission,
					 the eventId to be triggered is given in "name" attribute as:
					-->
					<input name="_eventId_edit" type="submit" value="Edit" /> 
					<input name="_eventId_submit" type="submit" value="Confirm Details" /><br />
				</form:form>
			</fieldset>
		</div>
	</body>
</html>