package es.upm.dit.isst.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.web.dao.ProfesorDAOImplementation;

@WebServlet("/RenderizarCrearProfesorServlet")
public class RenderizarCrearProfesorServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getSession().setAttribute("profesor_list", ProfesorDAOImplementation.getInstance().readAllProfessor());
		resp.sendRedirect(req.getContextPath() + "/CrearProfesor.jsp");
		
	}
	

}
