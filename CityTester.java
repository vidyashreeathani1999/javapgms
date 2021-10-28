package com.xworkz.city;

import java.util.Scanner;
import com.xworkz.city.dto.CompaniesDTO;

public class CityTester {

	
		   
			public static void main(String a[]){

				System.out.println("\n"+"Enter the number of companies");
				Scanner sc = new Scanner(System.in);
				int size = sc.nextInt();
				City city = new City(size);
				if(size>0)
				{	
					for(int i = 0; i< size; i++)
					{
					CompaniesDTO dto = new CompaniesDTO();
					System.out.println("Enter the company details");
					
					System.out.println("Enter the company ID");
					int companyId = sc.nextInt();
					dto.setCompanyId(companyId);
					
					System.out.println("Enter the company name");
					String companyName = sc.next();
					dto.setCompanyName(companyName);
					
					System.out.println("Enter the company salary");
					int companySalary =sc.nextInt();
					dto.setCompanySalary(companySalary);
					
					boolean isAdded = city.createCompaniesDetails(dto);
					System.out.println(isAdded);
					}
						
					int choice;
					String text;
					do {
						System.out.println("Press 1 to get all Companies");
						System.out.println("Press 2 to get all Companies by Name");
						System.out.println("Press 3 to get all Companies by Id");
						System.out.println("Enter the choice:-");
						choice = sc.nextInt();
						switch(choice){
						case 1: city.getAllCompanies();
						break;
						case 2: System.out.println("Enter the Company Name"); 
							CompaniesDTO dto =city.getCompanyByName(sc.next());
							   if(dto!=null)
							   {
								   System.out.println("dto");
							   }
							   else {
								   System.out.println("No Company Found by Name");
							   }
						break;
						case 3:System.out.println("Enter the Company Id");
						CompaniesDTO dto1=city.getCompanyById(sc.nextInt());
						if(dto1!=null)
						{
							System.out.println("dto1");
						}
						else {
							System.out.println("No Company Found by Id");
						}
						break;
						default:
						System.out.println("Gube Invalid Choice.......Please provide valid choice");
						}
						System.out.println("do you want to continue??? press y/n");
						text=sc.next();
						
					}while(text.equals("y"));
					//System.out.println(city.getCompanyByName(sc.next()));
						}
					
					System.out.println("Enter company id and company salary to update");
					int companyId1=sc.nextInt();
					int companySalary1=sc.nextInt();
					city.updateCompanySalaryByCompanyId(1,5000);
					
				
					
					System.out.println("\n"+"Enter company Id to delete");
					int id1=sc.nextInt();
					city.deleteCompanyById(id1);
					
					city.getAllCompanies();
					
					}
					
				
				}
			
				
		   
		   
		   
		   
					
					
					






