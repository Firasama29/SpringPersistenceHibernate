package org.liferayasif.backend.dao;

import java.util.List;

import org.liferayasif.backend.model.Company;

public interface CompanyDao {
	
	public List<Company> getAllCompanys();
	
	public Company getCompnayById(Integer Id);
	
	public void addCompany(Company company);
	
	public void deleteCompany(Integer id);
	
	public Company updateCompany(Company company);
	
	public List<Company> findByName(String name);

}
