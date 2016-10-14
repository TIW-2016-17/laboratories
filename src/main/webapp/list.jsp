<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>list.jsp</title>
<style type="text/css">
.error{color:red;}
</style>
</head>
<body>
	<h1>
		Hi
		${sessionScope.user.name}
	</h1>
	<p>
		Your key is
		${user.password}
	</p>
	<c:if test="${empty user.password}">
	<p class="error">If you see the user name but not the password is because the name is stored in the session whereas the password is in the request.</p>
	</c:if>
	<h3>user list</h3>
	<c:if test="${empty users }"> <!-- usuarios es un atributo metido en el request por eso no es necesario ponerle el prefijo param -->
<p class="error">If you cannot see users is because you have accesed directly in the page and therefore you have not passed through the controler servlet and there are not data in the request object
</p>
</c:if>
	<table>
		<tr>
			<th>Name</th>
		</tr>
	
	<c:forEach items="${users }" var="user">
	
		<tr>
		<td>${user.name }</td> <!-- Usuario es un POJO por lo que podemos acceder a sus propiedades sin necesidad de get/set -->
		<td>${user.lastName }</td>
		</tr>
   
   </c:forEach>



	</table>
<p><a href="login.jsp">Back</a></p>

</body>
</html>