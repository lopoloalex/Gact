package es.upm.dit.isst.web.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
	@ManyToMany (fetch=FetchType.EAGER,cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Asignatura> asignaturasImpartidas;
	@ManyToOne
	private Departamento departamento;
	@OneToMany (fetch=FetchType.EAGER,mappedBy="profesorID")
	private List<Docencia> docenciasImpartidas;
	
	public Profesor () {
		this.asignaturasImpartidas=new ArrayList<Asignatura>();
		this.docenciasImpartidas = new ArrayList<Docencia>();
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
	public List<Asignatura> getAsignaturasImpartidas() {
		return asignaturasImpartidas;
	}
	public void setAsignaturasImpartidas(List<Asignatura> asignaturasImpartidas) {
		this.asignaturasImpartidas = asignaturasImpartidas;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public List<Docencia> getDocenciasImpartidas() {
		return docenciasImpartidas;
	}
	public void setDocenciasImpartidas(List<Docencia> docenciasImpartidas) {
		this.docenciasImpartidas = docenciasImpartidas;
	}

}
