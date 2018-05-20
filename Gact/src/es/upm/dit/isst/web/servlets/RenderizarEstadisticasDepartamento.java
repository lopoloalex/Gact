package es.upm.dit.isst.web.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.web.dao.AsignaturaDAOImplementation;
import es.upm.dit.isst.web.dao.ProfesorDAOImplementation;
import es.upm.dit.isst.web.dao.model.Asignatura;
import es.upm.dit.isst.web.dao.model.Departamento;
import es.upm.dit.isst.web.dao.model.Profesor;


@WebServlet("/RenderizarEstadisticasDepartamento")
public class RenderizarEstadisticasDepartamento extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Si el profesor no es responsable de departamento le devolvemos a la página anterior
		if(!(boolean) req.getSession().getAttribute("isResponsable")) { 
			resp.sendRedirect(req.getHeader("referer"));
		}
		
		// Cogemos los datos del profesor que está logeado
		Profesor profesor = (Profesor) req.getSession().getAttribute("profesor");
		profesor = ProfesorDAOImplementation.getInstance().readProfessor(profesor.getEmail());
		
		Departamento departamento = profesor.getDepartamento();
		Set<Asignatura> asignaturas_lista = departamento.getAsignaturasDepartamento();
		
		req.getSession().setAttribute("asignaturas_lista", asignaturas_lista);
		req.getSession().setAttribute("departamento", departamento.getNombre());
		req.getSession().setAttribute("vista", "Asignaturas");
		
		resp.sendRedirect(req.getContextPath()+"/estadisticasDepartamento.jsp");
	}

}
