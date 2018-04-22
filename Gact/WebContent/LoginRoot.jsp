<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="LoginRootServlet">
		<input type="text" name="departamentoID" placeholder="DepartamentoID">
		<input type="text" name="nombre" placeholder="Nombre"> <input
			type="text" name="responsableEmail" placeholder="ResponsableEmail">
		<button type="submit">Login</button>
	</form>


	<table border="1">
		<tr>
			<th>DepartamentoID</th>
			<th>Nombre</th>
			<th>CoordinadorEmail</th>

		</tr>

		<c:forEach items="${departamento_list}" var="departamentoi">
			<tr>
				<td>${departamentoi.departamentoID}</td>
				<td>${departamentoi.nombre}</td>
				<td>${departamentoi.responsableEmail}</td>

			</tr>
		</c:forEach>
	</table>




</body>
</html>