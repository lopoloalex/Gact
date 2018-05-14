package es.upm.dit.isst.web.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import org.hibernate.Session;

import es.upm.dit.isst.web.dao.model.Asignatura;

import es.upm.dit.isst.web.dao.model.Profesor;

public class AsignaturaDAOImplementation implements AsignaturaDAO {
	
	
	private static AsignaturaDAOImplementation instancia = null;
	private AsignaturaDAOImplementation () {}
	public static AsignaturaDAOImplementation getInstance(){
		if ( null == instancia ) {
			instancia = new AsignaturaDAOImplementation ();
		}
		return instancia;
	}
	@Override
	public List<Asignatura> readAllAsignatura() {
		Session session = SessionFactoryService.get().openSession();
		List<Asignatura> asigs = new ArrayList<>(); 
		try {
			session.beginTransaction();
			asigs.addAll(session.createQuery("select t from Asignatura t").getResultList());
			session.getTransaction().commit();
		}
		catch (Exception e){

		}
		finally {
			session.close();
		}
		return asigs;
	}
	@Override
	public void createAsignatura(Asignatura asignatura) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(asignatura);
			session.getTransaction().commit();
		}
		catch (Exception e){

		}
		finally {
			session.close();
		}		
	}
	@Override
	public void updateAsignatura(Asignatura asignatura) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(asignatura);
			session.getTransaction().commit();
		}
		catch (Exception e){

		}
		finally {
			session.close();
		}		
	}
	
	@Override
	public void deleteAsignatura(Asignatura asignatura) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(asignatura);
			session.getTransaction().commit();
		}
		catch (Exception e){
			System.out.println(e.getMessage());

		}
		finally {
			session.close();
		}		
	}
	@Override
	public Asignatura readAsignatura(int asignaturaID) {
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

	
}
