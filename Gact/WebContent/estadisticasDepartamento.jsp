<%@ include file="inc/head.jsp"%>
<%@ include file="inc/nav-menu.jsp"%>
<div class="container-fluid p-0">
	<section class="resume-section p-3 p-lg-5  d-column" id="about">
		<div class="my-auto">
			<h2 class="mb-0">${departamento}</h2>
			<p class="page-subtitle">Estadísticas del departamento</p>
			
			<div class="stats-control">
				<div class="stats-types">
					 <ul class="stats-types-list">
						 <li class="stats-type">
					     	<a  class="stats-type-element" href="RenderizarEstadisticasDepartamento">Asignaturas</a>
					     </li>
					      <li class="stats-type">
					     	<a  class="stats-type-element" href="RenderizarEstadisticasDepartamentoProfesores">Profesores</a>
					     </li>
					 </ul>
				</div>
			</div>
		    <c:choose>
		        <c:when test='${vista == "Profesores"}'>
					<div class="table-responsive">
						<table class="table table-striped" id="tabla-profesores">
							<thead>
						      <tr>
						        <th>Nombre</th>
						        <th>Email</th>
						        <th></th>
						      </tr>
						    </thead>
						    <tbody>
					    	<c:forEach items="${profesores_lista}" var="profesor">
								<tr>
									<td>${profesor.name}</td>
							        <td>${profesor.email}</td>
							        <td>
							        	<form action="RenderizarDatosProfesor">	
											<input type="hidden" class="btn btn-info pull-right" name="profesorEmail" value="${profesor.email}" >
											<button class ="btn btn-info pull-right" type="submit">Ver perfil</button>
										</form>
							        </td>
								</tr>
							</c:forEach>
						    </tbody>
						</table>
					</div>
				</c:when>
		        <c:when test='${vista == "Asignaturas"}'>
		        	<div class="table-responsive">
						<table class="table table-striped" id="tabla-asignaturas">
							<thead>
						      <tr>
						        <th>ID</th>
						        <th>Acrónimo</th>
						        <th width="25%">Nombre</th>
						        <th>Plan de estudios</th>
						        <th>Créditos</th>
						        <th>Horas totales A</th>
						        <th>Horas totales B</th>
						        <th>Horas totales C</th>
						        <th></th>
						      </tr>
						    </thead>
						    <tbody>
					    	<c:forEach items="${asignaturas_lista}" var="asignatura">
								<tr>
									<td>${asignatura.asignaturaID}</td>
							        <td>${asignatura.acronimo}</td>
							        <td>${asignatura.name}</td>
							        <td>${asignatura.planDeEstudio.acronimo}</td>
							        <td>${asignatura.creditos}</td>
							        <td>${asignatura.horasTotalesA}</td>
							        <td>${asignatura.horasTotalesB}</td>
							        <td>${asignatura.horasTotalesC}</td>
							        <td>
							        	<form action="RenderizarFormularioAsignatura">	
											<input type="hidden" class="btn btn-info pull-right" name="asignaturaAGestionar" value="${asignatura.asignaturaID}" >
											<button class ="btn btn-info pull-right" type="submit">Ver más</button>
										</form>
							        </td>
								</tr>
							</c:forEach>
						    </tbody>
						</table>
					</div>
		        </c:when>
		        <c:otherwise></c:otherwise>
		    </c:choose>
		</div>
	</section>
</div>
<%@ include file="inc/footer.jsp"%>