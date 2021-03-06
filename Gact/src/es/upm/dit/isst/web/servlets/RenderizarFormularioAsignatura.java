package es.upm.dit.isst.web.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

@WebServlet("/RenderizarFormularioAsignatura")
public class RenderizarFormularioAsignatura extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String gestionar = req.getParameter("asignaturaAGestionar");
		int id = Integer.parseInt(gestionar);
		Asignatura asignatura = new Asignatura();
		AsignaturaDAOImplementation asignaturaDAO = AsignaturaDAOImplementation.getInstance();
		asignatura = asignaturaDAO.readAsignatura(id);
		
		
		Set<Profesor> profesores = asignatura.getProfesoresAsignatura();
		//req.getSession().setAttribute("profesor_list", profesores);
		
		List<Docencia> docencia_list= new ArrayList<Docencia>();
		
		Docencia docencia = new Docencia(); 
		Double horasATotal = 0.0;
		Double horasBTotal = 0.0;
		Double horasCTotal = 0.0;
		
		for(Profesor p :profesores) {
			String reconoce = gestionar+p.getEmail();
			docencia = DocenciaDAOImplementation.getInstance().readDocencia(reconoce);
			if (docencia!=null){
			docencia_list.add(docencia);
			horasATotal = horasATotal+docencia.getHorasA();
			horasBTotal = horasBTotal+docencia.getHorasB();
			horasCTotal = horasCTotal+docencia.getHorasC();
			}
		}
		
		if(req.getHeader("referer").contains("estadisticasDepartamento")) {
			req.getSession().setAttribute("vista_estadisticas", true);
		} else {
			req.getSession().setAttribute("vista_estadisticas", false);
		}
		
		req.getSession().setAttribute("docencia_list", docencia_list);
		req.getSession().setAttribute("horasA", horasATotal);
		req.getSession().setAttribute("horasB", horasBTotal);
		req.getSession().setAttribute("horasC", horasCTotal);

		
		resp.sendRedirect(req.getContextPath() + "/FormularioAsignatura.jsp");
		req.getSession().setAttribute("asignatura", asignatura);

		
	}
		 

}
