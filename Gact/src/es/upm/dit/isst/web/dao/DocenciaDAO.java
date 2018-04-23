package es.upm.dit.isst.web.dao;

import java.util.List;

import es.upm.dit.isst.web.dao.model.Docencia;


public interface DocenciaDAO {
	
	public List<Docencia> readAllDocencia( );
	public void createDocencia( Docencia docencia );
	public Docencia readDocencia(  String docencia );
	public void updateDocencia( Docencia docencia );
	public void deleteDocencia( Docencia docencia );

}
