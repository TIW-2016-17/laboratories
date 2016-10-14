<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login.jsp</title>
<style>
	.error { color:red;}
</style>
</head>
<body>
	<c:if test="${!empty errors }">
		<c:forEach items="${errors}" var="error">

			<c:if test="${error.key =='name'}">
				<p class="error">Name cannot be empty</p>

			</c:if>
			<c:if test="${error.key =='key'}">
				<p class="error">key cannot be empty</p>

			</c:if>
		</c:forEach>
	</c:if>
	<h1>JSP Form</h1>
	<form action='loginServlet' method='post'>
		<input type='text' name='name' placeholder='user'> <br> <input
			type='password' name='key' placeholder='password'> <br>
		<input type='submit' value='Send'>
	</form>
</body>
</html>