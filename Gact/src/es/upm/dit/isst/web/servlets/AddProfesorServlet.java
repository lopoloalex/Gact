package es.upm.dit.isst.web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.web.dao.AsignaturaDAOImplementation;
import es.upm.dit.isst.web.dao.DocenciaDAOImplementation;
import es.upm.dit.isst.web.dao.ProfesorDAOImplementation;
import es.upm.dit.isst.web.dao.model.Asignatura;
import es.upm.dit.isst.web.dao.model.Docencia;
import es.upm.dit.isst.web.dao.model.Profesor;


@WebServlet("/AddProfesorServlet")
public class AddProfesorServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException { 

		
		String asig = req.getParameter("asignatura");
		int id = Integer.parseInt(asig);

		String email = req.getParameter("email");
		String horasA = req.getParameter("horasA");
		int A = Integer.parseInt(horasA);
		String horasB = req.getParameter("horasB");
		int B = Integer.parseInt(horasB);
		String horasC = req.getParameter("horasC");
		int C = Integer.parseInt(horasC);
		
		Profesor profesor = ProfesorDAOImplementation.getInstance().readProfessor(email);
		Asignatura asignatura= AsignaturaDAOImplementation.getInstance().readAsignatura(id);
		

		List<Asignatura> a = profesor.getAsignaturasImpartidas();
		a.add(asignatura);
		profesor.setAsignaturasImpartidas(a);
		
		List<Profesor> b =asignatura.getProfesoresAsignatura();
		b.add(profesor);
		asignatura.setProfesoresAsignatura(b);
		
		
		ProfesorDAOImplementation.getInstance().updateProfessor(profesor);
		AsignaturaDAOImplementation.getInstance().updateAsignatura(asignatura);
		
		Docencia docencia = new Docencia();
		

		
		String claveDocencia = asig+email;
		
		
		docencia.setDocencia(claveDocencia);
		docencia.setHorasA(A);
		docencia.setHorasB(B);
		docencia.setHorasC(C);
		
	


		
		DocenciaDAOImplementation.getInstance().createDocencia(docencia);
		System.out.println(DocenciaDAOImplementation.getInstance().readDocencia(claveDocencia));
		
		req.getSession().setAttribute("asignatura", asignatura);

		resp.sendRedirect(req.getContextPath()+"/AddProfesor.jsp");	

		
		
		
		
	}







}
