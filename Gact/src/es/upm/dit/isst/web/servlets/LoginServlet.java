package es.upm.dit.isst.web.servlets;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import es.upm.dit.isst.web.dao.DepartamentoDAOImplementation;
import es.upm.dit.isst.web.dao.ProfesorDAOImplementation;
import es.upm.dit.isst.web.dao.model.Asignatura;
import es.upm.dit.isst.web.dao.model.Departamento;
import es.upm.dit.isst.web.dao.model.Profesor;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private final String ADMIN_EMAIL = "root";
	private final String ADMIN_PASSWORD = "root";
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");
		Profesor profesor = ProfesorDAOImplementation.getInstance().loginProfesor(email, password);
		
		if(req.getSession().getAttribute("isResponsable") == null) {
			req.getSession().setAttribute("isResponsable", false);
		}
		
		if(req.getSession().getAttribute("isCoordinador") == null) {
			req.getSession().setAttribute("isCoordinador", false);
		}
		
		if( ADMIN_EMAIL.equals(email) && ADMIN_PASSWORD.equals(password) ) {

			req.getSession().setAttribute("adminLogged", true);
			
			req.getSession().setAttribute("departamento_list", DepartamentoDAOImplementation.getInstance().readAllDepartamentos());

			resp.sendRedirect(req.getContextPath() + "/CrearDepartamento.jsp");

		} else if ( profesor != null ) {
			req.getSession().setAttribute("isResponsable", false);
			req.getSession().setAttribute("isCoordinador", false);
    		req.getSession().setAttribute("adminLogged", false);
    		
        	// El usuario está logeado
        	Departamento departamento = profesor.getDepartamento();
        	Set<Asignatura> asignaturas = departamento.getAsignaturasDepartamento();
        	
        	// El profesor es responsable del departamento
        	if(profesor.getEmail() == departamento.getResponsableEmail()) {
        		req.getSession().setAttribute("isResponsable", true);
        	}
        	
        	// El profesor es coordinador de asignatura
        	for(Asignatura asignatura : asignaturas) {
        		if(profesor.getEmail() == asignatura.getCoordinadorEmail()) {
        			req.getSession().setAttribute("isCoordinador", true);
        			break;
        		}
        	}
        	
			req.getSession().setAttribute("profesor", profesor);
			resp.sendRedirect(req.getContextPath() + "/LoginProfesor.jsp");

		} else {

			resp.sendRedirect(req.getContextPath() + "/FormLogin.jsp");
		
		}

	}

}