<%@ include file = "inc/head.jsp" %>
<%@ include file = "inc/nav-menu.jsp" %>
<div class="container-fluid p-0">
	<section class="resume-section p-3 p-lg-5  d-column" id="about">
	   <div class="my-auto">
		   <h2 class="page-title">${asignatura.name}</h2>
			<div class="buttons">
				<c:if test="${sessionScope.vista_estadisticas}">
					<a class="btn btn-info btn-volver" href="RenderizarEstadisticasDepartamento">Volver</a>
				</c:if>
				<c:if test="${sessionScope.isCoordinador && asignatura.coordinadorEmail == sessionScope.profesor.email}">
					<form id="btn-addProfe" action="RenderizarAddProfesorServlet">								
						<input type="hidden" class="btn btn-info pull-right" name="asignatura" value="${asignatura.asignaturaID}">
						<button type="submit" class ="btn btn-info pull-right"> Añadir Profesor	 </button>
					</form>
				</c:if>
			</div>
			<div class="diagram-container">
				<div class="row">
				</div>
			</div>
		   <div id="table" class="table-editable">
			   <span class="table-add glyphicon glyphicon-plus"></span>
			   <table class="table">
			      <tr>
			         <th>Profesor</th>
			         <th>Horas(A)</th>
			         <th>Horas(B)</th>
			         <th>Horas(C)</th>
			         <th></th>
			      </tr>
				 <c:forEach items="${docencia_list}" var="docenciai">
					<tr>
						<td>${docenciai.getProfesorID().getName()}</td>
						<td>${docenciai.getHorasA()}</td>
						<td>${docenciai.getHorasB()}</td>
						<td>${docenciai.getHorasC()}</td>
						<td>
						<c:if test="${sessionScope.isCoordinador && asignatura.coordinadorEmail == sessionScope.profesor.email}">
							<form action="RenderizarEditarHorariosProfServlet">
								<input type="hidden" name="docenciaID" value="${docenciai.getDocencia()}" >
								<input type="submit" class="btn btn-success" value="Editar">
							</form>
						</c:if>
						</td>
					</tr>
				 </c:forEach>
				  <tr>
			         <th>Totales</th>
			         <th>${horasA} / ${asignatura.getHorasTotalesA()}</th>
			         <th>${horasB} / ${asignatura.getHorasTotalesB()}</th>
			         <th>${horasC} / ${asignatura.getHorasTotalesB()}</th>
			         <th></th>
			      </tr>
			   </table>
		   </div>
		</div>
	</section>
</div>
<%@ include file = "inc/footer.jsp" %>