package com.xworkz.city.dto;


    public class CompaniesDTO {
	
		public CompaniesDTO(){
			System.out.println(this.getClass().getSimpleName()+"object created");
			}

			   private int companyId;
			   private String companyName;
			   private int companySalary;
			   
			   public void setCompanyId(int companyId){
					this.companyId=companyId;
					}

				public int getCompanyId(){
					return companyId;
					}

				public void setCompanyName(String companyName){
					this.companyName=companyName;
					}

				public String getCompanyName(){
					return companyName;
					}
				
				public void setCompanySalary(int companySalary){
					this.companySalary=companySalary;
					}

				public int getCompanySalary(){
					return companySalary;
					}
				
				@Override
				public String toString(){
return"CompaniesDTO-{companyId="+this.companyId+",companyName="+this.companyName+",companySalary="+this.companySalary+"}";
				}
				}

			   





