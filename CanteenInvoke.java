package com.xwork.clone.canteen;

public class CanteenInvoke {
public static void main(String[] args) throws CloneNotSupportedException {
	
	CanteenDTO canteen=new CanteenDTO();
	canteen.setCanteenId(78);
	canteen.setCanteenName("Laxmi Canteen");
	canteen.setLocation("Malapur");
	canteen.setContactNo(7812515425L);
	canteen.setOwnerName("Mahalaxmi");
	
	CanteenDTO can=(CanteenDTO)canteen.clone();	
	System.out.println(can);
}
}
