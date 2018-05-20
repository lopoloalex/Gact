package es.upm.dit.isst.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Set;

import es.upm.dit.isst.web.dao.AsignaturaDAOImplementation;
import es.upm.dit.isst.web.dao.DepartamentoDAOImplementation;
import es.upm.dit.isst.web.dao.PlanDeEstudioDAOImplementation;
import es.upm.dit.isst.web.dao.ProfesorDAOImplementation;
import es.upm.dit.isst.web.dao.model.Asignatura;
import es.upm.dit.isst.web.dao.model.Profesor;
import es.upm.dit.isst.web.dao.model.Departamento;

@WebServlet("/RenderizarRootEditarAsignaturaServlet")
public class RenderizarRootEditarAsignaturaServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {

	String asignaturaIDS = req.getParameter("asignaturaAEditar");
	int asignaturaID = Integer.parseInt(asignaturaIDS);
	Asignatura asignatura = AsignaturaDAOImplementation.getInstance().readAsignatura(asignaturaID);
	req.getSession().setAttribute("asignatura", asignatura);
	
	List<Departamento> departamentos = DepartamentoDAOImplementation.getInstance().readAllDepartamentos();
	List<Profesor> profesoresDepartamento_lista = ProfesorDAOImplementation.getInstance().readAllProfessor();
	req.getSession().setAttribute("profesoresDepartamento_lista", profesoresDepartamento_lista);
	req.getSession().setAttribute("planes_lista", PlanDeEstudioDAOImplementation.getInstance().readAllPlanDeEstudio());
	req.getSession().setAttribute("departamentos_lista",departamentos);

	
	resp.sendRedirect(req.getContextPath()+"/EditarRootAsignatura.jsp");	
	
	}
}