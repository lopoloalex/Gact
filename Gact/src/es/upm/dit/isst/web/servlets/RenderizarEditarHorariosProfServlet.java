package es.upm.dit.isst.web.servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.web.dao.DocenciaDAOImplementation;
import es.upm.dit.isst.web.dao.model.Docencia;


@WebServlet("/RenderizarEditarHorariosProfServlet")
public class RenderizarEditarHorariosProfServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String docenciaID = req.getParameter("docenciaID");
		Docencia docencia = DocenciaDAOImplementation.getInstance().readDocencia(docenciaID);
		
		
		req.getSession().setAttribute("docencia", docencia);
		resp.sendRedirect(req.getContextPath()+"/EditarHorariosProf.jsp");	

	}

}
