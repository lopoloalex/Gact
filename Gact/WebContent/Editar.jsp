<%@ include file = "inc/head.jsp" %>
<%@ include file = "inc/nav-menu.jsp" %>
<div class="container-fluid p-0">
	<section class="resume-section p-3 p-lg-5  d-column" id="about">
	   <div class="my-auto">
		   <h2 class="mb-0">Editar Asignatura
		   </h2>
		   <form class="form-horizontal" role="form">
		      <div class="form-group">
		         <label  class="col-lg-2 control-label">Grado</label>
		         <div class="col-lg-10">
		            <select class="form-control">
		               <option>Grado en Ingenier�a de Tecnilogias y Servicios de la Telecomunicaci�n</option>
		               <option>M�ster en ingenier�a de Telecomunicaciones</option>
		            </select>
		         </div>
		      </div>
		      <div class="form-group">
		         <label  class="col-lg-2 control-label">Nombre de asignatura</label>
		         <div class="col-lg-10">
		            <input type="text" class="form-control" placeholder="Nombre de asignatura">
		         </div>
		      </div>
		      <div class="form-group">
		         <label  class="col-lg-2 control-label">C�digo</label>
		         <div class="col-lg-10">
		            <input type="text" class="form-control" placeholder="C�digo">
		         </div>
		      </div>
		      <div class="form-group">
		         <label  class="col-lg-2 control-label">Acr�nimo</label>
		         <div class="col-lg-10">
		            <input type="text" class="form-control"  placeholder="Acr�nimo">
		         </div>
		      </div>
		      <div class="form-group">
		         <label  class="col-lg-2 control-label">Grupos de Teor�a</label>
		         <div class="col-lg-10">
		            <input type="text" class="form-control"  placeholder="N�mero de grupos de teor�a">
		         </div>
		      </div>
		      <div class="form-group">
		         <label  class="col-lg-2 control-label">Curso</label>
		         <div class="col-lg-10">
		            <input type="text" class="form-control" placeholder="Curso">
		         </div>
		      </div>
		      <div class="form-group">
		         <label  class="col-lg-2 control-label">Semestre</label>
		         <div class="col-lg-10">
		            <input type="text" class="form-control" placeholder="Semestre">
		         </div>
		      </div>
		      <div class="form-group">
		         <label  class="col-lg-2 control-label">Cr�tidos ECTS</label>
		         <div class="col-lg-10">
		            <input type="text" class="form-control" placeholder="N�mero de cr�ditos ECTS">
		         </div>
		      </div>
		      <div class="form-group">
		         <label  class="col-lg-2 control-label">Coordinador</label>
		         <div class="col-lg-10">
		            <input type="text" class="form-control" placeholder="Nombre del coordinador">
		         </div>
		      </div>
		   </form>
		   <button type="button" class="btn btn-success col-lg-2" onClick="window.location.href='Administrar.jsp'">Guardar</button>
		</div>
	</section>
</div>
<%@ include file = "inc/footer.jsp" %>