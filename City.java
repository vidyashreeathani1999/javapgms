package com.xworkz.city;

import com.xworkz.city.dto.CompaniesDTO;

public class City {

	
			public CompaniesDTO[] companies ;
			  private int index;

			public City(int size){
			 companies=new CompaniesDTO[size];
			}
			
			public boolean createCompaniesDetails(CompaniesDTO companies){
				boolean companiesAdded=false;
				System.out.println("inside createCompanies()");
				if(companies!=null){
				  this.companies[index++]=companies;
				  companiesAdded=true;
				}

				else{
				System.out.println("No Gadgets added");
				return companiesAdded=false;
				}
				return companiesAdded;
				}
			
			public void getAllCompanies(){
				for(int i=0;i<companies.length;i++){
				System.out.println(companies[i]);
				}
				}
			
			public CompaniesDTO getCompanyByName(String companyName){
				CompaniesDTO companiesDTO=null;
				System.out.println("inside getCompanyByName()");
				if(companyName!=null){
				   for(int i=0;i<companies.length;i++){
				     if(companies[i].getCompanyName().equals(companyName)){
				System.out.println("Company found by Name:"+companyName);
				      companiesDTO=companies[i];
				     }
				  
				else{
				System.out.println("No Company Found by Name:"+companyName);
				}
				   }
				}
				return companiesDTO;
				}
		    

		    public CompaniesDTO getCompanyById(int companyId){
			CompaniesDTO companiesDTO=null;
			System.out.println("inside getGadgetById()");
			if(companyId!=0){
			   for(int i=0;i<companies.length;i++){
			     if(companies[i].getCompanyId()==(companyId)){
			System.out.println("Company found by Id:"+companyId);
			   companiesDTO=companies[i];
			     }
			  
			else{
			System.out.println("No Gadget Found by Id:"+companyId);
			}
			   }
			}
			return companiesDTO;
		}
		    
		    public CompaniesDTO getCompanyBySalary(int companySalary){
		    	CompaniesDTO companiesDTO=null;
		    	System.out.println("inside getCompanyBySalary()");
		    	if(companySalary!=0){
		    	   for(int i=0;i<companies.length;i++){
		    	     if(companies[i].getCompanySalary()==(companySalary)){
		    	System.out.println("Company found by Salary:"+companySalary);
		    	   companiesDTO=companies[i];
		    	     }
		    	  
		    	else{
		    	System.out.println("No Company Found by Id:"+companySalary);
		    	}
		    	   }
		    	}
		    	return companiesDTO;
		    }
		   
		    public void updateCompanySalaryByCompanyId(int companySalary,int companyId){
		    	System.out.println("inside updateCompanySalaryByCompanyId()");
		    	if(companyId>0&&companySalary>0){
		    	   for(int i=0;i<companies.length;i++){
		    	     if(companies[i].getCompanyId()==(companyId)){
		    	System.out.println("Company Salary updated by:"+companySalary);
		    	   companies[i].setCompanySalary(companySalary);
		    	     }

		    	else{
		    	System.out.println("Company not updated");
		    	}
		    	   }
		    	}
		    }


		    public void deleteCompanyById(int companyId){
		    	System.out.println("Inside deleteCompanyById()");
		    	if(companyId > 0){
		    	for(int i=0; i<companies.length; i++){
		    	if(companies[i].getCompanyId()==(companyId)){
		    	System.out.println("Company deleted by id : "+companyId);
		    	companies[i].setCompanyId(companyId);
		    	}
		    	
		    	
		    	else{
		    	System.out.println("Company is not deleted");
		    	}
		    	}
		    	}
		    			
		    }
		    }
		    	
		    	




