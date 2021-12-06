package com.xwork.clone.pens;

public class PenInvoke {
public static void main(String[] args) throws CloneNotSupportedException {
	
	PenDTO penDTO=new PenDTO();
	penDTO.setPenId(25);
	penDTO.setPenName("Cello");
	penDTO.setPrice(70);
	penDTO.setThickness("2mm");
	penDTO.setColor("Black");
	
	PenDTO pen=(PenDTO)penDTO.clone();
	System.out.println(pen);
}
}
