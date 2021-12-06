package com.xwork.clone.mobiles;

public class MobileInvoke {
public static void main(String[] args) throws CloneNotSupportedException {
	
	MobileDTO mobile=new MobileDTO();
	mobile.setMobileId(15);
	mobile.setMoblileName("Vivo");
	mobile.setPrice(14000);
	mobile.setStorage("64GB");
	mobile.setColor("blue");
	
	MobileDTO mob=(MobileDTO)mobile.clone();
	System.out.println(mob);
	
}
}
