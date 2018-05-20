<%@ include file="inc/head.jsp"%>
<%@ include file="inc/nav-menu.jsp"%>
<div class="container-fluid p-0">
<section class="resume-section p-3 p-lg-5  d-column" id="about">
   <div class="my-auto">
   <h2 class="mb-0">Editar departamento
   </h2>
   <form class="form-horizontal" role="form" action="EditarDepartamentoServlet">

      <div class="form-group">
         <label  class="col-lg-2 control-label">Nombre departamento</label>
         <div class="col-lg-10">
            <input type="text" name="name" class="form-control" value="${departamento.nombre}">
             <input type="hidden" name="departamentoid" class="form-control" value="${departamento.departamentoID}">
            
         </div>
      </div>
      <div class="form-group">
         <label  class="col-lg-2 control-label">Responsable Email</label>
  	      	 <select class="form-control" name="coordinador">
	           	<c:forEach items="${departamento.getProfesoresDepartamento()}" var="profesor">
	             	 <option value="${profesor.email}">${profesor.name}</option>
	         	</c:forEach>
	         </select>
      </div>
      <button class ="btn btn-info pull-right" type="submit"> Guardar</button> 
     </form>
      	<a href="CrearDepartamento.jsp" class="btn btn-active">Volver</a>
</section>
</div>
<%@ include file="inc/footer.jsp"%>