package org.liferayasif.backend.service;

import java.util.List;

import org.liferayasif.backend.model.CompanyAddress;

public interface CompanyAddressService {
	
	public List<CompanyAddress> getAllCompanyAddresses();
	
	public CompanyAddress getCompanyAddressById(Integer id);
	
	public CompanyAddress addCompanyAddress(CompanyAddress companyAddress);
	
	public List<CompanyAddress> addCompanyAddressList(List<CompanyAddress> companyAddressList);
	
	public void deleteCompanyAddress(Integer id);
	
	public CompanyAddress updateCompanyAddress(CompanyAddress companyAddress);
	
	public List<CompanyAddress> getCompanyAddressesByCompanyId(Integer id);
	
	public List<CompanyAddress> searchCompany(Integer companyId , String city , String Country);

	
	

}
