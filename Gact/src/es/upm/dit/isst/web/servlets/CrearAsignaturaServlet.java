
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
		int creditos = Integer.parseInt(creditosS);
		String coordinadorEmail = req.getParameter("Coordinador");
		

		String departamentoIDS = req.getParameter("DepartamentoID");
		int departamentoID = Integer.parseInt(departamentoIDS);

		Departamento departamento = DepartamentoDAOImplementation.getInstance().readDepartamento(departamentoID);


		String horasTotalesAS = req.getParameter("HorasA");
		double horasTotalesA = Double.parseDouble(horasTotalesAS);
		String horasTotalesBS = req.getParameter("HorasA");
		double horasTotalesB = Double.parseDouble(horasTotalesBS);
		String horasTotalesCS = req.getParameter("HorasA");
		double horasTotalesC = Double.parseDouble(horasTotalesCS);



		//Asignatura asignatura = AsignaturaDAOImplementation.getInstance().loginProfessor(email,password);
		//comprobar la existencia de codigo, nombre, acronimo....

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
		//nuevaAsignatura.setProfesoresAsignatura(profesoresAsignatura);
		nuevaAsignatura.setSemestre(semestre);
		nuevaAsignatura.setTitulacion(titulacion);

		departamento.getAsignaturasDepartamento().add(nuevaAsignatura);
		
		AsignaturaDAOImplementation.getInstance().createAsignatura(nuevaAsignatura);
		req.getSession().setAttribute("asignaturas_lista", AsignaturaDAOImplementation.getInstance().readAllAsignatura());
		

		resp.sendRedirect(req.getContextPath()+"/Administrar.jsp");	
		
		
		
		

	}

}