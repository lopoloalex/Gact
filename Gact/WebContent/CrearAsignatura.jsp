<%@ include file="inc/head.jsp"%>
<%@ include file="inc/nav-menu.jsp"%>
<div class="container-fluid p-0">
<section class="resume-section p-3 p-lg-5  d-column" id="about">
   <div class="my-auto">
   <h2 class="mb-0">Crear asignatura
   </h2>
   <form class="form-horizontal" role="form" action="CrearAsignaturaServlet">
      <div class="form-group">
         <label  class="col-md-4 control-label">Plan de estudio</label>
         <div class="col-md-8">
	      	 <select class="form-control" name="Titulacion">
	           	<c:forEach items="${planes_lista}" var="plan">
	             	 <option value="${plan.acronimo}">${plan.name}</option>
	         	</c:forEach>
	         </select>
         </div>
      </div>
      <div class="form-group">
         <label  class="col-md-4 control-label">Nombre de asignatura</label>
         <div class="col-md-8">
            <input type="text" name="Name" class="form-control" placeholder="Nombre de asignatura">
         </div>
      </div>
      <div class="form-group">
         <label  class="col-md-4 control-label">Departamento: ${departamento.nombre}</label>
         <div class="col-md-8">
            <input type="hidden" name="DepartamentoID" class="form-control" value="${departamento.departamentoID}">
         </div>
      </div>
      <div class="form-group">
         <label  class="col-md-4 control-label">C�digo</label>
         <div class="col-md-8">
            <input type="text" name="Codigo" class="form-control" placeholder="C�digo">
         </div>
      </div>
      <div class="form-group">
         <label  class="col-md-4 control-label">Acr�nimo</label>
         <div class="col-md-8">
            <input type="text" name="Acronimo" class="form-control"  placeholder="Acr�nimo">
         </div>
      </div>
      <div class="form-group">
         <label  class="col-md-4 control-label">Grupos de Teor�a</label>
         <div class="col-md-8">
            <input type="text" name="Ngrupos" class="form-control"  placeholder="N�mero de grupos de teor�a">
         </div>
      </div>
      <div class="form-group">
         <label  class="col-md-4 control-label">Curso</label>
         <div class="col-md-8">
            <input type="text" name="Curso" class="form-control" placeholder="Curso">
         </div>
      </div>
      <div class="form-group">
         <label  class="col-md-4 control-label">Semestre</label>
         <div class="col-md-8">
            <input type="text" name="Semestre" class="form-control" placeholder="Semestre">
         </div>
      </div>
      <div class="form-group">
         <label  class="col-md-4 control-label">Cr�ditos ECTS</label>
         <div class="col-md-8">
            <input type="text" name="Creditos" class="form-control" placeholder="N�mero de cr�ditos ECTS">
         </div>
      </div>
      <div class="form-group">
         <label  class="col-md-4 control-label">Coordinador</label>
         	<div class="col-md-8">
	      	 <select class="form-control" name="Coordinador">
	           	<c:forEach items="${profesoresDepartamento_lista}" var="profesor">
	             	 <option value="${profesor.email}">${profesor.name}</option>
	         	</c:forEach>
	         </select>
	        </div>
         </div>
      </div>
      <div class="form-group">
	      <label  class="col-md-4 control-label">Horas de Teor�a</label>
	      <div class="col-md-8">
	         <input type="text" name="HorasA" class="form-control" placeholder="Horas de teor�a">
	      </div>
	  </div>
      <div class="form-group">
	      <label  class="col-md-4 control-label">Horas de Pr�cticas </label>
	      <div class="col-md-8">
	         <input type="text" name="HorasB" class="form-control" placeholder="Horas de Pr�cticas">
	      </div>
      </div>
      <div class="form-group">
	      <label  class="col-md-4 control-label">Horas de Laboratorio</label>
	      <div class="col-md-8">
	         <input type="text" name="HorasC" class="form-control" placeholder="Horas de Laboratorio">
	      </div>
	  </div>
      <button type="submit" class="btn btn-success col-lg-2">Guardar</button>
   </form>
   </div>
</section>
</div>
<%@ include file="inc/footer.jsp"%>