package es.upm.dit.isst.web.servlets;

import java.io.IOException;
import java.util.List;

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
		
		//asignamos los atributos del nuevo profesor
		Profesor profesor = new Profesor();
		profesor.setEmail(email);
		profesor.setName(name);
		profesor.setPassword(password);
		
		//leemos el departamento asignado al profesor
		Departamento departamento = DepartamentoDAOImplementation.getInstance().readDepartamento(departamentoID);
		
		//se lo asignamos
		profesor.setDepartamento(departamento);
		
		//Guardamos el nuevo profesor del departamento
//		List<Profesor> profesoresDepartamento =departamento.getProfesoresDepartamento();
//		profesoresDepartamento.add(profesor);
//		departamento.setProfesoresDepartamento(profesoresDepartamento);
	
		//Creamos el profesor y actualizamos el departamento
		ProfesorDAOImplementation.getInstance().createProfessor(profesor);
//		DepartamentoDAOImplementation.getInstance().updateDepartamento(departamento);
		
		req.getSession().setAttribute("profesor_list", ProfesorDAOImplementation.getInstance().readAllProfessor());

		resp.sendRedirect(req.getContextPath() + "/CrearProfesor.jsp");
			
		
	}

}
