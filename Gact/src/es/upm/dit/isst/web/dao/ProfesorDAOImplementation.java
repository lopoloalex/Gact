package es.upm.dit.isst.web.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.web.dao.SessionFactoryService;
import es.upm.dit.isst.web.dao.model.Profesor;
import es.upm.dit.isst.web.dao.ProfesorDAOImplementation;

public class ProfesorDAOImplementation implements ProfesorDAO {
	
	private static ProfesorDAOImplementation instancia = null;
	private ProfesorDAOImplementation () {}
	public static ProfesorDAOImplementation getInstance(){
		if ( null == instancia ) {
			instancia = new ProfesorDAOImplementation ();
		}
		return instancia;
	}
	@Override
	public Profesor loginProfesor(String email, String password) {
		Profesor professor = null;
		Session session = SessionFactoryService.get().openSession();

		try {
			session.beginTransaction();
			professor = (Profesor) session
					.createQuery("select p from Profesor p where p.email= :email and p.password = :password")
					.setParameter("email", email)
					.setParameter("password", password)
					.uniqueResult();

			session.getTransaction().commit();
		}
		catch (Exception e){

		}
		finally {
			session.close();
		}
		return professor;
	}
	
	@Override
	public List<Profesor> readAllProfessor() {
		Session session = SessionFactoryService.get().openSession();
		List<Profesor> profs = new ArrayList<>(); 
		try {
			session.beginTransaction();
			profs.addAll(session.createQuery("select t from Profesor t").getResultList());
			session.getTransaction().commit();
		}
		catch (Exception e){

		}
		finally {
			session.close();
		}
		return profs;
	}
	@Override
	public void createProfessor(Profesor professor) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(professor);
			session.getTransaction().commit();
		}
		catch (Exception e){

		}
		finally {
			session.close();
		}		
	}
	@Override
	public Profesor readProfessor(String email) {
		Session session = SessionFactoryService.get().openSession();
		Profesor prof = null;
		try {
			prof = session.get(Profesor.class, email);
		}
		catch (Exception e){

		}
		finally {
			session.close();
		}
		return prof;
	}
	@Override
	public void updateProfessor(Profesor professor) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(professor);
			session.getTransaction().commit();
		}
		catch (Exception e){

		}
		finally {
			session.close();
		}		
	}
	@Override
	public void deleteProfessor(Profesor professor) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(professor);
			session.getTransaction().commit();
		}
		catch (Exception e){

		}
		finally {
			session.close();
		}		
	}
	

	
}
