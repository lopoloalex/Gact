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
import es.upm.dit.isst.web.dao.model.Profesor;

@WebServlet("/RenderizarMisAsignaturasServlet")
public class RenderizarMisAsignaturasServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Profesor pro = (Profesor) req.getSession().getAttribute("profesor");
		pro = ProfesorDAOImplementation.getInstance().readProfessor(pro.getEmail());
		List<Asignatura> asig = pro.getAsignaturasImpartidas();
		
		System.out.println(ProfesorDAOImplementation.getInstance().readProfessor(pro.getEmail()).getAsignaturasImpartidas());
		
		req.getSession().setAttribute("asignaturas_lista", asig);
		resp.sendRedirect(req.getContextPath() + "/MisAsignaturas.jsp");

	}
		

}
