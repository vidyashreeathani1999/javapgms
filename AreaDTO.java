package com.xworkz.hospitalapp.dto;

public class AreaDTO {

	private Integer areaId;
	private String areaName;
	private StreetDTO street;
	
	public void setAreaId(int areaId){
		this.areaId=areaId;
		}

		public int getAreaId(){
		return areaId;
		}

		public void setAreaName(String areaName){
		this.areaName=areaName;
		}

		public String getAreaName(){
		return areaName;
        }
		
		public void setStreet(StreetDTO street){
			this.street=street;
			}

			public StreetDTO getStreet(){
			return street;
	        }
		
			@Override
			public String toString(){
			return "AreaDTO-{areaId="+this.areaId+", areaName="+this.areaName+",street="+this.street+"}";
						
				
			}		

}
