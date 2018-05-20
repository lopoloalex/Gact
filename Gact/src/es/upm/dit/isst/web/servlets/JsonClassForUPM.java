package es.upm.dit.isst.web.servlets;




import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.*;
import org.json.simple.*;
import org.json.simple.parser.*;

import es.upm.dit.isst.web.dao.AsignaturaDAOImplementation;
import es.upm.dit.isst.web.dao.DepartamentoDAOImplementation;
import es.upm.dit.isst.web.dao.PlanDeEstudioDAOImplementation;
import es.upm.dit.isst.web.dao.ProfesorDAOImplementation;
import es.upm.dit.isst.web.dao.model.Asignatura;
import es.upm.dit.isst.web.dao.model.Departamento;
import es.upm.dit.isst.web.dao.model.PlanDeEstudio;
import es.upm.dit.isst.web.dao.model.Profesor;




@WebServlet("/JsonClassForUPM")
public class JsonClassForUPM extends HttpServlet{

	private List<Integer> codigoDB = new ArrayList<Integer>();
	private List<String> acronimoDB = new ArrayList<String>();
	private List<String> coordinadorDB = new ArrayList<String>();
	private List<Double> creditosDB = new ArrayList<Double>();
	private List<String> asignaturaDB = new ArrayList<String>();
	
	private List<Integer> cursoDB = new ArrayList<Integer>();
	private List<Integer> departamentoDB = new ArrayList<Integer>();
	private String departamentoString = "";

	private List<Integer> semestreDB = new ArrayList<Integer>();
	private List<String> titulacion = new ArrayList<String>();
	private List<String> semestre= new ArrayList<String>();



	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException { 

		PlanDeEstudio plan = new PlanDeEstudio();
		plan.setAcronimo("GITSIT");
		plan.setName("Grado en Ingeniería y Servicios de Telecomunicación");
		PlanDeEstudioDAOImplementation.getInstance().createPlanDeEstudio(plan);
		
		JSONParser parser = new JSONParser();

		try {

			Object obj = parser.parse(new FileReader("/home/isst/git/Gact/Gact/WebContent/Asignaturas.json"));


			JSONObject jsonObject = (JSONObject) obj;

			//String titulacion = (String) jsonObject.get("codigo_plan");

			JSONObject datos = (JSONObject) jsonObject.get("datos");
			for(Object key : datos.keySet()) {

				JSONObject asignatura = (JSONObject) datos.get(key);

				String nombreAsignatura = (String)asignatura.get("nombre");
				String cursoAsignatura = (String)asignatura.get("curso");
				String numerosb = (String)asignatura.get("codigo");
				
				String acronimoAsignatura = ((String)asignatura.get("nombre")).substring(0,4);
				String numeroCreditos = (String)asignatura.get("credects");


				if (numerosb != "905000001" || numerosb != "95000082" || numerosb != "95000085"|| numerosb != "95000194" 
						|| numerosb != "95000195" || numerosb != "95000196" || numerosb != "95000197" 
						|| numerosb != "95000200" || numerosb != "95000201" || numerosb != "95000202" || numerosb != "95000203"
						|| numerosb != "95000204" || numerosb != "95000205" || numerosb != "95000206" || numerosb != "95000207"
						|| numerosb != "95000208" || numerosb != "95000212" || numerosb != "95000213" || numerosb != "95000092"
						|| numerosb != "95000214" || numerosb != "95000215" || numerosb != "95000216" || numerosb != "95000217") {

					asignaturaDB.add(nombreAsignatura);
					acronimoDB.add(acronimoAsignatura);
					coordinadorDB.add("");

					double creditos = Double.parseDouble(numeroCreditos);
					creditosDB.add(creditos);

					int asignaturaID = Integer.parseInt(numerosb);
					codigoDB.add(asignaturaID);

					if(cursoAsignatura.equals("")) {
						cursoDB.add(0);
					}
					else {
						int ncurso;
						ncurso = Integer.parseInt(cursoAsignatura);
						cursoDB.add(ncurso);
					}

					Object impart = asignatura.get("imparticion");
					if (impart instanceof JSONObject) {
						JSONObject imparticion = (JSONObject) impart;
						for(Object semestres : imparticion.keySet()) {

							String semestreAsignatura = ((String)semestres);
							String sem = semestreAsignatura.substring(0,1);
							if (!semestreAsignatura.equals("I") || !sem.equals("I")) {
								int semestr;
								try {
									semestr = Integer.parseInt(sem);
									semestreDB.add(semestr);
									System.out.println("semestreAsignatura: " + semestreAsignatura + ", Sem: " + sem);
								}
								catch (NumberFormatException e) {
								}

							}
							else {
								semestreDB.add(0);
							}

						}
					}
					else {
						semestreDB.add(0);
					}

					JSONArray departamento = (JSONArray)asignatura.get("departamentos");
					if (departamento.size() != 0) {

						JSONObject object = (JSONObject) departamento.get(0);
						String idDep = ((String)object.get("codigo_departamento")).substring(1, 4);
						try {
							int id;
							id = Integer.parseInt(idDep);
							
							departamentoDB.add(id);
							
							System.out.println(id);
							
						}
						catch (NumberFormatException e) {
						}

					}


				}

			}
			
			Departamento nuevoDepartamentoAux = new Departamento();
			nuevoDepartamentoAux.setDepartamentoID(0);
			nuevoDepartamentoAux.setNombre("N/D");
			DepartamentoDAOImplementation.getInstance().createDepartamento(nuevoDepartamentoAux);


			for(int i = 0 ;i<asignaturaDB.size(); i++) {
				
				Asignatura nuevaAsignatura = new Asignatura();
				
				nuevaAsignatura.setName(asignaturaDB.get(i));
				nuevaAsignatura.setAcronimo(acronimoDB.get(i));
				nuevaAsignatura.setCoordinadorEmail("");
				nuevaAsignatura.setCreditos(creditosDB.get(i));
				nuevaAsignatura.setAsignaturaID(codigoDB.get(i));

				nuevaAsignatura.setDepartamento(nuevoDepartamentoAux);
				nuevaAsignatura.setHorasTotalesA(0.0);
				nuevaAsignatura.setHorasTotalesB(0.0);
				nuevaAsignatura.setHorasTotalesC(0.0);
				nuevaAsignatura.setnGrupos(0);
				nuevaAsignatura.setSemestre(semestreDB.get(i));
				nuevaAsignatura.setPlanDeEstudio(plan);
				nuevaAsignatura.setCurso(cursoDB.get(i));
				
				AsignaturaDAOImplementation.getInstance().createAsignatura(nuevaAsignatura);


			}
			

			Departamento nuevoDepartamento1 = new Departamento();
			nuevoDepartamento1.setDepartamentoID(540);
			nuevoDepartamento1.setNombre("MAT");
			
			Departamento nuevoDepartamento2 = new Departamento();
			nuevoDepartamento2.setDepartamentoID(510);
			nuevoDepartamento2.setNombre("FIS");
			
			Departamento nuevoDepartamento3 = new Departamento();
			nuevoDepartamento3.setDepartamentoID(520);
			nuevoDepartamento3.setNombre("DIT");
			
			Departamento nuevoDepartamento4 = new Departamento();
			nuevoDepartamento4.setDepartamentoID(550);
			nuevoDepartamento4.setNombre("SSR");
			
			Departamento nuevoDepartamento5 = new Departamento();
			nuevoDepartamento5.setDepartamentoID(530);
			nuevoDepartamento5.setNombre("DIE");
			
			Departamento nuevoDepartamento6 = new Departamento();
			nuevoDepartamento6.setDepartamentoID(400);
			nuevoDepartamento6.setNombre("EMPRESA");
			
			Departamento nuevoDepartamento7 = new Departamento();
			nuevoDepartamento7.setDepartamentoID(560);
			nuevoDepartamento7.setNombre("FOTONICA");
			
			Departamento nuevoDepartamento8 = new Departamento();
			nuevoDepartamento8.setDepartamentoID(240);
			nuevoDepartamento8.setNombre("INGLÉS");
			
			
			
			DepartamentoDAOImplementation.getInstance().createDepartamento(nuevoDepartamento1);
			DepartamentoDAOImplementation.getInstance().createDepartamento(nuevoDepartamento2);
			DepartamentoDAOImplementation.getInstance().createDepartamento(nuevoDepartamento3);
			DepartamentoDAOImplementation.getInstance().createDepartamento(nuevoDepartamento4);
			DepartamentoDAOImplementation.getInstance().createDepartamento(nuevoDepartamento5);
			DepartamentoDAOImplementation.getInstance().createDepartamento(nuevoDepartamento6);
			DepartamentoDAOImplementation.getInstance().createDepartamento(nuevoDepartamento7);
			DepartamentoDAOImplementation.getInstance().createDepartamento(nuevoDepartamento8);
			
			
			req.getSession().setAttribute("departamentos_lista", DepartamentoDAOImplementation.getInstance().readAllDepartamentos());
			req.getSession().setAttribute("asignaturas_lista", AsignaturaDAOImplementation.getInstance().readAllAsignatura());
			resp.sendRedirect(req.getContextPath()+"/RootAdministrar.jsp");	

			

		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}