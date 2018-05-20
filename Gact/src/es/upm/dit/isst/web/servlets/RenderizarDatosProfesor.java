package es.upm.dit.isst.web.servlets;

import java.awt.print.Book;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.web.dao.PlanDeEstudioDAOImplementation;
import es.upm.dit.isst.web.dao.ProfesorDAOImplementation;
import es.upm.dit.isst.web.dao.model.Asignatura;
import es.upm.dit.isst.web.dao.model.Docencia;
import es.upm.dit.isst.web.dao.model.PlanDeEstudio;
import es.upm.dit.isst.web.dao.model.Profesor;

@WebServlet("/RenderizarDatosProfesor")
public class RenderizarDatosProfesor extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String profesorEmail = req.getParameter("profesorEmail");
		Profesor profesor = ProfesorDAOImplementation.getInstance().readProfessor(profesorEmail);

		Set<Asignatura> asignaturas = profesor.getAsignaturasImpartidas();
		Set<Docencia> docencias = profesor.getDocenciasImpartidas();
		
		HashMap<Asignatura, ArrayList<String>> informacionProfe = new HashMap();
		
		for(Asignatura asignatura : asignaturas) {
			int id = asignatura.getAsignaturaID();
			for(Docencia docencia : docencias) {
				if(docencia.getAsignaturaID().getAsignaturaID() == id) {
					ArrayList<String> datosProfe = new ArrayList<String>();
					datosProfe.add(asignatura.getName());
					datosProfe.add(asignatura.getAcronimo());
					datosProfe.add(String.valueOf(docencia.getHorasA()));
					datosProfe.add(String.valueOf(docencia.getHorasB()));
					datosProfe.add(String.valueOf(docencia.getHorasC()));
					informacionProfe.put(asignatura, datosProfe);
				}
			}
		}
		
		if(req.getHeader("referer").contains("estadisticasDepartamento")) {
			req.getSession().setAttribute("vista_estadisticas", true);
		} else {
			req.getSession().setAttribute("vista_estadisticas", false);
		}
		
		req.getSession().setAttribute("informacionProfe", informacionProfe);
		
		resp.sendRedirect(req.getContextPath() + "/DatosProfesor.jsp");

	}
}