package com.xwork.clone.institute;

import com.xwork.clone.laptop.LaptopDTO;

public class InstituteTester {
	public static void main(String[] args) throws CloneNotSupportedException {
		
	
	InstituteDTO instituteDTO=new InstituteDTO();
	
	instituteDTO.setInstituteName("BGMIT");
	instituteDTO.setInstituteId(15);
	instituteDTO.setFees(30000);
	instituteDTO.setLocation("Mudhol");
	instituteDTO.setNoOfTrainers(10);
	
	
 InstituteDTO ins=(InstituteDTO)instituteDTO.clone();
	System.out.println(ins);
}
}