package es.upm.dit.isst.web.dao;

import java.util.List;
import es.upm.dit.isst.web.dao.model.Profesor;

public interface ProfesorDAO {
	
	public Profesor loginProfesor( String email, String password );
	public List<Profesor> readAllProfessor( );
	public void createProfessor( Profesor professor );
	public Profesor readProfessor( String email );
	public void updateProfessor( Profesor professor );
	public void deleteProfessor( Profesor professor );
}