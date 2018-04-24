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
import es.upm.dit.isst.web.dao.ProfesorDAOImplementation;
import es.upm.dit.isst.web.dao.model.Asignatura;
import es.upm.dit.isst.web.dao.model.Departamento;
import es.upm.dit.isst.web.dao.model.Profesor;

@WebServlet("/EditarAsignaturaServlet")
public class  EditarAsignaturaServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException { 
		
		String asignaturaIDS = req.getParameter("asignaturaAEditarB");
		int asignaturaID = Integer.parseInt(asignaturaIDS);
		Asignatura asignatura = AsignaturaDAOImplementation.getInstance().readAsignatura(asignaturaID);
		
		String asignaturaIDSS = req.getParameter("Codigo");
		int asignaturaIDE = Integer.parseInt(asignaturaIDSS);
		
		String nombreAsignatura = req.getParameter("Name");
		
		String acronimo = req.getParameter("Acronimo");
		
		String titulacion = req.getParameter("Titulacion");

		String coordinadorEmail = req.getParameter("Coordinador");
		
		String nGruposS = req.getParameter("Ngrupos");
		int nGrupos = Integer.parseInt(nGruposS);

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
		asignatura.setSemestre(semestre);
		asignatura.setTitulacion(titulacion);

		
		
		AsignaturaDAOImplementation.getInstance().updateAsignatura(asignatura);
		
		req.getSession().setAttribute("asignaturas_lista", AsignaturaDAOImplementation.getInstance().readAllAsignatura());
		

		resp.sendRedirect(req.getContextPath()+"/Administrar.jsp");	
		
		
		
		

	}

}