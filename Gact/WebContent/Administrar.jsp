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

         </h2>
  	<div class="panel panel-info">
         
    <c:forEach items ="${planes_lista}" var="plan">
                   <div class="title-grade"><c:out value="${plan.name}"></c:out> </div>
       <c:forEach items="${asignaturas_lista}" var="asignaturas">
       			<c:if test="${plan.acronimo==asignaturas.getPlanDeEstudio().acronimo }">
               		<div class="list-group-item">
               			<a href="#" style="display: inline-block;"><span>${asignaturas.name}</span></a>
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
               	</c:if>
    </c:forEach>
   </c:forEach>
   </div>
   </div>
   </section>
</div>
<%@ include file="inc/footer.jsp"%>