package es.upm.dit.isst.web.dao;

import java.util.List;

import es.upm.dit.isst.web.dao.model.PlanDeEstudio;


public interface PlanDeEstudioDAO {
	
	
	
	public List<PlanDeEstudio> readAllPlanDeEstudio( );
	public PlanDeEstudio readPlanDeEstudio( String acronimo );
	public void createPlanDeEstudio( PlanDeEstudio planDeEstudio );
	public void updatePlanDeEstudio( PlanDeEstudio planDeEstudio );
	public void deletePlanDeEstudio( PlanDeEstudio planDeEstudio );

}
