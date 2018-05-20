<%@ include file="inc/head.jsp"%>
<%@ include file="inc/nav-menu.jsp"%>
<div class="container-fluid p-0">
	<section class="resume-section p-3 p-lg-5  d-column" id="about">
		<div class="my-auto">
			<h2 class="mb-0">Departamentos</h2>
			
		</div>

	<form action="LoginRootServlet">
		<input type="text" name="departamentoID" placeholder="DepartamentoID">
		<input type="text" name="nombre" placeholder="Nombre"> <input
			type="text" name="responsableEmail" placeholder="ResponsableEmail">
		<button type="submit">Login</button>
	</form>

	<div id="table">
		<span class="table-add glyphicon glyphicon-plus"></span>
		<table class="table">
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
					<td>
					<form action ="RenderizarEditarDepartamentoServlet" method ="get">
								<input type="hidden" name="departamento" value="${departamentoi.departamentoID}" >																	
              					<button type="submit"> Editar</button>
              		</form>
					</td>
				</tr>

			</c:forEach>
		</table>
	</div>
</section>
</div>
<%@ include file="inc/footer.jsp"%>