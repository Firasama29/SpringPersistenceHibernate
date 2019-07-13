package org.liferayasif.backend.dao;

import java.util.List;

import org.liferayasif.backend.model.PurseBig;



public interface PurseBigDao {
	
	public List<PurseBig> getAllPurseBig();
	
	public PurseBig getPurseBigById(Integer id);
	
	public List<PurseBig> getPurseBigByPrice(Integer price);
	
	public void addPurse(PurseBig purseBig);
	
	public List<PurseBig> findByName(String name);
	
	public void deletePurseBigById(Integer id);
	
	public void deletePurseBigByPrice(Integer price);
	

}
