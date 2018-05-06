<%@ include file="inc/head.jsp"%>
<%@ include file="inc/nav-menu.jsp"%>
<div class="container-fluid p-0">
   <section class="resume-section p-3 p-lg-5 d-column" id="about">
      <div class="my-auto">
         <h2 class="mb-0">
            Administrar
            <button type="button" class="btn btn-info pull-right"
               id="login-button"
               onClick="window.location.href='RenderizarCrearAsignaturaServlet'">Crear nueva asignatura
            </button>
            <button type="button" class="btn btn-info pull-right"
               id="login-button"
               onClick="window.location.href='CrearPlanDeEstudio.jsp'">Crear nuevo Plan de estudio
            </button>
         </h2>
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
                        	<form action="BorrarAsignaturaServlet">					
	                           <input type="hidden" class="btn btn-info pull-right" name="asignaturaABorrar" value="${asignaturas.asignaturaID}" placeholder="Borrar">
	                               <button class ="btn btn-info pull-right"> Borrar</button>
	                           </form>
	                           <form action="RenderizarEditarAsignaturaServlet">
	                            <input type="hidden" class="btn btn-info pull-right"
	                              name="asignaturaAEditar" value="${asignaturas.asignaturaID}" placeholder="Editar">
	                           <button class ="btn btn-info pull-right" type="submit"> Editar								
	                          
	                           </button>
	                        </form>
                        </div>
               		</div>
               </c:forEach>
         </div>
      </div>
      <div class="panel panel-info">
            <div class="title-grade"> Master en ingenieria de
            telecomunicacion</div>
            <div class="list-group-item">
                  <label>No existen asignaturas de máster</label>
            </div>
      </div>
   </section>
</div>
<%@ include file="inc/footer.jsp"%>