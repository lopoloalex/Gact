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
public class PlanDeEstudio implements Serializable {
	
	@Id
	private String acronimo;
	private String name;
	
	@OneToMany (fetch=FetchType.EAGER,mappedBy="planDeEstudio",cascade= { CascadeType.MERGE, CascadeType.PERSIST})
	private Set<Asignatura> asignaturasPlanEstudio;
	
	public PlanDeEstudio() {
		this.asignaturasPlanEstudio=new HashSet<Asignatura>();
	}

	public String getAcronimo() {
		return acronimo;
	}

	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Asignatura> getAsignaturasPlanEstudio() {
		return asignaturasPlanEstudio;
	}

	public void setAsignaturasPlanEstudio(Set<Asignatura> asignaturasPlanEstudio) {
		this.asignaturasPlanEstudio = asignaturasPlanEstudio;
	}
}
