package es.upm.dit.isst.web.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.web.dao.AsignaturaDAO;
import es.upm.dit.isst.web.dao.AsignaturaDAOImplementation;
import es.upm.dit.isst.web.dao.DepartamentoDAOImplementation;
import es.upm.dit.isst.web.dao.DocenciaDAOImplementation;
import es.upm.dit.isst.web.dao.ProfesorDAOImplementation;
import es.upm.dit.isst.web.dao.model.Asignatura;
import es.upm.dit.isst.web.dao.model.Departamento;
import es.upm.dit.isst.web.dao.model.Docencia;
import es.upm.dit.isst.web.dao.model.Profesor;

@WebServlet("/BorrarAsignaturaServlet")
public class BorrarAsignaturaServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException { 

		String borrar = req.getParameter("asignaturaABorrar");
		int id = Integer.parseInt(borrar);
//		
//		//asignatura a borrar
		Asignatura aborrar = AsignaturaDAOImplementation.getInstance().readAsignatura(id);
//		//dao de la asignatura a borrar
		AsignaturaDAO dao = AsignaturaDAOImplementation.getInstance();
//		
//		//borramos la asignatura de la lista de asignaturas del departamento
//		Departamento departamento = aborrar.getDepartamento();
//		Set<Asignatura> asignaturas  = departamento.getAsignaturasDepartamento();
//		asignaturas.remove(aborrar);
//		departamento.setAsignaturasDepartamento(asignaturas);
//				
//		//borramos todas las las docencias de esa asignatura en la lista del docencias de sus profesores
//		for (Profesor profesor: aborrar.getProfesoresAsignatura() ) {
//			Docencia docencia = DocenciaDAOImplementation.getInstance().readDocencia(aborrar.getAsignaturaID()+profesor.getEmail());
//			Set<Docencia> docenciasProfesorBorrar =profesor.getDocenciasImpartidas();
//			docenciasProfesorBorrar.remove(docencia);
//			profesor.setDocenciasImpartidas(docenciasProfesorBorrar);
//			ProfesorDAOImplementation.getInstance().updateProfessor(profesor);					
//		}
//		
//		
//		//Borramos todas las docencias impartidas en esa asignatura
//		Set<Docencia> docenciasaBorrar = aborrar.getDocencias();
//		for(Docencia docencia: docenciasaBorrar) {
//			DocenciaDAOImplementation.getInstance().deleteDocencia(docencia);
//		}
//		
		//FALTA  BORRAR ASIGNATURA EN LA LISTA DE PLAN DE ESTUDIO
		
		dao.deleteAsignatura(aborrar);
		//DepartamentoDAOImplementation.getInstance().updateDepartamento(departamento);

		
		req.getSession().setAttribute("asignaturas_lista", AsignaturaDAOImplementation.getInstance().readAllAsignatura());
		

		resp.sendRedirect(req.getContextPath()+"/Administrar.jsp");	
		
	}

}