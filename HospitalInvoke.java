package com.xwork.clone.hospital;

public class HospitalInvoke {
public static void main(String[] args) throws CloneNotSupportedException {
	
	HospitalDTO hospitalDTO=new HospitalDTO();
	hospitalDTO.setHospitalId(27);
	hospitalDTO.setHospitalName("Sadana");
	hospitalDTO.setNoOfDoctors(0);
	hospitalDTO.setLocation("Mudhol");
	hospitalDTO.setSpecilization("Heart Specialist");
	
	HospitalDTO hos=(HospitalDTO)hospitalDTO.clone();
	System.out.println(hos);
}
}

