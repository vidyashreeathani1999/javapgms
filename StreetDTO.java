package com.xworkz.hospitalapp.dto;

public class StreetDTO {
	
	private int streetNO;
	private String streetName;
	
		public void setStreetNo(int streetNo){
			this.streetNO=streetNO;
			}

			public int getStreetNO(){
			return streetNO;
			}

		public void setStreetName(String streetName){
		this.streetName=streetName;
		}

		public String getStreetName(){
		return streetName;
        }
		
		

			
			@Override
			public String toString(){
				return "StreetDTO-{streetNo="+this.streetNO+", streetName="+this.streetName+"}";
						
				
			}
}