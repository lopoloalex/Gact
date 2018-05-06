<%@ include file="inc/head.jsp"%>
<%@ include file="inc/nav-menu.jsp"%>
<div class="container-fluid p-0">
<section class="resume-section p-3 p-lg-5  d-column" id="about">
   <div class="my-auto">
   <h2 class="mb-0">Editar asignatura
   </h2>
   <form class="form-horizontal" role="form" action="EditarAsignaturaServlet">
      <div class="form-group">
         <label  class="col-lg-2 control-label">Grado</label>
         <div class="col-lg-10">
            <select class="form-control" name="Titulacion">
               <option value="grado">Grado en Ingeniería de Tecnilogias y Servicios de la Telecomunicación</option>
               <option value="master">Máster en ingeniería de Telecomunicaciones</option>
            </select>
         </div>
      </div>
      <div class="form-group">
         <label  class="col-lg-2 control-label">Nombre de asignatura</label>
         <div class="col-lg-10">
            <input type="text" name="Name" class="form-control" placeholder="Nombre de asignatura" value="${asignatura.name}">
         </div>
      </div>
     
      <div class="form-group">
         <label  class="col-lg-2 control-label">Código: ${asignatura.asignaturaID}</label>
         <div class="col-lg-10">
            <input type="hidden" name="Codigo" class="form-control" placeholder="Código" value="${asignatura.asignaturaID}">
         </div>
      </div>
      <div class="form-group">
         <label  class="col-lg-2 control-label">Acrónimo</label>
         <div class="col-lg-10">
            <input type="text" name="Acronimo" class="form-control"  placeholder="Acrónimo" value="${asignatura.acronimo}">
         </div>
      </div>
      <div class="form-group">
         <label  class="col-lg-2 control-label">Grupos de Teoría</label>
         <div class="col-lg-10">
            <input type="number" name="Ngrupos" class="form-control"  placeholder="Número de grupos de teoría" value="${asignatura.nGrupos}">
         </div>
      </div>
      </div>
      <div class="form-group">
         <label  class="col-lg-2 control-label">Semestre</label>
         <div class="col-lg-10">
            <input type="number" name="Semestre" class="form-control" placeholder="Semestre" value="${asignatura.semestre}">
         </div>
      </div>
      <div class="form-group">
         <label  class="col-lg-2 control-label">Créditos ECTS</label>
         <div class="col-lg-10">
            <input type="text" name="Creditos" class="form-control" placeholder="Número de créditos ECTS" value="${asignatura.creditos}">
         </div>
      </div>
      <div class="col-lg-10">
      	 <label  class="col-lg-2 control-label">Coordinador</label>
      	 	<select class="form-control" name="Coordinador">
            	<c:forEach items="${profesoresDepartamento_lista}" var="profesor">
              	 	<option value="${profesor.email}">${profesor.name}</option>
           		</c:forEach>
           	</select>
      </div>
      <div class="form-group">
	      <label  class="col-lg-2 control-label">Horas de Teoría</label>
	      <div class="col-lg-10">
	         <input type="number" name="HorasA" class="form-control" placeholder="Horas de teoría" value="${asignatura.horasTotalesA}">
	      </div>
	  </div>
      <div class="form-group">
	      <label  class="col-lg-2 control-label">Horas de Prácticas </label>
	      <div class="col-lg-10">
	         <input type="text" name="HorasB" class="form-control" placeholder="Horas de Prácticas" value="${asignatura.horasTotalesB}">
	      </div>
      </div>
      <div class="form-group">
	      <label  class="col-lg-2 control-label">Horas de Laboratorio</label>
	      <div class="col-lg-10">
	         <input type="number" name="HorasC" class="form-control" placeholder="Horas de Laboratorio" value="${asignatura.horasTotalesC}">
	      </div>
	  </div>
	  
	   <input type="hidden" class="btn btn-info pull-right"
                              name="asignaturaAEditarB" value=${asignatura.asignaturaID}>
	   <button class ="btn btn-info pull-right" type="submit"> Guardar							
         </button>                 
   </form>
      	<a href="Administrar.jsp" class="btn btn-active">Volver</a>
</section>
</div>
<%@ include file="inc/footer.jsp"%>