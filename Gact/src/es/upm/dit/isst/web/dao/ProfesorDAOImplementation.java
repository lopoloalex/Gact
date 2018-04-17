package es.upm.dit.isst.web.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.web.dao.SessionFactoryService;
import es.upm.dit.isst.web.dao.model.Profesor;
import es.upm.dit.isst.web.dao.ProfesorDAOImplementation;

public class ProfesorDAOImplementation {
	
	private static ProfesorDAOImplementation instancia = null;
	private ProfesorDAOImplementation () {}
	public static ProfesorDAOImplementation getInstance(){
		if ( null == instancia ) {
			instancia = new ProfesorDAOImplementation ();
		}
		return instancia;
	}
	
	public Profesor loginProfessor( String email, String password ) {
		Profesor professor = null;
		Session session = SessionFactoryService.get().openSession();

		try {
			session.beginTransaction();
			professor = (Profesor) session
					.createQuery("select p from Professor p where p.email= :email and p.password = :password")
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
	
	public List<Profesor> readAllProfessor( ){

		Session session = SessionFactoryService.get().openSession();
		List<Profesor> profs = new ArrayList<>(); 
		try {
			session.beginTransaction();
			profs.addAll(session.createQuery("select t from profs t").getResultList());
			session.getTransaction().commit();
		}
		catch (Exception e){

		}
		finally {
			session.close();
		}
		return profs;
	}
	
	public void createProfessor(Profesor prof) {

		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(prof);
			session.getTransaction().commit();
		}
		catch (Exception e){

		}
		finally {
			session.close();
		}
	}

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
	
	public void updateProfessor(Profesor prof) {

		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(prof);
			session.getTransaction().commit();
		}
		catch (Exception e){

		}
		finally {
			session.close();
		}
	}
	
	public void deleteProfessor(Profesor prof) {

		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(prof);
			session.getTransaction().commit();
		}
		catch (Exception e){

		}
		finally {
			session.close();
		}
	}
	
	
}
