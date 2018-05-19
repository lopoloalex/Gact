package es.upm.dit.isst.web.dao.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.*;

@Entity
public class Asignatura implements Serializable {

	@Id
	private int asignaturaID;
	private String name;
	private String acronimo;
	private int nGrupos;
	private int semestre;
	private int curso;
	private double creditos;
	private String coordinadorEmail;
	@ManyToOne
	private Departamento departamentoA;
	private double horasTotalesA;
	private double horasTotalesB;
	private double horasTotalesC;
	@ManyToMany (fetch=FetchType.EAGER,mappedBy="asignaturasImpartidas",cascade= { CascadeType.MERGE, CascadeType.PERSIST})
	private Set<Profesor> profesoresAsignatura;
	@OneToMany (fetch=FetchType.EAGER,mappedBy="asignaturaID1")
	private Set<Docencia> docencias;
	@ManyToOne
	private PlanDeEstudio planDeEstudio;
	
	public Asignatura() {
		this.profesoresAsignatura=new HashSet<Profesor>();
		this.docencias = new HashSet<Docencia>();
	}
	
	public Set<Docencia> getDocencias() {
		return docencias;
	}
	public void setDocencias(Set<Docencia> docencias) {
		this.docencias = docencias;
	}

	public int getAsignaturaID() {
		return asignaturaID;
	}
	public void setAsignaturaID(int asignaturaID) {
		this.asignaturaID = asignaturaID;
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

	public double getCreditos() {
		return creditos;
	}

	public void setCreditos(double creditos) {
		this.creditos = creditos;
	}
	public String getCoordinadorEmail() {
		return coordinadorEmail;
	}
	public void setCoordinadorEmail(String coordinadorEmail) {
		this.coordinadorEmail = coordinadorEmail;
	}
	public Departamento getDepartamento() {
		return departamentoA;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamentoA = departamento;
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
	public Set<Profesor> getProfesoresAsignatura() {
		return profesoresAsignatura;
	}
	public void setProfesoresAsignatura(Set<Profesor> profesoresAsignatura) {
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

	public PlanDeEstudio getPlanDeEstudio() {
		return planDeEstudio;
	}

	public void setPlanDeEstudio(PlanDeEstudio planDeEstudio) {
		this.planDeEstudio = planDeEstudio;
	}

	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
		this.curso = curso;
	}
	
	
}
