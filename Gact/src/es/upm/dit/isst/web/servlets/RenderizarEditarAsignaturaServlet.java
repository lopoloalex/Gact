package es.upm.dit.isst.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.web.dao.AsignaturaDAOImplementation;
import es.upm.dit.isst.web.dao.ProfesorDAOImplementation;
import es.upm.dit.isst.web.dao.model.Asignatura;
@WebServlet("/RenderizarEditarAsignaturaServlet")
public class RenderizarEditarAsignaturaServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {

	String asignaturaIDS = req.getParameter("asignaturaAEditar");
	int asignaturaID = Integer.parseInt(asignaturaIDS);
	Asignatura asignatura = AsignaturaDAOImplementation.getInstance().readAsignatura(asignaturaID);
	req.getSession().setAttribute("asignatura", asignatura);
	resp.sendRedirect(req.getContextPath()+"/EditarAsignatura.jsp");	
	
	}
}