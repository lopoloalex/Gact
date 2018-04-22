<%@ include file="inc/head.jsp"%>
<%@ include file="inc/nav-menu.jsp"%>
<div class="container-fluid p-0">
   <section class="resume-section p-3 p-lg-5  d-column" id="about">
      <div class="my-auto">
         <h2 class="mb-0">Añadir profesor</h2>
      </div>
      <form class="form-horizontal" role="form" action="AddProfesorServlet">
         <!-- <div class="form-group">
            <label  class="col-lg-2 control-label">Grado</label>
            <div class="col-lg-10">
              <select class="form-control">
             <option name="Titulacion">Grado en Ingeniería de Tecnilogias y Servicios de la Telecomunicación</option>
             <option name="Titulacion">Máster en ingeniería de Telecomunicaciones</option>
            
            </select>
             
            </div> -->
         <div class="form-group">
            <label class="col-lg-2 control-label">Email</label>
            <div class="col-lg-10">
               <input type="text" name="email" class="form-control"
                  placeholder="email de profesor">
            </div>
         </div>
         <button type="submit" class="btn btn-success col-lg-2">Guardar</button>
      </form>
   </section>
</div>
<%@ include file="inc/footer.jsp"%>