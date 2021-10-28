package com.xworkz.mobile;
import java.util.Scanner;

import com.xworkz.mobile.dto.ApplicationsDTO;

public class MobileTester {

	
	

	
		
		public static void main(String a[]) {
			System.out.println("\n"+"Enter the number of applications");
			Scanner sc=new Scanner(System.in);
			int size=sc.nextInt();
			
			Mobile mobile =new Mobile(size);
			
			if(size>0) {
				for(int i=0;i<size;i++) {
					ApplicationsDTO app=new ApplicationsDTO();
					
					System.out.println("Enter Details");
					
					System.out.println("Enter ApplicationId");
					int applicationId=sc.nextInt();
					app.setApplicationId(applicationId);
					System.out.println("Enter ApplicationName");
					String applicationName=sc.next();
					app.setApplicationName(applicationName);
					
					
					boolean isAdded=mobile.createApplicationDetails(app);
					System.out.println("ApplicationAdded:"+isAdded);
				}
					
					mobile.getApplicationDetails();
					System.out.println("\n"+"Enter the ApplicationId");
					int applicationId=sc.nextInt();
					System.out.println(mobile.getMobileByApplicationId(applicationId));
					
				   System.out.println("\n"+"Enter the ApplicationName");
				   String applicationName=sc.next();
				   System.out.println(mobile.getMobileByApplicationName(applicationName));
				   
				   
				   int choice;
				   String text;
				   
				   do {
					   System.out.println("Press 1 to get All details");
					   System.out.println("Press 2 to get Application Id");
					   System.out.println("Press 3 to get Application Name");
					   choice=sc.nextInt();
					   
					   switch(choice) {
					   case 1:mobile.getApplicationDetails();
					   break;
					   case 2:System.out.println("Enter application Id");
					   ApplicationsDTO dto1=mobile.getMobileByApplicationName(sc.next());
				    	 if(dto1!=null) {
				    		 System.out.println(dto1);
				    		 
				    	 }
				    	 else {
				    		 System.out.println("No application found by Name");
				    	 }
				    	 break;
				case 3:System.out.println("Enter the application Id");
				ApplicationsDTO dto2=mobile.getMobileByApplicationId(sc.nextInt());
				       if(dto2!=null) {
				    	   System.out.println(dto2);
				       }
				       else {
				    	   System.out.println("No application found by Id");
				       }
				       
				       default:
				    	 System.out.println("invalid Choice");
				}
				       System.out.println("do want continue press y/n");
				       text=sc.next();
				       
				}  
				       while(text.equals("y"));
				    //System.out.println(getMobileByApplicationName(sc.next());	   
				        
				
			
			System.out.println("\n"+"Enter application Id and application name to be updated");
			int id=sc.nextInt();
			String name=sc.next();
			mobile.updateApplicationNameByApplicationId(name, id);
			mobile.getApplicationDetails();
			
			
			System.out.println("\n"+"Enter id to be deleted");
			int id1=sc.nextInt();
			mobile.deleteApplicationById(id1);
			mobile.getApplicationDetails();
			
		}

			else {
				System.out.println("invalid");
			}

				
		}
	}

