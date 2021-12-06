package com.xwork.clone.travel;

public class TravelInvoke {
public static void main(String[] args) throws CloneNotSupportedException {
	TravelDTO travelDTO=new TravelDTO();
	
	travelDTO.setTravelName("Royal");
	travelDTO.setBusId(67);
	travelDTO.setLocation("Bagalkot");
	travelDTO.setContactNo(9871765535L);
	travelDTO.setCost(1500);
	travelDTO.setNoOfPassenger(30);
	
	
	TravelDTO travel=(TravelDTO)travelDTO.clone();
	System.out.println(travel);
}
}
