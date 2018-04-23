package es.upm.dit.isst.web.dao.model;

import java.io.Serializable;


import javax.persistence.*;

@Entity
public class Docencia implements Serializable {

	@Id
	private String docencia;
	private double horasA;
	private double horasB;
	private double horasC;
	@ManyToOne
	private Profesor profesorID;
	@ManyToOne
	private Asignatura asignaturaID;
	
	public Docencia() {
		
	}

	public String getDocencia() {
		return docencia;
	}

	public void setDocencia(String docencia) {
		this.docencia = docencia;
	}

	public double getHorasA() {
		return horasA;
	}

	public void setHorasA(double horasA) {
		this.horasA = horasA;
	}

	public double getHorasB() {
		return horasB;
	}

	public void setHorasB(double horasB) {
		this.horasB = horasB;
	}

	public double getHorasC() {
		return horasC;
	}

	public void setHorasC(double horasC) {
		this.horasC = horasC;
	}
	public Profesor getProfesorID() {
		return profesorID;
	}

	public void setProfesorID(Profesor profesorID) {
		this.profesorID = profesorID;
	}

	public Asignatura getAsignaturaID() {
		return asignaturaID;
	}

	public void setAsignaturaID(Asignatura asignaturaID) {
		this.asignaturaID = asignaturaID;
	}
}
