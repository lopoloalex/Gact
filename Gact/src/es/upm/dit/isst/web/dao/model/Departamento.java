package es.upm.dit.isst.web.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Departamento implements Serializable {

	@Id
	private int departamentoID;
	private String nombre;
	private String responsableEmail;
	@OneToMany(mappedBy="departamento",fetch=FetchType.EAGER ,cascade={ CascadeType.MERGE, CascadeType.PERSIST} )
	private Set<Profesor> profesoresDepartamento;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="departamentoA",cascade={ CascadeType.MERGE, CascadeType.PERSIST}) 
	private Set<Asignatura> asignaturasDepartamento;
	

	
	public Departamento() {
		this.asignaturasDepartamento=new HashSet<Asignatura>();
		this.profesoresDepartamento=new HashSet<Profesor>();
		
	}
	public int getDepartamentoID() {
		return departamentoID;
	}
	public void setDepartamentoID(int departamentoID) {
		this.departamentoID = departamentoID;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getResponsableEmail() {
		return responsableEmail;
	}
	public void setResponsableEmail(String responsableEmail) {
		this.responsableEmail = responsableEmail;
	}
	public Set<Profesor> getProfesoresDepartamento() {
		return profesoresDepartamento;
	}
	public void setProfesoresDepartamento(Set<Profesor> profesoresDepartamento) {
		this.profesoresDepartamento = profesoresDepartamento;
	}
	public Set<Asignatura> getAsignaturasDepartamento() {
		return asignaturasDepartamento;
	}
	public void setAsignaturasDepartamento(Set<Asignatura> asignaturasDepartamento) {
		this.asignaturasDepartamento = asignaturasDepartamento;
	}

}
