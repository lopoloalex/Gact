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


@WebServlet("/EditarHorariosProfServlet")
public class EditarHorariosProfServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException { 

		String docenciaID = req.getParameter("docencia");
		Docencia docencia = DocenciaDAOImplementation.getInstance().readDocencia(docenciaID);
		
		String asig = req.getParameter("asignatura");
		int id = Integer.parseInt(asig);

		String horasA = req.getParameter("horasA");
		Double A = Double.parseDouble(horasA);
		String horasB = req.getParameter("horasB");
		Double B = Double.parseDouble(horasB);
		String horasC = req.getParameter("horasC");
		Double C = Double.parseDouble(horasC);
		
		Profesor profesor = ProfesorDAOImplementation.getInstance().readProfessor(docencia.getProfesorID().getEmail());
		Asignatura asignatura= AsignaturaDAOImplementation.getInstance().readAsignatura(id);
		
		docencia.setHorasA(A);
		docencia.setHorasB(B);
		docencia.setHorasC(C);
		
		List<Docencia> listaDocencia = profesor.getDocenciasImpartidas();
		listaDocencia.remove(docencia);
		listaDocencia.add(docencia);
		profesor.setDocenciasImpartidas(listaDocencia);
		
		List<Docencia> listaDoncenciaAsig =asignatura.getDocencias();
		listaDoncenciaAsig.remove(docencia);
		listaDoncenciaAsig.add(docencia);
		asignatura.setDocencias(listaDoncenciaAsig);
		
		DocenciaDAOImplementation.getInstance().updateDocencia(docencia);
		
		req.getSession().setAttribute("docencia", docencia);

		resp.sendRedirect(req.getContextPath()+"/EditarHorariosProf.jsp");	
		
	}
}