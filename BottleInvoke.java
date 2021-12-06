package com.xwork.clone.bottle;

public class BottleInvoke {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		BottleDTO bottleDTO=new BottleDTO();
		bottleDTO.setBottleId(3);
		bottleDTO.setBottleName("Cello");
		bottleDTO.setCapacity("2li");
		bottleDTO.setColor("blue");
		bottleDTO.setPrice(100);
		
		BottleDTO bot=(BottleDTO)bottleDTO.clone();
		System.out.println(bot);
	}
}
