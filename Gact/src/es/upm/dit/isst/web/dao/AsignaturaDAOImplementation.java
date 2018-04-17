package es.upm.dit.isst.web.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.web.dao.model.Asignatura;
import es.upm.dit.isst.web.dao.model.Profesor;

public class AsignaturaDAOImplementation {
	private static AsignaturaDAOImplementation instancia = null;
	private AsignaturaDAOImplementation () {}
	public static AsignaturaDAOImplementation getInstance(){
		if ( null == instancia ) {
			instancia = new AsignaturaDAOImplementation ();
		}
		return instancia;
	}
	
	
	
	public List<Asignatura> readAllAsignatura( ){

		Session session = SessionFactoryService.get().openSession();
		List<Asignatura> asigs = new ArrayList<>(); 
		try {
			session.beginTransaction();
			asigs.addAll(session.createQuery("select t from asigs t").getResultList());
			session.getTransaction().commit();
		}
		catch (Exception e){

		}
		finally {
			session.close();
		}
		return asigs;
	}
	
	public void createPAsignatura(Asignatura asig) {

		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(asig);
			session.getTransaction().commit();
		}
		catch (Exception e){

		}
		finally {
			session.close();
		}
	}

	public Asignatura readAsignatura(String asignaturaID) {

		Session session = SessionFactoryService.get().openSession();
		Asignatura asig = null;
		try {
			asig = session.get(Asignatura.class, asignaturaID);
		}
		catch (Exception e){

		}
		finally {
			session.close();
		}
		return asig;
	}
	
	public void updateAsignatura(Asignatura asig) {

		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(asig);
			session.getTransaction().commit();
		}
		catch (Exception e){

		}
		finally {
			session.close();
		}
	}
	
	public void deleteAsignatura(Asignatura asig) {

		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(asig);
			session.getTransaction().commit();
		}
		catch (Exception e){

		}
		finally {
			session.close();
		}
	}
}
