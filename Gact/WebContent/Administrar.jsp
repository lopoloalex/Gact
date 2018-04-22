<%@ include file="inc/head.jsp"%>
<%@ include file="inc/nav-menu.jsp"%>
<div class="container-fluid p-0">
   <section class="resume-section p-3 p-lg-5 d-column" id="about">
      <div class="my-auto">
         <h2 class="mb-0">
            Administrar
            <button type="button" class="btn btn-info pull-right"
               id="login-button"
               onClick="window.location.href='CrearAsignatura.jsp'">Crear
            nueva asignatura</button>
         </h2>
         <div class="panel panel-info">
            <ul class="list-group">
               <a class="list-group-item active">Grado en ingeniería de
               servicios y sistemas de Telecomunicación </a>
               <c:forEach items="${asignaturas_lista}" var="asignaturas">
                  <a href="#" class="list-group-item">
                     <div>
                        <label for="checkbox" name="nombre">${asignaturas.name}</label>
                        <form action="BorrarAsignaturaServlet">	
                           <button class ="btn btn-info pull-right"> BORRAR								
                           <input type="hidden" class="btn btn-info pull-right"
                              name="asignaturaABorrar" value=${asignaturas.asignaturaID} placeholder="BORRAR">
                           </button>
                        </form>
                     </div>
                  </a>
               </c:forEach>
            </ul>
         </div>
      </div>
      <div class="panel panel-info">
         <ul class="list-group">
            <a class="list-group-item active"> Master en ingenieria de
            telecomunicacion</a>
            <a href="#" class="list-group-item">
               <div>
                  <label for="checkbox" onClick="window.location.href='index.jsp'">Redes
                  de Comunicaciones</label>
               </div>
            </a>
            <a href="#" class="list-group-item">
               <div>
                  <label for="checkbox" onClick="window.location.href='index.jsp'">Aplicaciones
                  y servicios</label>
               </div>
            </a>
         </ul>
      </div>
</section>
</div>
<%@ include file="inc/footer.jsp"%>