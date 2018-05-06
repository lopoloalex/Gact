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
               <option value="grado">Grado en Ingenier�a de Tecnilogias y Servicios de la Telecomunicaci�n</option>
               <option value="master">M�ster en ingenier�a de Telecomunicaciones</option>
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
         <label  class="col-lg-2 control-label">C�digo: ${asignatura.asignaturaID}</label>
         <div class="col-lg-10">
            <input type="hidden" name="Codigo" class="form-control" placeholder="C�digo" value="${asignatura.asignaturaID}">
         </div>
      </div>
      <div class="form-group">
         <label  class="col-lg-2 control-label">Acr�nimo</label>
         <div class="col-lg-10">
            <input type="text" name="Acronimo" class="form-control"  placeholder="Acr�nimo" value="${asignatura.acronimo}">
         </div>
      </div>
      <div class="form-group">
         <label  class="col-lg-2 control-label">Grupos de Teor�a</label>
         <div class="col-lg-10">
            <input type="number" name="Ngrupos" class="form-control"  placeholder="N�mero de grupos de teor�a" value="${asignatura.nGrupos}">
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
         <label  class="col-lg-2 control-label">Cr�ditos ECTS</label>
         <div class="col-lg-10">
            <input type="text" name="Creditos" class="form-control" placeholder="N�mero de cr�ditos ECTS" value="${asignatura.creditos}">
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
	      <label  class="col-lg-2 control-label">Horas de Teor�a</label>
	      <div class="col-lg-10">
	         <input type="number" name="HorasA" class="form-control" placeholder="Horas de teor�a" value="${asignatura.horasTotalesA}">
	      </div>
	  </div>
      <div class="form-group">
	      <label  class="col-lg-2 control-label">Horas de Pr�cticas </label>
	      <div class="col-lg-10">
	         <input type="text" name="HorasB" class="form-control" placeholder="Horas de Pr�cticas" value="${asignatura.horasTotalesB}">
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