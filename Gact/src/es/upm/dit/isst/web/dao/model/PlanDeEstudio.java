package es.upm.dit.isst.web.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
	
	@OneToMany (fetch=FetchType.EAGER,mappedBy="planDeEstudio")
	private List<Asignatura> asignaturasPlanEstudio;
	
	public PlanDeEstudio() {
		this.asignaturasPlanEstudio=new ArrayList<Asignatura>();
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

	public List<Asignatura> getAsignaturasPlanEstudio() {
		return asignaturasPlanEstudio;
	}

	public void setAsignaturasPlanEstudio(List<Asignatura> asignaturasPlanEstudio) {
		this.asignaturasPlanEstudio = asignaturasPlanEstudio;
	}
}
