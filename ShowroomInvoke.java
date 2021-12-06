package com.xwork.clone.showrooms;

public class ShowroomInvoke {
public static void main(String[] args) throws CloneNotSupportedException {
	ShowroomDTO showroom=new ShowroomDTO();
	
	showroom.setShowroomId(67);
	showroom.setShowroomName("Tarun");
	showroom.setOwnerName("Muragesh Athani");
	showroom.setContactNo(8726357198L);
	showroom.setLocation("Mudhol");
	
	ShowroomDTO show=(ShowroomDTO)showroom.clone();
	System.out.println(show);
}
}
