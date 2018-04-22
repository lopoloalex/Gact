<%@ include file = "inc/head.jsp" %>
<%@ include file = "inc/nav-menu.jsp" %>
<div class="container-fluid p-0">
	<section class="resume-section p-3 p-lg-5  d-column" id="about">
	   <div class="my-auto">
		   <h2 class="mb-0">Formulario de asignatura  "${asignatura.name}"
		   </h2>
 				<form action="RenderizarAddProfesorServlet">	
                      							
                       <input type="hidden" class="btn btn-info pull-right"
                         name="asignatura" value=${asignatura.asignaturaID} >
                       <button type="submit" class ="btn btn-info pull-right"> Añadir Profesor	 </button>
                 </form>
		 
		   <div id="table" class="table-editable">
			   <span class="table-add glyphicon glyphicon-plus"></span>
			   <table class="table">
			      <tr>
			         <th>Profesor</th>
			         <th>Horas(A)</th>
			         <th>Horas(B)</th>
			         <th>Horas(C)</th>
			      </tr>
			      


				 <c:forEach items="${docencia_list}" var="docenciai">
					<tr>
						<td>${docenciai.docencia.email}</td>
						<td>${docenciai.getHorasA()}</td>
						<td>${docenciai.horasB}</td>
						<td>${docenciai.horasC}</td>								
					</tr>
				 </c:forEach>
			   </table>
		  
			        
			
		   </div>
		</div>
	</section>
</div>
<%@ include file = "inc/footer.jsp" %>