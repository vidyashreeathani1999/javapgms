package com.xworkz.hospitalapp;

import java.util.*;

import com.xworkz.hospitalapp.dto.AddressDTO;
import com.xworkz.hospitalapp.dto.AreaDTO;
import com.xworkz.hospitalapp.dto.CountryDTO;
import com.xworkz.hospitalapp.dto.DistrictDTO;
import com.xworkz.hospitalapp.dto.PatientDTO;
import com.xworkz.hospitalapp.dto.StateDTO;
import com.xworkz.hospitalapp.dto.StreetDTO;

public class HospitalTester {
	public static void main(String a[]) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size");
		int size = sc.nextInt();

		Hospital hospital = new Hospital(size);

		for (int i = 0; i < size; i++) {

			PatientDTO dto = new PatientDTO();

			System.out.println("Enter the PatientDetails");
			System.out.println("Enter the PatientId");
			int patientId = sc.nextInt();

			System.out.println("Enter the PatientName");
			String patientName = sc.next();

			System.out.println("Enter the ContactNo");
			long contactNo = sc.nextLong();

			System.out.println("Enter the BloodGroup");
			String bloodGroup = sc.next();

			System.out.println("Enter the Age");
			int age = sc.nextInt();

			System.out.println("Enter the Gender");
			char gender = sc.next().charAt(0);

			dto.setPatientId(patientId);
			dto.setPatientName(patientName);
			dto.setContactNo(contactNo);
             
			dto.setBloodGroup(bloodGroup);
			dto.setAge(age);
			dto.setGender(gender);

			boolean isAdded = hospital.createPatientDetails(dto);
			System.out.println("PatientAdded:" + isAdded);
		

		AddressDTO dto1 = new AddressDTO();
dto.setAddress1(dto1);
		System.out.println("Enter the AddressId");
		int addressId = sc.nextInt();

		dto1.setAddressId(addressId);
		System.out.println("Enter the AddressName");
		String addressName = sc.next();
		dto1.setAddressName(addressName);

		CountryDTO dto2 = new CountryDTO();
		dto1.setCountry(dto2);
		System.out.println("Enter the countryId");
		int countryId = sc.nextInt();
		dto2.setCountryId(countryId);
		System.out.println("Enter the countryName");
		String countryName = sc.next();
		dto2.setCountryName(countryName);

		StateDTO dto3 = new StateDTO();
		dto2.setState(dto3);
		System.out.println("Enter the stateId");
		int stateId = sc.nextInt();
		dto3.setStateId(stateId);
		System.out.println("Enter the stateName");
		String stateName = sc.next();
		dto3.setStateName(stateName);

		DistrictDTO dto4 = new DistrictDTO();
		dto3.setDistrict(dto4);
		System.out.println("Enter the districtId");
		int districtId = sc.nextInt();
		dto4.setDistrictId(districtId);
		System.out.println("Enter the districtName");
		String districtName = sc.next();
		dto4.setDistrictName(districtName);

		AreaDTO dto5 = new AreaDTO();
		dto4.setArea(dto5);
		System.out.println("Enter the AreaId");
		int areaId = sc.nextInt();
		dto5.setAreaId(areaId);
		System.out.println("Enter the AreaName");
		String areaName = sc.next();
		dto5.setAreaName(areaName);

		StreetDTO dto6 = new StreetDTO();
		dto5.setStreet(dto6);
		System.out.println("Enter the StreetNo");
		int streetNo = sc.nextInt();
		dto6.setStreetNo(streetNo);
		System.out.println("Enter the StreetName");
		String streetName = sc.next();
		dto6.setStreetName(streetName);
		
		}
		hospital.getAllPatients();
		
		
		 System.out.println("Enter the patient by streetNo");
		 int streetNO=sc.nextInt();
		 System.out.println(hospital.getPatientByStreetNO(streetNO));
		 

		
		  System.out.println("Enter the patient by areaName");
		  String areaName1=sc.next();
		  System.out.println(hospital.getPatientByArea(areaName1));
		

		System.out.println("Enter the patient by streetName");
		String streetName1 = sc.next();
		System.out.println(hospital.getPatientByStreetName(streetName1));

		
		  System.out.println("Enter the patient by streetName"); 
		  String stateName1=sc.next();
		  System.out.println(hospital.getPatientByState(stateName1));
		 

		
		  System.out.println("Enter the patient Id and contact number to update");
		  int patientId=sc.nextInt();
		  long contactNo=sc.nextLong();
		 hospital.updatePatientContactNoById(patientId,contactNo);
		  hospital.getAllPatients();
		  
		  System.out.println("Enter patient Id to delete"); 
		  int id1=sc.nextInt();
		  hospital.deletePatientById(patientId); 
		  hospital.getAllPatients();
		 

	}
}