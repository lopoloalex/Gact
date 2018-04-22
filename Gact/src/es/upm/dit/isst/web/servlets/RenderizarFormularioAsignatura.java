package es.upm.dit.isst.web.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.web.dao.AsignaturaDAOImplementation;
import es.upm.dit.isst.web.dao.DocenciaDAOImplementation;
import es.upm.dit.isst.web.dao.ProfesorDAOImplementation;
import es.upm.dit.isst.web.dao.model.Asignatura;
import es.upm.dit.isst.web.dao.model.Docencia;
import es.upm.dit.isst.web.dao.model.Profesor;
import es.upm.dit.isst.web.dao.model.ReconoceProfesor;

@WebServlet("/RenderizarFormularioAsignatura")
public class RenderizarFormularioAsignatura extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String gestionar = req.getParameter("asignaturaAGestionar");
		int id = Integer.parseInt(gestionar);
		Asignatura asignatura = new Asignatura();
		AsignaturaDAOImplementation asignaturaDAO = AsignaturaDAOImplementation.getInstance();
		asignatura=asignaturaDAO.readAsignatura(id);
		
		
		List<Profesor> profesores = asignatura.getProfesoresAsignatura();
		//req.getSession().setAttribute("profesor_list", profesores);
		
		List<Docencia> docencia_list= new ArrayList<Docencia>();
		ReconoceProfesor reconoce = new ReconoceProfesor();
		reconoce.setAsignaturaID(id);
		
		
		for(Profesor p :profesores) {
			reconoce.setEmail(p.getEmail());
			docencia_list.add(DocenciaDAOImplementation.getInstance().readDocencia(reconoce));
		}
		
		
		req.getSession().setAttribute("docencia_list", docencia_list);
		
		
		resp.sendRedirect(req.getContextPath() + "/FormularioAsignatura.jsp");
		req.getSession().setAttribute("asignatura", asignatura);

		
	}
		 

}
