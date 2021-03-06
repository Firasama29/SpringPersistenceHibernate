package org.liferayasif.backend.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.liferayasif.backend.constants.PathConstants;
import org.liferayasif.backend.model.Company;
import org.liferayasif.backend.model.CompanyAddress;
import org.liferayasif.backend.service.CompanyAddressService;
import org.liferayasif.backend.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = PathConstants.COMPANY)
public class CompanyRestController {
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private CompanyAddressService companyAddressService;
	
	@RequestMapping(value = PathConstants.FIND_BY_ID_COMPANY)
	public Company findById(@RequestParam("id") int id)
	{
		Company company = companyService.getCompanyById(id);
		
		List<CompanyAddress> companyAddressList=new ArrayList<CompanyAddress>();
		if(company !=null)
		{
			companyAddressList = companyAddressService.getCompanyAddressesByCompanyId(id);
			
			if(companyAddressList != null && companyAddressList.size()>0)
			{
				company.setCompanyAddressList(companyAddressList);
			}
		}
		System.out.println(company);
		return company;
		
		
	}
	@RequestMapping(value = PathConstants.SEARCHBYNUM)
	public List<Company> companyListNumber(@RequestParam("num") int num)
	{
		List<Company> companyList = companyService.getCompanyByNumber(num);
		return companyList;
	}
	
	@RequestMapping(value=PathConstants.ADD_COMPANY, method=RequestMethod.POST)
	public Company add(@RequestBody Company company)throws Exception{
				
		String name = company.getName().trim();
		int num = company.getNum();
		String email = company.getEmail().trim();
		
		if(email==null || email.isEmpty() || name==null || name.isEmpty()|| num==0)
		{
			throw new Exception ("the field cannot be empty");
		}
		
		company = companyService.addCompany(company);
		return company;
	}
	

	@RequestMapping(value = PathConstants.SEARCH_COMPANY)
	public List<Company> searchCompany(@RequestParam(value="email", required=false) String email1, @RequestParam(value="name", required=false) String name1)
	{
		List<Company> companyList = null; 
		
		if(email1==null && name1==null){
			companyList = companyService.getAllCompanys();
			return companyList;
		}
		
		companyList = companyService.searchCompany(email1, name1);
		
		System.out.println("email: "+email1);
		System.out.println("name: "+name1);
		return companyList;
	}
	
	
	
	@RequestMapping(value = PathConstants.SEARCH_COMPANY_BY_NAME_EMAIL)
	public List<Company> searchByNameEmail(@RequestParam ("email") String email , @RequestParam("name") String name ) throws Exception
	{
		
		if(email==null || email.isEmpty()){
			
		}
		
		if(name==null || name.isEmpty()){
			
		}

		List<Company> company = companyService.searchByEmailName(email, name);
		
		if(company==null || company.isEmpty())
		{
			throw new Exception("no such detail found with given name and email (please provide both name and email, email : "+email+" name :"+name );
		}
		
		return company;
		
	}
	
}
