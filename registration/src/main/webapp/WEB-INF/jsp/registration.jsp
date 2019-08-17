<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>



<html>
<head>
<style>
span.error {
   color: red;
}
</style>
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath}/user" modelAttribute="user" method="POST">  
        First name: <form:input path="firstName" />
		<br> 
		<form:errors path="*" cssClass="error" />
		<br>  
        Last name: <form:input path="lastName" />
		<br>
		<br>
		 Email : <form:input path="email" />
		<br>
		<br>  
        Password : <form:input path="password" />
		<br>
		<br>
		 Confirm password: <form:input path="confirmPassword" />
		<br>
		<br>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>