<nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top" id="sideNav">
  <a class="navbar-brand js-scroll-trigger" href="#page-top">
    <span class="d-block d-lg-none"> </span>
    <span class="d-none d-lg-block">
      <img class="img-fluid img-profile rounded-circle mx-auto mb-2" src="imagenes/donald.jpg" alt="">
    </span>
  </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link js-scroll-trigger" href="index.jsp">Inicio</a>
      </li>
      <li class="nav-item">
        <a class="nav-link js-scroll-trigger" href="Miperfil.jsp">Mi perfil</a>
      </li>
      <li class="nav-item">
        <a  class="nav-link js-scroll-trigger" href="MisAsignaturas.jsp">Asignaturas</a>
      </li>
      <li class="nav-item">
        <a class="nav-link js-scroll-trigger" href="Administrar.jsp">Administrar</a>
      </li>
      <li class="nav-item">
        <%@ include file = "../FormLogout.jsp" %>
      </li>
    </ul>
  </div>
</nav>