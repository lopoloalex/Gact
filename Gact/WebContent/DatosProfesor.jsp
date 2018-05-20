<%@ include file="inc/head.jsp"%>
<%@ include file="inc/nav-menu.jsp"%>
<div class="container-fluid p-0">
	<section class="resume-section p-3 p-lg-5  d-column" id="about">
		<div class="my-auto">
			<h2 class="mb-0"></h2>
			<p class="page-subtitle"></p>
			<c:if test="${sessionScope.vista_estadisticas}">
				<a class="btn btn-info btn-volver" href="RenderizarEstadisticasDepartamentoProfesores">Volver</a>
			</c:if>
			<div id="informacion-profesor">
				<div class="row">
					<div class="col-md-2 text-center panel">
						<img class="img-fluid img-profile mx-auto mb-2" width="100" height="100" src="images/upm.jpg" alt="">
					</div>
					<div class="col-md-4 datos panel">
						<ul class="profesor-data">
							<li><b>Nombre:</b> ${sessionScope.profesor.name}</li>
							<li><b>Email:</b> ${sessionScope.profesor.email}</li>
						</ul>
					</div>
					<div class="col-md-6 xs-hidden sm-hidden md-hidden"></div>
				</div>
			</div>
			<div id="asignaturas-profesor">
				<h3 class="asignaturas">Asignaturas</h3>
				<div class="table-responsive">
			    	<table class="table-borderless" id="docencia-profesor">
			    		<thead>
			    			<tr>
				    			<th>Asignatura</th>
				    			<th class="text-center">Acrónimo</th>
				    			<th class="text-center">Horas impartidas A</th>
				    			<th class="text-center">Horas impartidas B</th>
				    			<th class="text-center">Horas impartidas C</th>
				    		</tr>
			    		</thead>
			    		<tbody>
			    			<c:forEach items="${informacionProfe}" var="asignatura">
								<tr>
									<td>${asignatura.value[0]}</td>
							        <td class="text-center">${asignatura.value[1]}</td>
							        <td class="text-center">${asignatura.value[2]}</td>
							        <td class="text-center">${asignatura.value[3]}</td>
							        <td class="text-center">${asignatura.value[4]}</td>
								</tr>
							</c:forEach>
			    		</tbody>
			    	</table>
			    </div>
			</div>
		</div>
	</section>
</div>
<%@ include file="inc/footer.jsp"%>