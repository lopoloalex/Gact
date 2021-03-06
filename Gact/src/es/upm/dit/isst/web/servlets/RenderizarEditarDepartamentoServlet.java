package es.upm.dit.isst.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.web.dao.DepartamentoDAOImplementation;
import es.upm.dit.isst.web.dao.model.Departamento;

@WebServlet("/RenderizarEditarDepartamentoServlet")
public class RenderizarEditarDepartamentoServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String gestionar = req.getParameter("departamento");
		int departamentoID = Integer.parseInt(gestionar);
		Departamento departamento = DepartamentoDAOImplementation.getInstance().readDepartamento(departamentoID);

		
		req.getSession().setAttribute("departamento", departamento);

		
		resp.sendRedirect(req.getContextPath() + "/EditarDepartamento.jsp");

	}

}
