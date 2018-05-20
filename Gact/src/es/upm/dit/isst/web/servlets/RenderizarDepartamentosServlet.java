package es.upm.dit.isst.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.web.dao.DepartamentoDAOImplementation;
@WebServlet("/RenderizarDepartamentosServlet")
public class RenderizarDepartamentosServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		
		req.getSession().setAttribute("departamento_list", DepartamentoDAOImplementation.getInstance().readAllDepartamentos());

		
		resp.sendRedirect(req.getContextPath() + "/CrearDepartamento.jsp");

		
	}
		

}
