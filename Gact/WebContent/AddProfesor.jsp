<%@ include file="inc/head.jsp"%>
<%@ include file="inc/nav-menu.jsp"%>
<div class="container-fluid p-0">
   <section class="resume-section p-3 p-lg-5  d-column" id="about">
      <div class="my-auto">
         <h2 class="mb-0">Añadir profesor</h2>
      </div>
      <form class="form-horizontal" role="form" action="AddProfesorServlet">

         <div class="form-group">
            <label class="col-lg-2 control-label">Email</label>
            <div class="col-lg-10">
               <input type="text" name="email" class="form-control"
                  placeholder="email de profesor">
            </div>
         </div>
         <div class="form-group">
         
          <label class="col-lg-2 control-label">Horas A</label>
            <div class="col-lg-10">
               <input type="text" name="horasA" class="form-control"
                  placeholder="horasA">
            </div>
         </div>
                  <div class="form-group">
         
                   <label class="col-lg-2 control-label">Horas B</label>
            <div class="col-lg-10">
               <input type="text" name="horasB" class="form-control"
                  placeholder="horasB">
            </div>
         </div>
         
                  <div class="form-group">
         
                   <label class="col-lg-2 control-label">Horas C</label>
            <div class="col-lg-10">
               <input type="text" name="horasC" class="form-control"
                  placeholder="horasC">
            </div>
         </div>
         
                           <input type="hidden" class="btn btn-info pull-right"
                              name="asignatura" value=${asignatura.asignaturaID} >
                          <button type="submit" class="btn btn-success col-lg-2"> Guardar </button>
         
      </form>
      </div>
      
   </section>
<%@ include file="inc/footer.jsp"%>