package es.upm.dit.isst.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.web.util.EmailHandler;

@WebServlet("/ReclamarServlet")
public class ReclamarServlet extends HttpServlet{

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException { 
		String emailProfesor = req.getParameter("profesor");
		String emailCoordinador = req.getParameter("coordinador");
		String asignatura = req.getParameter("asignaturaP");
						
		String motivo = "Reclamacion horarios " + asignatura;
		String mensaje = "Hay un problema con mis horarios de la asignatura " + asignatura;
			
		EmailHandler email = new EmailHandler();
		email.sendEmail(emailProfesor, emailCoordinador,motivo, mensaje);
		
		resp.sendRedirect(req.getContextPath()+"/VerMisHoras.jsp");

		
	}


}
