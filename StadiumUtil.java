package com.xwork.clone.stadium;

public class StadiumUtil {

	public static void main(String[] args) throws CloneNotSupportedException {
		
	
	StadiumDTO stadiumDTO=new StadiumDTO();
	stadiumDTO.setStadiumId(12);
	stadiumDTO.setStadiumName("Kanteerava stadium");
	stadiumDTO.setLocation("Bangaluru");
	stadiumDTO.setNoOfSeats(2000);
	stadiumDTO.setTicket(300);
	
	StadiumDTO std=(StadiumDTO)stadiumDTO.clone();
	System.out.println(std);
}
}