package es.upm.dit.isst.web.servlets;
import java.io.IOException;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.web.dao.AsignaturaDAOImplementation;
import es.upm.dit.isst.web.dao.DepartamentoDAOImplementation;
import es.upm.dit.isst.web.dao.DocenciaDAOImplementation;
import es.upm.dit.isst.web.dao.PlanDeEstudioDAOImplementation;
import es.upm.dit.isst.web.dao.ProfesorDAOImplementation;
import es.upm.dit.isst.web.dao.model.Asignatura;
import es.upm.dit.isst.web.dao.model.Departamento;
import es.upm.dit.isst.web.dao.model.Docencia;
import es.upm.dit.isst.web.dao.model.PlanDeEstudio;
import es.upm.dit.isst.web.dao.model.Profesor;

@WebServlet("/EditarRootAsignaturaServlet")
public class  EditarRootAsignaturaServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException { 
		
		String asignaturaIDS = req.getParameter("asignaturaAEditarB");
		int asignaturaID = Integer.parseInt(asignaturaIDS);
		Asignatura asignatura = AsignaturaDAOImplementation.getInstance().readAsignatura(asignaturaID);
		
		String asignaturaIDSS = req.getParameter("Codigo");
		int asignaturaIDE = Integer.parseInt(asignaturaIDSS);
		
		String nombreAsignatura = req.getParameter("Name");
		
		String acronimo = req.getParameter("Acronimo");
		
		String titulacion = req.getParameter("Titulacion");
		PlanDeEstudio plan = PlanDeEstudioDAOImplementation.getInstance().readPlanDeEstudio(titulacion);

		String coordinadorEmail = req.getParameter("Coordinador");
		Profesor coordinador = ProfesorDAOImplementation.getInstance().readProfessor(coordinadorEmail);
		
		String nGruposS = req.getParameter("Ngrupos");
		int nGrupos = Integer.parseInt(nGruposS);
		
		String cursoS = req.getParameter("Curso");
		int curso = Integer.parseInt(cursoS);
		
		String departamentoS = req.getParameter("Departamento");
		int departamentoId = Integer.parseInt(departamentoS);


		String semestreS = req.getParameter("Semestre");
		int semestre = Integer.parseInt(semestreS);

		String creditosS = req.getParameter("Creditos");
		double creditos = Double.parseDouble(creditosS);
	
		String horasTotalesAS = req.getParameter("HorasA");
		double horasTotalesA = Double.parseDouble(horasTotalesAS);
		String horasTotalesBS = req.getParameter("HorasB");
		double horasTotalesB = Double.parseDouble(horasTotalesBS);
		String horasTotalesCS = req.getParameter("HorasC");
		double horasTotalesC = Double.parseDouble(horasTotalesCS);
		
		
		asignatura.setAsignaturaID(asignaturaIDE);
		asignatura.setAcronimo(acronimo);
		asignatura.setCoordinadorEmail(coordinadorEmail);
		asignatura.setCreditos(creditos);
		asignatura.setName(nombreAsignatura);
		asignatura.setHorasTotalesA(horasTotalesA);
		asignatura.setHorasTotalesB(horasTotalesB);
		asignatura.setHorasTotalesC(horasTotalesC);
		asignatura.setnGrupos(nGrupos);
		asignatura.setCurso(curso);
		asignatura.setSemestre(semestre);
		asignatura.setPlanDeEstudio(plan);
		asignatura.setDepartamento(DepartamentoDAOImplementation.getInstance().readDepartamento(departamentoId));
		
		if(asignatura.getProfesoresAsignatura().contains(coordinador)) {
			
		} else {
			coordinador.getAsignaturasImpartidas().add(asignatura);
			Docencia docencia = new Docencia();
			docencia.setDocencia(asignaturaIDS+coordinador.getEmail());
			docencia.setHorasA(0.0);
			docencia.setHorasB(0.0);
			docencia.setHorasC(0.0);
			docencia.setProfesorID(coordinador);
			docencia.setAsignaturaID(AsignaturaDAOImplementation.getInstance().readAsignatura(asignaturaID));
			DocenciaDAOImplementation.getInstance().createDocencia(docencia);
			docencia = DocenciaDAOImplementation.getInstance().readDocencia(docencia.getDocencia());
			asignatura.getProfesoresAsignatura().add(coordinador);
			ProfesorDAOImplementation.getInstance().updateProfessor(coordinador);
			coordinador.getDocenciasImpartidas().add(docencia);
			asignatura.getDocencias().add(docencia);
		}

	
		
		AsignaturaDAOImplementation.getInstance().updateAsignatura(asignatura);
		
		req.getSession().setAttribute("asignaturas_lista", AsignaturaDAOImplementation.getInstance().readAllAsignatura());
		

		resp.sendRedirect(req.getContextPath()+"/RootAdministrar.jsp");	
		
		
		
		

	}

}