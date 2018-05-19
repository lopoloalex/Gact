package es.upm.dit.isst.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.web.dao.AsignaturaDAOImplementation;
import es.upm.dit.isst.web.dao.DocenciaDAOImplementation;
import es.upm.dit.isst.web.dao.ProfesorDAOImplementation;
import es.upm.dit.isst.web.dao.model.Asignatura;
import es.upm.dit.isst.web.dao.model.Departamento;
import es.upm.dit.isst.web.dao.model.Docencia;
import es.upm.dit.isst.web.dao.model.Profesor;

@WebServlet("/RenderizarVerMisHorasServlet")
public class RenderizarVerMisHorasServlet  extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException { 
		Profesor pro = (Profesor) req.getSession().getAttribute("profesor");
		pro = ProfesorDAOImplementation.getInstance().readProfessor(pro.getEmail());
		String gestionar = req.getParameter("asignaturaVer");
		int id = Integer.parseInt(gestionar);
		Asignatura asignatura = new Asignatura();
		AsignaturaDAOImplementation asignaturaDAO = AsignaturaDAOImplementation.getInstance();
		asignatura = asignaturaDAO.readAsignatura(id);
		
		Docencia docencia = DocenciaDAOImplementation.getInstance().readDocencia(gestionar+pro.getEmail());
		
		req.getSession().setAttribute("docencia", docencia);
		req.getSession().setAttribute("profesor", pro);
		req.getSession().setAttribute("coordinador", asignatura.getCoordinadorEmail());
		req.getSession().setAttribute("asignatura", asignatura);
		resp.sendRedirect(req.getContextPath() + "/VerMisHoras.jsp");

		
		

	}

}
