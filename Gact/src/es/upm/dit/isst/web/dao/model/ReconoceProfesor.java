package es.upm.dit.isst.web.dao.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class ReconoceProfesor implements Serializable {
	
	private String email;
	private Long asignaturaID;
	
	public ReconoceProfesor() {
		
	}
	
	public ReconoceProfesor (String email, Long asignaturaID) {
		this.email=email;
		this.asignaturaID=asignaturaID;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public Long getAsignaturaID() {
		return this.asignaturaID;
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReconoceProfesor)) return false;
        ReconoceProfesor that = (ReconoceProfesor) o;
        return Objects.equals(getEmail(), that.getEmail()) &&
                Objects.equals(getAsignaturaID(), that.getAsignaturaID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail(), getAsignaturaID());
    }

}
