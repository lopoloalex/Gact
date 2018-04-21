<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="CrearProfesorServlet">
	<input type="text" name="departamentoID" placeholder="DepartamentoID">
	<input type="text" name="name" placeholder="Nombre">
	<input type="text" name="email" placeholder="email">
	<button type="submit">Login</button>
</form>


<table border="1">
<tr>
<th>Departamento</th>
<th>Nombre</th>
<th>Email</th>

</tr>

<c:forEach items="${profesor_list}" var="profesori">
<tr>
<td>${profesori.departamento.nombre}</td>
<td>${profesori.name}</td>
<td>${profesori.email}</td>

</tr></c:forEach></table>




</body>
</html>