package com.xworkz.hostel;

import com.xworkz.hostel.dto.FoodItemsDTO;

public class Hotel {

	
		public FoodItemsDTO[] items;
		private int index;
		
		
		
		

		public Hotel(int size) {
			items =new FoodItemsDTO [size];
			
		}
		
		
		public boolean createItemsDetails(FoodItemsDTO items) {
			boolean isAdded=false;
			System.out.println("inside createItemsDetails()");
			boolean Added;
			boolean itemsAdded;
			if(items!=null) {
				this.items[index++]= items;
				itemsAdded=true;
			}
			else {
				System.out.println("No items is added");
				return itemsAdded=false;
			}
			return itemsAdded;
		}
		public void getItemDetails() {
			for(int i=0;i<items.length;i++) {
				System.out.println(items[i]);
			}
		}
		
		public FoodItemsDTO getHotelByItemId(int itemsId) {
			FoodItemsDTO foodDTO=null;
		  System.out.println("inside food by getHotelByItemId()");
			if(itemsId>0) {
				for(int i=0;i<items.length;i++) {
					if(items[i].getItemId()==itemsId) {
						System.out.println("Items found by:"+itemsId);
					foodDTO=items[i];	
					}
					else {
						System.out.println("Items not found by:"+itemsId);
					}
				}
			}
					return foodDTO;
				}
				public FoodItemsDTO getHotelByItemName(String itemName) {
					FoodItemsDTO foodDTO=null;
					System.out.println("inside food by getHotelByItemName()");
					if(itemName!=null) {
						for(int i=0;i<items.length;i++) {
							if(items[i].getItemName().equals(itemName)) {
								System.out.println("Item found by:"+itemName);
								foodDTO =items[i];
							}
							else {
								System.out.println("Item not found by:"+itemName);
							}
						}
					}
							return foodDTO;
			}
				public void updateItemNameByItemId(String itemName,int itemId) {
					
					System.out.println("inside item by updateItemNameByItemId()");
					if(itemName!=null&&itemId>0) {
						for(int i=0;i<items.length;i++) {
							if(items[i].getItemId()==(itemId)) {
								System.out.println("Item Name is updated by:"+itemId);
							      items[i].setItemName(itemName);
							}
							else {
								System.out.println("Application Name is not updates:"+itemId);
							}
					
						}
		}
				}
				public void deleteApplicationById(int itemId) {
					System.out.println("Inside deleteItemById()");
					if(itemId>0) {
						for(int i=0;i<items.length;i++) {
							if(items[i].getItemId()==(itemId)) {
								System.out.println("Item Id is deleted by:"+itemId);
								items[i].setItemId(itemId);
								
							}
							else {
								System.out.println("Item Id is not deleted:"+itemId);
							}
						}
					}
					
				}


				public FoodItemsDTO getItemById(int nextInt) {
					// TODO Auto-generated method stub
					return null;
				}
					
		}




