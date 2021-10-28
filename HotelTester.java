package com.xworkz.hostel;

import java.util.*;

import com.xworkz.hostel.dto.FoodItemsDTO;
public class HotelTester {

	
	public static void main(String a[]) {
			
			System.out.println("\n"+"Enter the number of items ");
			Scanner sc=new Scanner(System.in);
			int size=sc.nextInt();
			
			Hotel hotel=new Hotel(size);
			
			if(size>0) {
				for(int i=0;i<size;i++) {
					FoodItemsDTO food=new FoodItemsDTO();
					
					System.out.println("Enter Details");
					
					System.out.println("Enter ItemId");
					int itemId=sc.nextInt();
					food.setItemId(itemId);
					System.out.println("Enter ItemName");
					String itemName=sc.next();
					food.setItemName(itemName);
					
					
					boolean isAdded=hotel.createItemsDetails(food);
					System.out.println("ItemAdded:"+isAdded);
				}
					
					hotel.getItemDetails();
					System.out.println("\n"+"Enter the ItemId");
					int itemId=sc.nextInt();
					System.out.println(hotel.getHotelByItemId(itemId));
					
				   System.out.println("\n"+"Enter the ItemName");
				   String electronicName=sc.next();
				   String itemName = null;
				System.out.println(hotel.getHotelByItemName(itemName));
				 
				   
				   int choice;
					String text;
					do {
					System.out.println("Press 1 to get all items ");	
					System.out.println("Press 2 to get Item Name");
					System.out.println("Press 3 to get Item Id");
					System.out.println("Enter your choice :-");
					choice=sc.nextInt();
					
					 
			              
				
				switch(choice) {
				case 1: hotel.getItemDetails();
				  break;
				  
				case 2:System.out.println("Enter the item Name");
				FoodItemsDTO dto1=hotel.getHotelByItemName(sc.next());
				    	 if(dto1!=null) {
				    		 System.out.println(dto1);
				    		 
				    	 }
				    	 else {
				    		 System.out.println("No item found by Name");
				    	 }
				    	 break;
				case 3:System.out.println("Enter the item Id");
				FoodItemsDTO dto2=hotel.getItemById(sc.nextInt());
				       if(dto2!=null) {
				    	   System.out.println(dto2);
				       }
				       else {
				    	   System.out.println("No item found by Id");
				       }
				       
				       default:
				    	 System.out.println("invalid Choice");
				}
				       System.out.println("do want continue press y/n");
				       text=sc.next();
				       
				}  
				       while(text.equals("y"));
				    //System.out.println(getItemName(sc.next());	
				   
				}
			
			
			
			System.out.println("\n"+"Enter itemId and itemName to be updated");
			int id=sc.nextInt();
			String name=sc.next();
			hotel.updateItemNameByItemId(name, id);
			
			hotel.getItemDetails();
			System.out.println("\n"+"Enter id to be deleted");
			int id1=sc.nextInt();
			hotel.deleteApplicationById(id1);
			
		}

	}


