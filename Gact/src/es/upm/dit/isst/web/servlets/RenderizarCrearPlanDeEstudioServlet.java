package es.upm.dit.isst.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.web.dao.PlanDeEstudioDAOImplementation;
import es.upm.dit.isst.web.dao.model.Departamento;
import es.upm.dit.isst.web.dao.model.Profesor;


@WebServlet("/RenderizarCrearPlanDeEstudioServlet")
public class RenderizarCrearPlanDeEstudioServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getSession().setAttribute("plan_lista", PlanDeEstudioDAOImplementation.getInstance().readAllPlanDeEstudio() );
		
		resp.sendRedirect(req.getContextPath() + "/CrearPlanDeEstudio.jsp");


		
		
	}
}
