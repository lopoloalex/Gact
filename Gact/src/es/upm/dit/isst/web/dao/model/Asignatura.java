package es.upm.dit.isst.web.dao.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.*;

@Entity
public class Asignatura implements Serializable {

	@Id
	private int asignaturaID;
	private String titulacion;
	private String name;
	private String acronimo;
	private int nGrupos;
	private int semestre;
	private int creditos;
	private String coordinadorEmail;
	@ManyToOne
	private Departamento departamento;
	private double horasTotalesA;
	private double horasTotalesB;
	private double horasTotalesC;
	@ManyToMany (fetch=FetchType.EAGER,mappedBy="asignaturasImpartidas",cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Profesor> profesoresAsignatura;
	@OneToMany (fetch=FetchType.EAGER,mappedBy="asignaturaID",cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Docencia> docencias;
	
	public Asignatura() {
		this.profesoresAsignatura=new ArrayList<Profesor>();
		this.docencias = new ArrayList<Docencia>();
	}
	
	public List<Docencia> getDocencias() {
		return docencias;
	}
	public void setDocencias(List<Docencia> docencias) {
		this.docencias = docencias;
	}

	public int getAsignaturaID() {
		return asignaturaID;
	}
	public void setAsignaturaID(int asignaturaID) {
		this.asignaturaID = asignaturaID;
	}
	public String getTitulacion() {
		return titulacion;
	}
	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}
	public int getnGrupos() {
		return nGrupos;
	}
	public void setnGrupos(int nGrupos) {
		this.nGrupos = nGrupos;
	}
	public int getSemestre() {
		return semestre;
	}
	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
	public int getCreditos() {
		return creditos;
	}
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	public String getCoordinadorEmail() {
		return coordinadorEmail;
	}
	public void setCoordinadorEmail(String coordinadorEmail) {
		this.coordinadorEmail = coordinadorEmail;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public double getHorasTotalesA() {
		return horasTotalesA;
	}
	public void setHorasTotalesA(double horasTotalesA) {
		this.horasTotalesA = horasTotalesA;
	}
	public double getHorasTotalesB() {
		return horasTotalesB;
	}
	public void setHorasTotalesB(double horasTotalesB) {
		this.horasTotalesB = horasTotalesB;
	}
	public double getHorasTotalesC() {
		return horasTotalesC;
	}
	public void setHorasTotalesC(double horasTotalesC) {
		this.horasTotalesC = horasTotalesC;
	}
	public List<Profesor> getProfesoresAsignatura() {
		return profesoresAsignatura;
	}
	public void setProfesoresAsignatura(List<Profesor> profesoresAsignatura) {
		this.profesoresAsignatura = profesoresAsignatura;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAcronimo() {
		return acronimo;
	}
	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
	}
	
	
}
