package es.upm.dit.isst.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.web.dao.DepartamentoDAOImplementation;
import es.upm.dit.isst.web.dao.model.Departamento;

@WebServlet("/EditarDepartamentoServlet")
public class EditarDepartamentoServlet extends HttpServlet{

		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException { 
			String departamentoNombre = req.getParameter("name");
			String coordinadorEmial = req.getParameter("coordinador");
			String departamentoIDs = req.getParameter("departamentoid");
			int departamentoID = Integer.parseInt(departamentoIDs);
			
			Departamento departamento = DepartamentoDAOImplementation.getInstance().readDepartamento(departamentoID);
			departamento.setNombre(departamentoNombre);
			departamento.setResponsableEmail(coordinadorEmial);
			DepartamentoDAOImplementation.getInstance().updateDepartamento(departamento);
			
			
			req.getSession().setAttribute("departamento_list", DepartamentoDAOImplementation.getInstance().readAllDepartamentos());

			resp.sendRedirect(req.getContextPath()+"/CrearDepartamento.jsp");	
		}

}
