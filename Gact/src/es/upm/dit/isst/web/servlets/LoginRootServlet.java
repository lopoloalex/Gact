package es.upm.dit.isst.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.web.dao.DepartamentoDAOImplementation;
import es.upm.dit.isst.web.dao.model.Departamento;


@WebServlet("/LoginRootServlet")
public class LoginRootServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String departamentoIDS = req.getParameter("departamentoID");
		int departamentoID = Integer.parseInt(departamentoIDS);
		String nombre = req.getParameter("nombre");
		String responsableEmail = req.getParameter("responsableEmail");
		
		Departamento nuevoDepartamento = new Departamento();
		
		nuevoDepartamento.setDepartamentoID(departamentoID);
		nuevoDepartamento.setNombre(nombre);
		nuevoDepartamento.setResponsableEmail(responsableEmail);
		
		DepartamentoDAOImplementation.getInstance().createDepartamento(nuevoDepartamento);
		req.getSession().setAttribute("departamento_list", DepartamentoDAOImplementation.getInstance().readAllDepartamentos());

		resp.sendRedirect(req.getContextPath() + "/LoginRoot.jsp");
			
		
	}
	
	
	

}
