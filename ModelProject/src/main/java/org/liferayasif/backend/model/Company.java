package org.liferayasif.backend.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="COMPANY")

public class Company implements Serializable {

	
	private static final long serialVersionUID = -9077166639104923853L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private Integer id;
	
	@Column(name="NUMBER")
	private Integer num;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="EMAIL")
	private String email;
	
	@Transient
	public List<CompanyAddress> companyAddressList;
	
	public Company(){}
	
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id=id;
	}
	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public String getEmail(){
		
		return email;
	}
	public void setEmail(String email)
	{
		this.email= email;
	}
	public List<CompanyAddress> getCompanyAddressList(){
		return companyAddressList;
	}
	public void setCompanyAddressList(List<CompanyAddress> companyAddressList){
		
		this.companyAddressList=companyAddressList;
		
	}
	
	@Override
	public String toString(){
		return "id: "+id+"   name: "+name+"    email: "+email;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
