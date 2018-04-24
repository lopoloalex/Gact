package es.upm.dit.isst.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.web.dao.DepartamentoDAOImplementation;
import es.upm.dit.isst.web.dao.PlanDeEstudioDAOImplementation;
import es.upm.dit.isst.web.dao.model.Asignatura;
import es.upm.dit.isst.web.dao.model.Departamento;
import es.upm.dit.isst.web.dao.model.PlanDeEstudio;
import es.upm.dit.isst.web.dao.model.Profesor;

@WebServlet("/BorrarPlanDeEstudiosServlet")
public class BorrarPlanDeEstudiosServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException { 
		
		
		String acronimo = req.getParameter("planABorrar");
	
		
		PlanDeEstudio plan = PlanDeEstudioDAOImplementation.getInstance().readPlanDeEstudio(acronimo);
		
		for(Asignatura a : plan.getAsignaturasPlanEstudio()) {
			
			
			
		}
		
		
		for(Departamento d : plan.getDepartamentosPlanEstudio()) {
			for (PlanDeEstudio p: d.getPlanesDeEstudio()) {
				if(p==plan) {			
					d.getPlanesDeEstudio().remove(p);
					DepartamentoDAOImplementation.getInstance().updateDepartamento(d);
				}
			}
		}
		
		PlanDeEstudioDAOImplementation.getInstance().deletePlanDeEstudio(plan);
		
		req.getSession().setAttribute("plan_list", PlanDeEstudioDAOImplementation.getInstance().readAllPlanDeEstudio());

		resp.sendRedirect(req.getContextPath() + "/CrearPlanDeEstudio.jsp");
		
	}

}
