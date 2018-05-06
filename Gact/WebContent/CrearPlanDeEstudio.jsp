<%@ include file="inc/head.jsp"%>
<%@ include file="inc/nav-menu.jsp"%>
<div class="container-fluid p-0">
	<section class="resume-section p-3 p-lg-5  d-column" id="about">
		<div class="my-auto">
			<h2 class="mb-0">Crear nuevo Plan de estudio </h2>

		</div>

		<form action="CrearPlanDeEstudioServlet">
			<input type="text" name="acronimo" placeholder="Acronimo"> 
			<input type="text" name="name" placeholder="Nombre completo"> 
			<button type="submit">Crear</button>
		</form>

		<div id="table">
			<span class="table-add glyphicon glyphicon-plus"></span>
			<table class="table">

				<tr>
					<th>Acronimo</th>
					<th>Nombre</th>

				</tr>

				<c:forEach items="${plan_lista}" var="plani">
					<tr>
						<td>${plani.acronimo}</td>
						<td>${plani.getName()}</td>
						<td>
						       <form action="BorrarPlanDeEstudiosServlet">					
	                           <input type="hidden" class="btn btn-info pull-right" name="planABorrar" value="${plani.acronimo}" placeholder="Borrar">
	                               <button class ="btn btn-info pull-right"> Borrar</button>
	                           </form> </td>
					</tr>
				</c:forEach>
			</table>



		</div>
	</section>
</div>

<%@ include file="inc/footer.jsp"%>