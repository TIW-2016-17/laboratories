<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login.jsp</title>
</head>
<body>
	<h1>JSP Form</h1>
	<form action='loginServlet' method='post'>
	<input type='text' name='name' placeholder='user'>
	<br>
	<input type='password' name='key' placeholder='password'> 
	<br>
	<input type='submit' value='Send'>
	</form>
</body>
</html>