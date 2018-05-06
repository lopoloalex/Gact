package es.upm.dit.isst.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.web.dao.DepartamentoDAOImplementation;
import es.upm.dit.isst.web.dao.PlanDeEstudioDAOImplementation;
import es.upm.dit.isst.web.dao.model.Departamento;
import es.upm.dit.isst.web.dao.model.PlanDeEstudio;
import es.upm.dit.isst.web.dao.model.Profesor;


@WebServlet("/CrearPlanDeEstudioServlet")
public class CrearPlanDeEstudioServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException { 
		String acronimo = req.getParameter("acronimo");
		String name = req.getParameter("name");

		//asignamos los parametros del nuevo plan de estudios
		PlanDeEstudio nuevoPlan = new PlanDeEstudio();
		nuevoPlan.setAcronimo(acronimo);
		nuevoPlan.setName(name);
		
		//guardamos el nuevo plan de estudios
		PlanDeEstudioDAOImplementation.getInstance().createPlanDeEstudio(nuevoPlan);
		
		
		req.getSession().setAttribute("plan_lista", PlanDeEstudioDAOImplementation.getInstance().readAllPlanDeEstudio());

		resp.sendRedirect(req.getContextPath() + "/CrearPlanDeEstudio.jsp");
		
	}
	
}