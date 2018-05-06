package es.upm.dit.isst.web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.web.dao.ProfesorDAOImplementation;
import es.upm.dit.isst.web.dao.model.Asignatura;
import es.upm.dit.isst.web.dao.model.Departamento;
import es.upm.dit.isst.web.dao.model.Profesor;

@WebServlet("/RenderizarCrearAsignaturaServlet")
public class RenderizarCrearAsignaturaServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Profesor profesor = (Profesor) req.getSession().getAttribute("profesor");
		Departamento departamento = profesor.getDepartamento();
		List<Profesor> profesoresDepartamento_lista = departamento.getProfesoresDepartamento();
		req.getSession().setAttribute("profesoresDepartamento_lista", profesoresDepartamento_lista);
		
		resp.sendRedirect(req.getContextPath()+"/CrearAsignatura.jsp");
	
	}
}