
package es.upm.dit.isst.web.servlets;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.web.dao.AsignaturaDAOImplementation;
import es.upm.dit.isst.web.dao.DepartamentoDAOImplementation;
import es.upm.dit.isst.web.dao.DocenciaDAOImplementation;
import es.upm.dit.isst.web.dao.ProfesorDAOImplementation;
import es.upm.dit.isst.web.dao.model.Asignatura;
import es.upm.dit.isst.web.dao.model.Departamento;
import es.upm.dit.isst.web.dao.model.Docencia;
import es.upm.dit.isst.web.dao.model.Profesor;

@WebServlet("/CrearAsignaturaServlet")
public class CrearAsignaturaServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException { 

		String asignaturaIDS = req.getParameter("Codigo");
		int asignaturaID = Integer.parseInt(asignaturaIDS);
		String nombreAsignatura = req.getParameter("Name");
		String acronimo = req.getParameter("Acronimo");
		String titulacion = req.getParameter("Titulacion");
		String nGruposS = req.getParameter("Ngrupos");
		int nGrupos = Integer.parseInt(nGruposS);
		String semestreS = req.getParameter("Semestre");
		int semestre = Integer.parseInt(semestreS);
		String creditosS = req.getParameter("Creditos");
		double creditos = Double.parseDouble(creditosS);
		String coordinadorEmail = req.getParameter("Coordinador");
		String departamentoIDS = req.getParameter("DepartamentoID");
		int departamentoID = Integer.parseInt(departamentoIDS);
		String horasTotalesAS = req.getParameter("HorasA");
		double horasTotalesA = Double.parseDouble(horasTotalesAS);
		String horasTotalesBS = req.getParameter("HorasB");
		double horasTotalesB = Double.parseDouble(horasTotalesBS);
		String horasTotalesCS = req.getParameter("HorasC");
		double horasTotalesC = Double.parseDouble(horasTotalesCS);
		
		//Cargamos el departamento y profesor asignado como coordinador de la base de datos
		Departamento departamento = DepartamentoDAOImplementation.getInstance().readDepartamento(departamentoID);
		Profesor coordinador = ProfesorDAOImplementation.getInstance().readProfessor(coordinadorEmail);


		//Definimos los parametros de la nueva asignatura
		Asignatura nuevaAsignatura = new Asignatura();
		nuevaAsignatura.setAsignaturaID(asignaturaID);
		nuevaAsignatura.setAcronimo(acronimo);
		nuevaAsignatura.setCoordinadorEmail(coordinadorEmail);
		nuevaAsignatura.setCreditos(creditos);
		nuevaAsignatura.setName(nombreAsignatura);
		nuevaAsignatura.setDepartamento(departamento);
		nuevaAsignatura.setHorasTotalesA(horasTotalesA);
		nuevaAsignatura.setHorasTotalesB(horasTotalesB);
		nuevaAsignatura.setHorasTotalesC(horasTotalesC);
		nuevaAsignatura.setnGrupos(nGrupos);
		nuevaAsignatura.setSemestre(semestre);
		nuevaAsignatura.setTitulacion(titulacion);
		AsignaturaDAOImplementation.getInstance().createAsignatura(nuevaAsignatura);
		Asignatura asignatura = AsignaturaDAOImplementation.getInstance().readAsignatura(asignaturaID);
		
		//Creamos la docencia del Coordinador 
		Docencia docencia = new Docencia();
		docencia.setDocencia(asignaturaIDS+coordinador.getEmail());
		docencia.setHorasA(0.0);
		docencia.setHorasB(0.0);
		docencia.setHorasC(0.0);
		docencia.setProfesorID(coordinador);
		docencia.setAsignaturaID(AsignaturaDAOImplementation.getInstance().readAsignatura(asignaturaID));
		DocenciaDAOImplementation.getInstance().createDocencia(docencia);
		docencia = DocenciaDAOImplementation.getInstance().readDocencia(docencia.getDocencia());


		//FALTA CREAR PLAN DE ESTUDIO
		
		//Añadimos la nueva docencia al coordinador
		 coordinador.getDocenciasImpartidas().add(docencia);
		
//		//Añadimos la nueva docencia a la nueva Asignatura
		 asignatura.getDocencias().add(docencia);
		
////		Añadimos el Coordinador a la lista de profesores de la asignatura 
//		List<Profesor> asignaturaProfes = asignatura.getProfesoresAsignatura();
//		asignaturaProfes.add(coordinador);
//		asignatura.setProfesoresAsignatura(asignaturaProfes);
		
		//Guardamos la Asignatura en la lista de asignaturas de el Coordinador.
		coordinador.getAsignaturasImpartidas().add(asignatura);
	
//		//Guardamos la asignatura en la lista de asignaturas del Departamento
//		List<Asignatura> asignaturasDepartamento = departamento.getAsignaturasDepartamento();
//		asignaturasDepartamento.add(asignatura);
//		departamento.setAsignaturasDepartamento(asignaturasDepartamento);
		
		
		
		//creamos la nueva docencia asignatura y hacemos un update de el coodinador y el departamento
		
		DocenciaDAOImplementation.getInstance().updateDocencia(docencia);
//		AsignaturaDAOImplementation.getInstance().updateAsignatura(asignatura);
		ProfesorDAOImplementation.getInstance().updateProfessor(coordinador);
//		DepartamentoDAOImplementation.getInstance().updateDepartamento(departamento);





		
		req.getSession().setAttribute("asignaturas_lista", DepartamentoDAOImplementation.getInstance().readDepartamento(departamentoID).getAsignaturasDepartamento());
		
		

		resp.sendRedirect(req.getContextPath()+"/Administrar.jsp");
	}

}