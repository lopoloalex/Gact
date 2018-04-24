package es.upm.dit.isst.web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import es.upm.dit.isst.web.dao.model.Departamento;
import es.upm.dit.isst.web.dao.model.Profesor;

@WebServlet("/RenderizarAdministrar")
public class RenderizarAdministrar extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Profesor pro= (Profesor) req.getSession().getAttribute("profesor");
		Departamento departamento = pro.getDepartamento();
		
		
		
		
		req.getSession().setAttribute("asignaturas_lista", departamento.getAsignaturasDepartamento());
		
		resp.sendRedirect(req.getContextPath() + "/Administrar.jsp");


		
		
	}
		

}