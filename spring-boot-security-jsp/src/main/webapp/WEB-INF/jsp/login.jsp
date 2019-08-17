

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>

<h1>Login In</h1>

<form:form action="${pageContext.request.contextPath}/authenticate"
	method="POST">

	<c:if test="${param.error!=null }">
		<i>Invalid Username/Password</i>
	</c:if>
	<c:if test="${param.logout!=null }">
		<i>Successfully logout</i>
	</c:if>

	<p>
		UserName : <input type="text" name="username">
	</p>

	<p>
		Password : <input type="password" name="password">
	</p>
	<input type="submit" value="Login">
</form:form>
</body>
</html>