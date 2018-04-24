package es.upm.dit.isst.web.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.web.dao.model.Asignatura;
import es.upm.dit.isst.web.dao.model.PlanDeEstudio;

public class PlanDeEstudioDAOImplementation implements PlanDeEstudioDAO{
	
	
	
	
	private static PlanDeEstudioDAOImplementation instancia = null;
	private PlanDeEstudioDAOImplementation () {}
	public static PlanDeEstudioDAOImplementation getInstance(){
		if ( null == instancia ) {
			instancia = new PlanDeEstudioDAOImplementation ();
		}
		return instancia;
	}
	
	
	
	
	

	@Override
	public List<PlanDeEstudio> readAllPlanDeEstudio() {
	
		Session session = SessionFactoryService.get().openSession();
		List<PlanDeEstudio> plan = new ArrayList<>(); 
		try {
			session.beginTransaction();
			plan.addAll(session.createQuery("select t from PlanDeEstudio t").getResultList());
			session.getTransaction().commit();
		}
		catch (Exception e){

		}
		finally {
			session.close();
		}
		return plan;
		
		
		
		
	}

	@Override
	public PlanDeEstudio readPlanDeEstudio(String acronimo) {
		Session session = SessionFactoryService.get().openSession();
		PlanDeEstudio plan = null;
		try {
			plan = session.get(PlanDeEstudio.class, acronimo);
		}
		catch (Exception e){

		}
		finally {
			session.close();
		}
		return plan;
		
		
	}

	@Override
	public void createPlanDeEstudio(PlanDeEstudio planDeEstudio) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(planDeEstudio);
			session.getTransaction().commit();
		}
		catch (Exception e){

		}
		finally {
			session.close();
		}			
	}

	@Override
	public void updatePlanDeEstudio(PlanDeEstudio planDeEstudio) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(planDeEstudio);
			session.getTransaction().commit();
		}
		catch (Exception e){

		}
		finally {
			session.close();
		}			
	}

	@Override
	public void deletePlanDeEstudio(PlanDeEstudio planDeEstudio) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(planDeEstudio);
			session.getTransaction().commit();
		}
		catch (Exception e){

		}
		finally {
			session.close();
		}		
	}

}
