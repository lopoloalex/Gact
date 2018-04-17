<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Formulario</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="https://fonts.googleapis.com/css?family=Saira+Extra+Condensed:100,200,300,400,500,600,700,800,900" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="vendor/devicons/css/devicons.min.css" rel="stylesheet">
    <link href="vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/resume.min.css" rel="stylesheet">

  </head>

  <body id="page-top">

    <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top" id="sideNav">
      <a class="navbar-brand js-scroll-trigger" href="#page-top">
        <span class="d-block d-lg-none">Start Bootstrap</span>
        <span class="d-none d-lg-block">
          <img class="img-fluid img-profile rounded-circle mx-auto mb-2" src="images/profile.jpg" alt="">
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
            <a class="nav-link js-scroll-trigger" href="login.jsp">Salir</a>
          </li>
        </ul>
      </div>
    </nav>

    <div class="container-fluid p-0">

      <section class="resume-section p-3 p-lg-5  d-column" id="about">
        <div class="my-auto">
          <h2 class="mb-0">Formulario de asignatura  
          </h2>
          <p>Grupo de Teoria: UNO </p>
           <div id="table" class="table-editable">
    <span class="table-add glyphicon glyphicon-plus"></span>
    <table class="table">
      <tr>
        <th>Profesor</th>
        <th>Horas(A)</th>
        <th>Horas(B)</th>
        <th>Horas(C)</th>
        <th>Total</th>
      </tr>
      <tr>
        <td contenteditable="true">Alice</td>
        <td contenteditable="true">0</td>
        <td contenteditable="true">16</td>
        <td contenteditable="true">12</td>
        <td contenteditable="true">28</td>
        <td>
          <span class="table-remove glyphicon glyphicon-remove"></span>
        </td>
        <td>
          <span class="table-up glyphicon glyphicon-arrow-up"></span>
          <span class="table-down glyphicon glyphicon-arrow-down"></span>
        </td>
      </tr>
      <tr>
        <td contenteditable="true">Bob</td>
        <td contenteditable="true">18</td>
        <td contenteditable="true">16</td>
        <td contenteditable="true">0</td>
        <td contenteditable="true">34</td>
        <td>
          <span class="table-remove glyphicon glyphicon-remove"></span>
        </td>
        <td>
          <span class="table-up glyphicon glyphicon-arrow-up"></span>
          <span class="table-down glyphicon glyphicon-arrow-down"></span>
        </td>
      </tr>
            <tr>
        <td contenteditable="true">Carol</td>
        <td contenteditable="true">18</td>
        <td contenteditable="true">16</td>
        <td contenteditable="true">24</td>
        <td contenteditable="true">58</td>
        <td>
          <span class="table-remove glyphicon glyphicon-remove"></span>
        </td>
        <td>
          <span class="table-up glyphicon glyphicon-arrow-up"></span>
          <span class="table-down glyphicon glyphicon-arrow-down"></span>
        </td>
      </tr>

      
    </table>
    <p>Grupo de Teoria: DOS </p>
     <div id="table" class="table-editable">
    <span class="table-add glyphicon glyphicon-plus"></span>
    <table class="table">
      <tr>
        <th>Profesor</th>
        <th>Horas(A)</th>
        <th>Horas(B)</th>
        <th>Horas(C)</th>
        <th>Total</th>
      </tr>
      <tr>
        <td contenteditable="true">Alice</td>
        <td contenteditable="true">0</td>
        <td contenteditable="true">16</td>
        <td contenteditable="true">12</td>
        <td contenteditable="true">28</td>
        <td>
          <span class="table-remove glyphicon glyphicon-remove"></span>
        </td>
        <td>
          <span class="table-up glyphicon glyphicon-arrow-up"></span>
          <span class="table-down glyphicon glyphicon-arrow-down"></span>
        </td>
      </tr>
      <tr>
        <td contenteditable="true">Bob</td>
        <td contenteditable="true">18</td>
        <td contenteditable="true">16</td>
        <td contenteditable="true">0</td>
        <td contenteditable="true">34</td>
        <td>
          <span class="table-remove glyphicon glyphicon-remove"></span>
        </td>
        <td>
          <span class="table-up glyphicon glyphicon-arrow-up"></span>
          <span class="table-down glyphicon glyphicon-arrow-down"></span>
        </td>
      </tr>
            <tr>
        <td contenteditable="true">Carol</td>
        <td contenteditable="true">18</td>
        <td contenteditable="true">16</td>
        <td contenteditable="true">24</td>
        <td contenteditable="true">58</td>
        <td>
          <span class="table-remove glyphicon glyphicon-remove"></span>
        </td>
        <td>
          <span class="table-up glyphicon glyphicon-arrow-up"></span>
          <span class="table-down glyphicon glyphicon-arrow-down"></span>
        </td>
      </tr>

      
    </table>
    <p>Grupo de Teoria: TRES </p>
     <div id="table" class="table-editable">
    <span class="table-add glyphicon glyphicon-plus"></span>
    <table class="table">
      <tr>
        <th>Profesor</th>
        <th>Horas(A)</th>
        <th>Horas(B)</th>
        <th>Horas(C)</th>
        <th>Total</th>
      </tr>
      <tr>
        <td contenteditable="true">Alice</td>
        <td contenteditable="true">0</td>
        <td contenteditable="true">16</td>
        <td contenteditable="true">12</td>
        <td contenteditable="true">28</td>
        <td>
          <span class="table-remove glyphicon glyphicon-remove"></span>
        </td>
        <td>
          <span class="table-up glyphicon glyphicon-arrow-up"></span>
          <span class="table-down glyphicon glyphicon-arrow-down"></span>
        </td>
      </tr>
      <tr>
        <td contenteditable="true">Bob</td>
        <td contenteditable="true">18</td>
        <td contenteditable="true">16</td>
        <td contenteditable="true">0</td>
        <td contenteditable="true">34</td>
        <td>
          <span class="table-remove glyphicon glyphicon-remove"></span>
        </td>
        <td>
          <span class="table-up glyphicon glyphicon-arrow-up"></span>
          <span class="table-down glyphicon glyphicon-arrow-down"></span>
        </td>
      </tr>
            <tr>
        <td contenteditable="true">Carol</td>
        <td contenteditable="true">18</td>
        <td contenteditable="true">16</td>
        <td contenteditable="true">24</td>
        <td contenteditable="true">58</td>
        <td>
          <span class="table-remove glyphicon glyphicon-remove"></span>
        </td>
        <td>
          <span class="table-up glyphicon glyphicon-arrow-up"></span>
          <span class="table-down glyphicon glyphicon-arrow-down"></span>
        </td>
      </tr>

      
    </table>
  </div>
          
      </section>

      

          
     
    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for this template -->
    <script src="js/resume.min.js"></script>

  </body>

</html>