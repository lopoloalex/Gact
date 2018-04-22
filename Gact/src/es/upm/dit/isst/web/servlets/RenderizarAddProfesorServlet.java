package es.upm.dit.isst.web.servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.web.dao.AsignaturaDAOImplementation;


@WebServlet("/RenderizarAddProfesorServlet")
public class RenderizarAddProfesorServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String asig = req.getParameter("asignatura");
		int id = Integer.parseInt(asig);
		
		
		req.getSession().setAttribute("asignatura", AsignaturaDAOImplementation.getInstance().readAsignatura(id));
		resp.sendRedirect(req.getContextPath()+"/AddProfesor.jsp");	

		
	}

}
