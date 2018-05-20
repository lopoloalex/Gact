<%@ include file="inc/head.jsp"%>
<%@ include file="inc/nav-menu.jsp"%>
<div class="container-fluid p-0">
   <section class="resume-section p-3 p-lg-5 d-column" id="about">
      <div class="my-auto">
         <h2 class="mb-0">
            Administrar Secretaría
            <button type="button" class="btn btn-info pull-right"
               id="login-button"
               onClick="window.location.href='JsonClassForUPM'">Importar asignaturas
            </button>
        </h2>
  	<div class="panel panel-info">
         <h3>Asignaturas a las que falta editar campos</h3>
         <c:forEach items="${asignaturas_lista}" var="asignaturas">
         
                <c:if test="${empty asignaturas.getDepartamento()}">
               		<div class="list-group-item">
               			<a href="#" style="display: inline-block;"><label for="checkbox" >${asignaturas.name}</label></a>
                        <div class="subject-options">
                        	<form action="BorrarAsignaturaServlet">					
	                           <input type="hidden" class="btn btn-info pull-right" name="asignaturaABorrar" value="${asignaturas.asignaturaID}" placeholder="Borrar">
	                               <button class ="btn btn-info pull-right"> Borrar</button>
	                           </form>
	                           <form action="RenderizarRootEditarAsignaturaServlet">
	                            <input type="hidden" class="btn btn-info pull-right"
	                              name="asignaturaAEditar" value="${asignaturas.asignaturaID}" placeholder="Editar">
	                           <button class ="btn btn-info pull-right" type="submit"> Editar								
	                          
	                           </button>
	                        </form>
                        </div>
               		</div>
               	</c:if>
   </c:forEach>          
            <h3>Asignaturas ya editadas</h3>
       
       <c:forEach items="${asignaturas_lista}" var="asignaturas">
       	  <c:if test="${not empty asignaturas.getDepartamento()}">
       	
               		<div class="list-group-item">
               			<a href="#" style="display: inline-block;"><label for="checkbox">${asignaturas.name}</label></a>
                        <div class="subject-options">
                        	<form action="BorrarAsignaturaServlet">					
	                           <input type="hidden" class="btn btn-info pull-right" name="asignaturaABorrar" value="${asignaturas.asignaturaID}" placeholder="Borrar">
	                               <button class ="btn btn-info pull-right"> Borrar</button>
	                           </form>
	                           <form action="RenderizarRootEditarAsignaturaServlet">
	                            <input type="hidden" class="btn btn-info pull-right"
	                              name="asignaturaAEditar" value="${asignaturas.asignaturaID}" placeholder="Editar">
	                           <button class ="btn btn-info pull-right" type="submit"> Editar								
	                          
	                           </button>
	                        </form>
                        </div>
               		</div>
               </c:if>
   </c:forEach>
   </div>
   </div>
   </section>
</div>
<%@ include file="inc/footer.jsp"%>