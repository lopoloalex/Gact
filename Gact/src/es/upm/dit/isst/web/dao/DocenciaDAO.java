package es.upm.dit.isst.web.dao;

import java.util.List;

import es.upm.dit.isst.web.dao.model.Docencia;
import es.upm.dit.isst.web.dao.model.ReconoceProfesor;


public interface DocenciaDAO {
	
	public List<Docencia> readAllDepartamentos( );
	public void createDocencia( Docencia docencia );
	public Docencia readDocencia(  ReconoceProfesor docencia );
	public void updateDocencia( Docencia docencia );
	public void deleteDocencia( Docencia docencia );

}
