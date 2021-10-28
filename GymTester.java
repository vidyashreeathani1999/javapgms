package com.xworkz.gym;
import java.util.*;

import com.xworkz.gym.dto.EquipmentsDTO;
public class GymTester {

		public static void main(String a[]){

		       System.out.println("\n"+"Enter the number of Equipments");
				Scanner sc = new Scanner(System.in);
				int size = sc.nextInt();

				Gym gym = new Gym(size);

				 if(size>0) {
				for(int i=0;i<size;i++){

					EquipmentsDTO equi = new EquipmentsDTO();

				System.out.println("Enter the EquipmentDetails");
				
				System.out.println("Enter EquipmentId");
				int equipmentId=sc.nextInt();
				equi. setEquipmentsId(equipmentId);
				System.out.println("Enter EquipmentName");
				String equipmentName=sc.next();
				equi.setEquipmentsName(equipmentName);
				
				
				boolean isAdded=gym.createGymEquipmentsDetails(equi);
				System.out.println("EquipmentAdded:"+isAdded);
			}
				
				gym.getAllEquipments();
				System.out.println("\n"+"Enter the EquipmentId");
				int equipmentId=sc.nextInt();
				System.out.println(gym.getEquipmentById(equipmentId));
				
			   System.out.println("\n"+"Enter the EquipmentName");
			   String equipmentName=sc.next();
			   System.out.println(gym.getEquipmentByName(equipmentName));
			   
			   
			   int choice;
			   String text;
			   
			   do {
				   System.out.println("Press 1 to get All details");
				   System.out.println("Press 2 to get Application Id");
				   System.out.println("Press 3 to get Application Name");
				   choice=sc.nextInt();
				   
				   switch(choice) {
				   case 1:gym.getAllEquipments();
				   break;
				   case 2:System.out.println("Enter equipment Id");
				   EquipmentsDTO dto1=gym.getEquipmentByName(sc.next());
			    	 if(dto1!=null) {
			    		 System.out.println(dto1);
			    		 
			    	 }
			    	 else {
			    		 System.out.println("No equipment found by Name");
			    	 }
			    	 break;
			case 3:System.out.println("Enter the equipment Id");
			EquipmentsDTO dto2=gym.getEquipmentById(sc.nextInt());
			       if(dto2!=null) {
			    	   System.out.println(dto2);
			       }
			       else {
			    	   System.out.println("No equipment found by Id");
			       }
			       
			       default:
			    	 System.out.println("invalid Choice");
			}
			       System.out.println("do want continue press y/n");
			       text=sc.next();
			       
			}  
			       while(text.equals("y"));
			    //System.out.println(getMobileByApplicationName(sc.next());	   
			        
			
		
		System.out.println("\n"+"Enter equipment Id and equipment name to be updated");
		int id=sc.nextInt();
		String name=sc.next();
		gym.updateEquipmentNameByEquipmentId(name, id);
		gym.getAllEquipments();
		
		
		System.out.println("\n"+"Enter id to be deleted");
		int id1=sc.nextInt();
		gym.deleteEquipmentById(id1);
		gym.getAllEquipments();
		
	}

		else {
			System.out.println("invalid");
		}

			
	}
			}

