package com.xworkz.hostel.dto;

public class FoodItemsDTO {

	
		public FoodItemsDTO() {
			System.out.println("Item object is created");
		}
		
		private int itemId;
		private String itemName;
		

		public void setItemId(int itemId) {
			this.itemId=itemId;
		}
		
		public int getItemId() {
			
			return itemId;
		}
		public void setItemName(String itemName) {
			this.itemName=itemName;
			
		}
		public String getItemName() {
			
	           return itemName;
		
		}
		@Override
		public String toString() {
		return"FoodItemsDTO---{Id="+itemId+",Name="+itemName+"}";
				
		}
		
	}


