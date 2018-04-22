package es.upm.dit.isst.web.dao;

import java.util.List;

import es.upm.dit.isst.web.dao.model.Asignatura;
import es.upm.dit.isst.web.dao.model.Profesor;

public interface AsignaturaDAO {

	public List<Asignatura> readAllAsignatura( );
	public Asignatura readAsignatura( int asignaturaID );
	public void createAsignatura( Asignatura asignatura );
	public void updateAsignatura( Asignatura asignatura );
	public void deleteAsignatura( Asignatura asignatura );
	
}
