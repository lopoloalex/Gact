<%@ include file="inc/head.jsp"%>
<%@ include file="inc/nav-menu.jsp"%>
<div class="container-fluid p-0">
	<section class="resume-section p-3 p-lg-5 d-column" id="about">
		<div class="my-auto">
			<h2 class="mb-0">Mis asignaturas</h2>
			 <div class="panel panel-info">
	               <div class="title-grade">Grado en ingeniería de
	               servicios y sistemas de Telecomunicación </div>
	               <c:if test="${ asignaturas_lista.isEmpty()}">
				       <div class="list-group-item">
			                  <label>No existen asignaturas de Grado</label>
			           </div>
			      </c:if>
	               <c:forEach items="${asignaturas_lista}" var="asignaturas">
	               		<div class="list-group-item">
	               			<a href="#" style="display: inline-block;"><label for="checkbox" name="nombre">${asignaturas.name}</label></a>
	                        <div class="subject-options">
	                        	<c:if test="${asignaturas.coordinadorEmail == sessionScope.profesor.getEmail()}">	
									<form action="RenderizarFormularioAsignatura">	
										<input type="hidden" class="btn btn-info pull-right"
										name="asignaturaAGestionar" value="${asignaturas.asignaturaID}" >
										<button class ="btn btn-info pull-right" type="submit"> Gestionar</button>
									</form>
								</c:if>
	                        </div>
	               		</div>
	               </c:forEach>
	         </div>
	      </div>
	      <div class="panel panel-info">
	            <div class="title-grade"> Master en ingenieria de telecomunicacion</div>
	            <div class="list-group-item">
	                  <label>No existen asignaturas de máster</label>
	            </div>
	      </div>
	</section>
</div>
<%@ include file="inc/footer.jsp"%>