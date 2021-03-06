package org.liferayasif.backend.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.liferayasif.backend.dao.CompanyAddressDao;
import org.liferayasif.backend.model.CompanyAddress;
import org.liferayasif.backend.service.CompanyAddressService;
import org.liferayasif.backend.util.time.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("CompanyAddressService")
@Transactional
public class CompanyAddressServiceImpl implements CompanyAddressService {

	@Autowired
	private CompanyAddressDao companyAddressDao;
	
	@Override
	public List<CompanyAddress> getAllCompanyAddresses() {
		List<CompanyAddress> companyAddressList = companyAddressDao.getAllCompanyAddresses();
		return companyAddressList;
	}

	@Override
	public CompanyAddress getCompanyAddressById(Integer id) {
		CompanyAddress companyAddress = companyAddressDao.getCompanyAddressById(id);
		return companyAddress;
	}

	@Override
	public CompanyAddress addCompanyAddress(CompanyAddress companyAddress) {
		companyAddress.setCreateDt(TimeUtil.getSqlTimStmp());
		companyAddress.setUpdtDt(TimeUtil.getSqlTimStmp());
		return companyAddressDao.addCompanyAddress(companyAddress);
	}
	
	
	@Override
	public List<CompanyAddress> addCompanyAddressList(List<CompanyAddress> companyAddressList) {
		if(companyAddressList !=null && companyAddressList.size()>0){
			
			for(CompanyAddress companyAddress : companyAddressList){
				addCompanyAddress(companyAddress);
				
				}
		}
		return companyAddressList;
	}


		@Override
	public void deleteCompanyAddress(Integer id) {
		companyAddressDao.deleteCompanyAddress(id);
		
	}

	@Override
	public CompanyAddress updateCompanyAddress(CompanyAddress companyAddress) {
		
		return companyAddressDao.updateCompanyAddress(companyAddress);
	}


	@Override
	public List<CompanyAddress> getCompanyAddressesByCompanyId(Integer id) {
		List<CompanyAddress> companyAddressList =companyAddressDao.getCompanyAddressByCompanyId(id);
		return companyAddressList;
	}

	@Override
	public List<CompanyAddress> searchCompany(Integer companyId, String city, String Country) {
		List<CompanyAddress> companyAddressList  = companyAddressDao.searchCompany(companyId, city, Country);
		return companyAddressList;
	}

	
		

}
