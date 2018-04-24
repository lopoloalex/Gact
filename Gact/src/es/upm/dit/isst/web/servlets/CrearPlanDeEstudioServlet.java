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

		
		PlanDeEstudio nuevoPlan = new PlanDeEstudio();
		nuevoPlan.setAcronimo(acronimo);
		nuevoPlan.setName(name);
		
		Profesor pro= (Profesor) req.getSession().getAttribute("profesor");
		Departamento departamento = pro.getDepartamento();

		departamento.getPlanesDeEstudio().add(nuevoPlan);
		nuevoPlan.getDepartamentosPlanEstudio().add(departamento);
		
		PlanDeEstudioDAOImplementation.getInstance().createPlanDeEstudio(nuevoPlan);
		DepartamentoDAOImplementation.getInstance().updateDepartamento(departamento);
	
		
		req.getSession().setAttribute("plan_list", PlanDeEstudioDAOImplementation.getInstance().readAllPlanDeEstudio());

		resp.sendRedirect(req.getContextPath() + "/CrearPlanDeEstudio.jsp");
		
	}
	
}