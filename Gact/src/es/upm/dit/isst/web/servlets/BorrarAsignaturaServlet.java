
package es.upm.dit.isst.web.servlets;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.web.dao.AsignaturaDAO;
import es.upm.dit.isst.web.dao.AsignaturaDAOImplementation;
import es.upm.dit.isst.web.dao.model.Asignatura;
import es.upm.dit.isst.web.dao.model.Departamento;

@WebServlet("/BorrarAsignaturaServlet")
public class BorrarAsignaturaServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException { 

		String borrar = req.getParameter("asignaturaABorrar");
		int id = Integer.parseInt(borrar);
		Asignatura aborrar = AsignaturaDAOImplementation.getInstance().readAsignatura(id);
		AsignaturaDAO dao = AsignaturaDAOImplementation.getInstance();
		
		
		Departamento departamento = aborrar.getDepartamento();
		List<Asignatura> asignaturas  = departamento.getAsignaturasDepartamento();
		asignaturas.remove(aborrar);
		departamento.setAsignaturasDepartamento(asignaturas);
		dao.deleteAsignatura(aborrar);
		
		req.getSession().setAttribute("asignaturas_lista", AsignaturaDAOImplementation.getInstance().readAllAsignatura());
		

		resp.sendRedirect(req.getContextPath()+"/Administrar.jsp");	
		
	}

}