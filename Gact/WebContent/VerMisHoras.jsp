<%@ include file="inc/head.jsp"%>
<%@ include file="inc/nav-menu.jsp"%>

<div class="container-fluid p-0">
	<section class="resume-section p-3 p-lg-5  d-column" id="about">
	   <div class="my-auto">
		   <h2 class="mb-0"> Horas de "${profesor.name}" en la asignatura "${asignatura.name}"
		   </h2>

		 
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
			      


					<tr>
						<td>${docencia.getProfesorID().getName()}</td>
						<td>${docencia.getHorasA()}</td>
						<td>${docencia.getHorasB()}</td>
						<td>${docencia.getHorasC()}</td>
						<td>  <form action ="ReclamarServlet" method ="post">
								<input type="hidden" name="profesor" value="${profesor.email}" >
								<input type="hidden" name="coordinador" value="${coordinador}" >
								<input type="hidden" name="asignaturaP" value="${asignatura.name}" >																	
              					<button type="submit"> Reclamar</button>
              				  </form>
              			</td>
				</table>
							 
		   </div>
		</div>
	</section>
</div>


<%@ include file="inc/footer.jsp"%>