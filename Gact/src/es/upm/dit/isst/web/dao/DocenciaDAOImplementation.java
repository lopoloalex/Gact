package es.upm.dit.isst.web.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.web.dao.model.Docencia;

public class DocenciaDAOImplementation implements DocenciaDAO {
	
	private static DocenciaDAOImplementation instancia = null;
	private DocenciaDAOImplementation () {}
	public static DocenciaDAOImplementation getInstance(){
		if ( null == instancia ) {
			instancia = new DocenciaDAOImplementation ();
		}
		return instancia;
	}

	@Override
	public List<Docencia> readAllDocencia() {
		Session session = SessionFactoryService.get().openSession();
		List<Docencia> docencia = new ArrayList<>(); 
		try {
			session.beginTransaction();
			docencia.addAll(session.createQuery("select t from Docencia t").getResultList());
			session.getTransaction().commit();
		}
		catch (Exception e){

		}
		finally {
			session.close();
		}
		return docencia;
	}

	@Override
	public void createDocencia(Docencia docencia) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(docencia);
			session.getTransaction().commit();
		}
		catch (Exception e){

		}
		finally {
			session.close();
		}		
	}

	@Override
	public Docencia readDocencia(String docencia) {
		Session session = SessionFactoryService.get().openSession();
		Docencia docen = null;
		try {
			docen = session.get(Docencia.class, docencia);
		}
		catch (Exception e){

		}
		finally {
			session.close();
		}
		return docen;
	}

	@Override
	public void updateDocencia(Docencia docencia) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(docencia);
			session.getTransaction().commit();
		}
		catch (Exception e){

		}
		finally {
			session.close();
		}			
	}

	@Override
	public void deleteDocencia(Docencia docencia) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(docencia);
			session.getTransaction().commit();
		}
		catch (Exception e){

		}
		finally {
			session.close();
		}		
	}		
	

}
