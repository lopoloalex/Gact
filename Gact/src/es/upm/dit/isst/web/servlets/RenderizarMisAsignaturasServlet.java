package es.upm.dit.isst.web.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.web.dao.AsignaturaDAOImplementation;
import es.upm.dit.isst.web.dao.PlanDeEstudioDAOImplementation;
import es.upm.dit.isst.web.dao.ProfesorDAOImplementation;
import es.upm.dit.isst.web.dao.model.Asignatura;
import es.upm.dit.isst.web.dao.model.PlanDeEstudio;
import es.upm.dit.isst.web.dao.model.Profesor;

@WebServlet("/RenderizarMisAsignaturasServlet")
public class RenderizarMisAsignaturasServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Profesor pro = (Profesor) req.getSession().getAttribute("profesor");
		System.out.println(pro.toString());
		//pro = ProfesorDAOImplementation.getInstance().readProfessor("alex");
		pro = ProfesorDAOImplementation.getInstance().readProfessor(pro.getEmail());
//		System.out.println(pro.toString());

		Set<Asignatura> asig = pro.getAsignaturasImpartidas();
		System.out.println("-------------------------------------------------------");
		System.out.println(asig);
		System.out.println("///////////////////////////////////////////////////////////");
		List<PlanDeEstudio> planes = PlanDeEstudioDAOImplementation.getInstance().readAllPlanDeEstudio();
		req.getSession().setAttribute("planes_lista", planes);
		req.getSession().setAttribute("asignaturas_lista", asig);
		resp.sendRedirect(req.getContextPath() + "/MisAsignaturas.jsp");

	}
		

}
