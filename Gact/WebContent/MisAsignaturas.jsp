<%@ include file="inc/head.jsp"%>
<%@ include file="inc/nav-menu.jsp"%>
<div class="container-fluid p-0">
	<section class="resume-section p-3 p-lg-5 d-column" id="about">
		<div class="my-auto">
			<h2 class="mb-0">Mis asignaturas</h2>
			<div class="panel panel-info">
			<a class="list-group-item active">Grado en ingeniería de
						servicios y sistemas de Telecomunicación </a>
				<ul class="list-group">
					<c:forEach items="${asignaturas_lista}" var="asignaturas">

						<a href="#" class="list-group-item">
									<label for="checkbox" name="nombre">${asignaturas.name}</label>
									
									<c:if test="${asignaturas.coordinadorEmail == sessionScope.profesor.getEmail()}">
									
									<form action="RenderizarFormularioAsignatura">	
										<input type="hidden" class="btn btn-info pull-right"
										name="asignaturaAGestionar" value="${asignaturas.asignaturaID}" >
										<button class ="btn btn-info pull-right" type="submit"> Gestionar</button>
									</form>
									</c:if>
						</a>
					</c:forEach>
				

				</ul>
			</div>
		</div>
		
		<div class="panel panel-info">
			<ul class="list-group">
				<a class="list-group-item active"> Master en ingenieria de
					telecomunicacion</a>
				<a href="#" class="list-group-item">
					<div>
						<label for="checkbox" onClick="window.location.href='index.jsp'">Redes
							de Comunicaciones</label>
					</div>
				</a>
				<a href="#" class="list-group-item">
					<div>
						<label for="checkbox" onClick="window.location.href='index.jsp'">Aplicaciones
							y servicios</label>
					</div>
				</a>
			</ul>
		</div>
</section>
</div>
<%@ include file="inc/footer.jsp"%>