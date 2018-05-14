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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Profesor implements Serializable{
	

	@Id
	private String email;
	private String password;
	private String name;
	@ManyToMany (fetch=FetchType.EAGER,cascade= { CascadeType.MERGE, CascadeType.PERSIST})
	private Set<Asignatura> asignaturasImpartidas;
	@ManyToOne
	private Departamento departamento;
	@OneToMany (fetch=FetchType.EAGER,mappedBy="profesorID",cascade= { CascadeType.MERGE, CascadeType.PERSIST})
	private Set<Docencia> docenciasImpartidas;
	
	public Profesor () {
		this.asignaturasImpartidas=new HashSet<Asignatura>();
		this.docenciasImpartidas = new HashSet<Docencia>();
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Asignatura> getAsignaturasImpartidas() {
		return asignaturasImpartidas;
	}
	public void setAsignaturasImpartidas(Set<Asignatura> asignaturasImpartidas) {
		this.asignaturasImpartidas = asignaturasImpartidas;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public Set<Docencia> getDocenciasImpartidas() {
		return docenciasImpartidas;
	}
	public void setDocenciasImpartidas(Set<Docencia> docenciasImpartidas) {
		this.docenciasImpartidas = docenciasImpartidas;
	}
	@Override
	public String toString() {
		return "Profesor [email=" + email + ", password=" + password + ", name=" + name + ", asignaturasImpartidas="
				+ asignaturasImpartidas + ", departamento=" + departamento + ", docenciasImpartidas="
				+ docenciasImpartidas + "]";
	}

}
