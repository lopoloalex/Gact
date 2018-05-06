package es.upm.dit.isst.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.web.dao.DepartamentoDAOImplementation;
import es.upm.dit.isst.web.dao.ProfesorDAOImplementation;
import es.upm.dit.isst.web.dao.model.Departamento;
import es.upm.dit.isst.web.dao.model.Profesor;



@WebServlet("/CrearProfesorServlet")
public class CrearProfesorServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String departamentoIDS = req.getParameter("departamentoID");
		int departamentoID = Integer.parseInt(departamentoIDS);
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		
		Profesor profesor = new Profesor();
		
		profesor.setEmail(email);
		profesor.setName(name);
		profesor.setPassword(password);
		
		Departamento departamento = DepartamentoDAOImplementation.getInstance().readDepartamento(departamentoID);
		
		profesor.setDepartamento(departamento);
		
		
		departamento.getProfesoresDepartamento().add(profesor);
		
		ProfesorDAOImplementation.getInstance().createProfessor(profesor);
		DepartamentoDAOImplementation.getInstance().updateDepartamento(departamento);
		
		req.getSession().setAttribute("profesor_list", ProfesorDAOImplementation.getInstance().readAllProfessor());

		resp.sendRedirect(req.getContextPath() + "/CrearProfesor.jsp");
			
		
	}

}
