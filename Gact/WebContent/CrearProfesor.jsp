<%@ include file="inc/head.jsp"%>
<%@ include file="inc/nav-menu.jsp"%>
<div class="container-fluid p-0">
	<section class="resume-section p-3 p-lg-5  d-column" id="about">
		<div class="my-auto">
			<h2 class="mb-0">Crear nuevo profesor</h2>

		</div>

		<form action="CrearProfesorServlet">
			<select name="departamentoID">
	           	<c:forEach items="${departamento_list}" var="departamento">
	             	 <option value="${departamento.departamentoID}">${departamento.nombre}</option>
	         	</c:forEach>
	        </select>
			<input type="text" name="name" placeholder="Nombre"> <input
				type="text" name="email" placeholder="Email"> <input
				type="password" name="password" placeholder="Password">

			<button type="submit">Login</button>
		</form>

		<div id="table">
			<span class="table-add glyphicon glyphicon-plus"></span>
			<table class="table">

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

					</tr>
				</c:forEach>
			</table>



		</div>
	</section>
</div>

<%@ include file="inc/footer.jsp"%>