
package es.upm.dit.isst.web.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.web.dao.AsignaturaDAO;
import es.upm.dit.isst.web.dao.AsignaturaDAOImplementation;
import es.upm.dit.isst.web.dao.DepartamentoDAOImplementation;
import es.upm.dit.isst.web.dao.ProfesorDAOImplementation;
import es.upm.dit.isst.web.dao.model.Asignatura;
import es.upm.dit.isst.web.dao.model.Departamento;
import es.upm.dit.isst.web.dao.model.Profesor;

@WebServlet("/BorrarAsignaturaServlet")
public class BorrarAsignaturaServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException { 

		String id = req.getParameter("id");
		System.out.println(id);
		int asignaturaID = Integer.parseInt(id);
		Asignatura aborrar = AsignaturaDAOImplementation.getInstance().readAsignatura(asignaturaID);
		AsignaturaDAO dao = AsignaturaDAOImplementation.getInstance();
		dao.deleteAsignatura(aborrar);
		
		Departamento departamento = aborrar.getDepartamento();
		List<Asignatura> asignaturas  = departamento.getAsignaturasDepartamento();
		asignaturas.remove(aborrar);
		departamento.setAsignaturasDepartamento(asignaturas);
		
		req.getSession().setAttribute("asignaturas", new ArrayList<Asignatura>(asignaturas));
		req.getSession().setAttribute("asignaturas_lista", AsignaturaDAOImplementation.getInstance().readAllAsignatura());
		

		resp.sendRedirect(req.getContextPath()+"/MisAsignaturas.jsp");	
		
	}

}