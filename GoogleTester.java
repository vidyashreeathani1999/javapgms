package com.xworkz.google;
import java.util.*;

import com.xworkz.google.dto.GoogleApplicationsDTO;
public class GoogleTester {

	


		public static void main(String a[]){

			System.out.println("\n"+"Enter the number of applications");
			Scanner sc = new Scanner(System.in);
			int size = sc.nextInt();
			Google google = new Google(size);
			if(size>0)
			{	
				for(int i = 0; i< size; i++)
				{
				GoogleApplicationsDTO dto = new GoogleApplicationsDTO();
				System.out.println("Enter the application details");
				
				System.out.println("Enter the application ID");
				int applicationId = sc.nextInt();
				dto.setApplicationId(applicationId);
				
				System.out.println("Enter the application name");
				String applicationName = sc.next();
				dto.setApplicationName(applicationName);
				
				
				boolean isAdded = google.createGoogleApplicationsDetails(dto);
				System.out.println(isAdded);
				}
					
				int choice;
				String text;
				do {
					System.out.println("Press 1 to get all Applications");
					System.out.println("Press 2 to get all Applications by Name");
					System.out.println("Press 3 to get all Applications by Id");
					System.out.println("Enter the choice:-");
					choice = sc.nextInt();
					switch(choice){
					case 1: google.getAllApplications();
					break;
					case 2: System.out.println("Enter the Application Name"); 
						GoogleApplicationsDTO dto =google.getApplicationByName(sc.next());
						   if(dto!=null)
						   {
							   System.out.println("dto");
						   }
						   else {
							   System.out.println("No Application Found by Name");
						   }
					break;
					case 3:System.out.println("Enter the Application Id");
					GoogleApplicationsDTO dto1=google.getApplicationById(sc.nextInt());
					if(dto1!=null)
					{
						System.out.println("dto1");
					}
					else {
						System.out.println("No Application Found by Id");
					}
					break;
					default:
					System.out.println("Gube Invalid Choice.......Please provide valid choice");
					}
					System.out.println("do you want to continue??? press y/n");
					text=sc.next();
					
				}while(text.equals("y"));
				//System.out.println(google.getApplicationByName(sc.next()));
					}
				
				System.out.println("Enter application id and application name  to update");
				int applicationId1=sc.nextInt();
			    String applicationName1=sc.next();
				google.updateApplicationNameByApplicationId("GooglePhotos",1);
				
			
				
				System.out.println("\n"+"Enter application Id to delete");
				int id1=sc.nextInt();
				google.deleteApplicationById(id1);
				
				google.getAllApplications();
				
				}
				
			
			}
		
			
	   
	   
	   
	   
				
				
				








