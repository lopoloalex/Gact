package es.upm.dit.isst.web.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.web.dao.model.Departamento;

public class DepartamentoDAOImplementation implements DepartamentoDAO {
	
	
	private static DepartamentoDAOImplementation instancia = null;
	private DepartamentoDAOImplementation () {}
	public static DepartamentoDAOImplementation getInstance(){
		if ( null == instancia ) {
			instancia = new DepartamentoDAOImplementation ();
		}
		return instancia;
	}

	@Override
	public List<Departamento> readAllDepartamentos() {
		Session session = SessionFactoryService.get().openSession();
		List<Departamento> departamentos = new ArrayList<>(); 
		try {
			session.beginTransaction();
			departamentos.addAll(session.createQuery("select t from Departamento t").getResultList());
			session.getTransaction().commit();
		}
		catch (Exception e){

		}
		finally {
			session.close();
		}
		return departamentos;
	}

	@Override
	public void createDepartamento(Departamento departamento) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(departamento);
			session.getTransaction().commit();
		}
		catch (Exception e){

		}
		finally {
			session.close();
		}			
	}

	@Override
	public Departamento readDepartamento(int departamentoID) {
		Session session = SessionFactoryService.get().openSession();
		Departamento departamento = null;
		try {
			departamento = session.get(Departamento.class, departamentoID);
		}
		catch (Exception e){

		}
		finally {
			session.close();
		}
		return departamento;
	}

	@Override
	public void updateDepartamento(Departamento departamento) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(departamento);
			session.getTransaction().commit();
		}
		catch (Exception e){

		}
		finally {
			session.close();
		}			
	}

	@Override
	public void deleteDepartamento(Departamento departamento) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(departamento);
			session.getTransaction().commit();
		}
		catch (Exception e){

		}
		finally {
			session.close();
		}		
	}

}
