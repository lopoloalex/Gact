package es.upm.dit.isst.web.dao;

import java.util.List;

import es.upm.dit.isst.web.dao.model.Departamento;


public interface DepartamentoDAO {
	
	public List<Departamento> readAllDepartamentos( );
	public void createDepartamento( Departamento departamento );
	public Departamento readDepartamento( Long departamentoID );
	public void updateDepartamento( Departamento departamento );
	public void deleteDepartamento( Departamento departamento );

}
