<%@ include file="inc/head.jsp"%>
<%@ include file="inc/nav-menu.jsp"%>
<div class="container-fluid p-0">
	<section class="resume-section p-3 p-lg-5 d-column" id="about">
		<div class="my-auto">
			<h2 class="mb-0">Mis asignaturas</h2>
			 <div class="panel panel-info">
    <c:forEach items ="${planes_lista}" var="plan">
     <div class="title-grade"><c:out value="${plan.name}"></c:out> </div>
      <c:forEach items="${asignaturas_lista}" var="asignaturas">
      
       			<c:if test="${plan.acronimo==asignaturas.getPlanDeEstudio().acronimo }">
	               		<div class="list-group-item">
	               			<a href="#" style="display: inline-block;"><span>${asignaturas.name}</span></a>
	                        <div class="subject-options">
	                        	<c:if test="${asignaturas.coordinadorEmail == sessionScope.profesor.getEmail()}">	
									<form action="RenderizarFormularioAsignatura">	
										<input type="hidden" class="btn btn-info pull-right"
										name="asignaturaAGestionar" value="${asignaturas.asignaturaID}" >
										<button class ="btn btn-info pull-right" type="submit">Gestionar</button>
									</form>
								</c:if>
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