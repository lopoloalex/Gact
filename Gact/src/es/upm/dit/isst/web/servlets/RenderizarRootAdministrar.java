package es.upm.dit.isst.web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.web.dao.AsignaturaDAOImplementation;
import es.upm.dit.isst.web.dao.ProfesorDAOImplementation;
import es.upm.dit.isst.web.dao.model.Asignatura;

@WebServlet("/RenderizarRootAdministrar")
public class RenderizarRootAdministrar extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		List<Asignatura> asignaturas = AsignaturaDAOImplementation.getInstance().readAllAsignatura();
		
		req.getSession().setAttribute("asignaturas_lista", asignaturas);
		resp.sendRedirect(req.getContextPath() + "/RootAdministrar.jsp");
	}

		

}