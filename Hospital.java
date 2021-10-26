package com.xworkz.hospitalapp;

import com.xworkz.hospitalapp.dto.AddressDTO;
import com.xworkz.hospitalapp.dto.AreaDTO;
import com.xworkz.hospitalapp.dto.CountryDTO;
import com.xworkz.hospitalapp.dto.DistrictDTO;
import com.xworkz.hospitalapp.dto.PatientDTO;
import com.xworkz.hospitalapp.dto.StateDTO;
import com.xworkz.hospitalapp.dto.StreetDTO;

public class Hospital {

		  public PatientDTO[] patients;
		  private int index;
		

		public Hospital(int size){
		  patients=new PatientDTO[size];
		  
		}
	


		public boolean createPatientDetails(PatientDTO patients){
		boolean patientAdded=false;
		System.out.println("inside createPatient()");
		if(patients!=null){
		  this.patients[index++]=patients;
		  patientAdded=true;
		}

		else{
		System.out.println("No Patient added");
		return patientAdded=false;
		}
		return patientAdded;
		}

		public void getAllPatients(){
		for(int i=0;i<patients.length;i++){
		System.out.println(patients[i]);
		}
		}
		
		

		public PatientDTO getPatientByName(String patientName){
		PatientDTO patientDTO=null;
		System.out.println("inside getPatientByName()");
		if(patientName!=null){
		   for(int i=0;i<patients.length;i++){
		     if(patients[i].getPatientName().equals(patientName)){
		System.out.println("Patient found by Name:"+patientName);
		   patientDTO=patients[i];
		     }
		  }
		}
		else{
		System.out.println("No Patient Found by Name:"+patientName);
		}
		return patientDTO;
		}

		public PatientDTO getPatientById(int patientId){
		PatientDTO patientDTO=null;
		System.out.println("inside getPatientById()");
		if(patientId!=0){
		   for(int i=0;i<patients.length;i++){
		     if(patients[i].getPatientId()==(patientId)){
		System.out.println("Patient found by PatientId:"+patientId);
		   patientDTO=patients[i];
		     }
		  }
		}
		else{
		System.out.println("No Patient Found by PatientId:"+patientId);
		}
		return patientDTO;
		}

		public PatientDTO getPatientByAge(int age){
		PatientDTO patientDTO=null;
		System.out.println("inside getPatientByAge()");
		if(age!=0){
		   for(int i=0;i<patients.length;i++){
		     if(patients[i].getAge()==(age)){
		System.out.println("Patient found by Age:"+age);
		   patientDTO=patients[i];
		     }
		  }
		}
		else{
		System.out.println("No Patient Found by Age:"+age);
		}
		return patientDTO;
		}

		public PatientDTO getPatientByAddress(String address){
		PatientDTO patientDTO=null;
		System.out.println("inside getPatientByAddress()");
		if(address!=null){
		   for(int i=0;i<patients.length;i++){
		     if(patients[i].getAddress().equals(address)){
		System.out.println("Patient found by Address:"+address);
		   patientDTO=patients[i];
		     }
		  }
		}
		else{
		System.out.println("No Patient Found by Address:"+address);
		}
		return patientDTO;
		}

		public PatientDTO getPatientByBloodGroup(String bloodGroup){
		PatientDTO patientDTO=null;
		System.out.println("inside getPatientByBloodGroup()");
		if(bloodGroup!=null){
		   for(int i=0;i<patients.length;i++){
		     if(patients[i].getBloodGroup().equals(bloodGroup)){
		System.out.println("Patient found by BloodGroup:"+bloodGroup);
		   patientDTO=patients[i];
		     }
		  }
		}
		else{
		System.out.println("No Patient Found by BloodGroup:"+bloodGroup);
		}
		return patientDTO;
		}

		public PatientDTO getPatientByContactNo(long contactNo){
		PatientDTO patientDTO=null;
		System.out.println("inside getPatientByContactNo()");
		if(contactNo!=0L){
		   for(int i=0;i<patients.length;i++){
		     if(patients[i].getContactNo()==(contactNo)){
		System.out.println("Patient found by ContactNo:"+contactNo);
		   patientDTO=patients[i];
		     }
		  }
		}
		else{
		System.out.println("No Patient Found by ContactNo:"+contactNo);
		}
		return patientDTO;
		}

		public PatientDTO getPatientByGender(char gender){
		PatientDTO patientDTO=null;
		System.out.println("inside getPatientByGender()");
		if(gender!='\u0000'){
		   for(int i=0;i<patients.length;i++){
		     if(patients[i].getGender()==(gender)){
		System.out.println("Patient found by Gender:"+gender);
		   patientDTO=patients[i];
		     }
		  }
		}
		else{
		System.out.println("No Patient Found by Gender:"+gender);
		}
		return patientDTO;
		}


		
		public PatientDTO getPatientByStreetName(String streetName1){
			PatientDTO patientDTO=null;
			System.out.println("inside getPatientByStreetName()");
			if(streetName1 != null){
			for(int i=0;i<patients.length;i++){
				
				
				
				System.out.println("================="+patients[i]);
			     if(patients[i].getAddress1().getCountry().getState().getDistrict().getArea().getStreet().getStreetName().equals(streetName1)){
			System.out.println("Patient found by street name:"+streetName1);
			   patientDTO=patients[i];
			   return patientDTO;
			     }
			     else{
						System.out.println("No Patient Found by street name:"+streetName1);
			  }
			}
			
			}
			return patientDTO;
			}
		
		
		public PatientDTO getPatientByState(String stateName){
			System.out.println("inside getPatientByState()");
			PatientDTO patientDTO=null;
			
			if(stateName!=null) {
		
			
			for(int i=0;i<patients.length;i++){
				/*PatientDTO patient=patients[i];
				AddressDTO address=patient.getAddress();
				CountryDTO country=address.getCountry();
				StateDTO state=country.getState();*/
				
				
			     if(patients[i].getAddress1().getCountry().getState().getStateName()==(stateName)){
			System.out.println("Patient found by state name:"+stateName);
			 patientDTO=patients[i];
			     }
			  }
			}
			else{
			System.out.println("No Patient Found by state name:"+stateName);
			}
			return patientDTO;
			}
		
		
		
		public PatientDTO getPatientByArea(String areaName){
			System.out.println("inside getPatientByArea()");
			PatientDTO patientDTO=null;
			
			if(areaName!=null){
			
			for(int i=0;i<patients.length;i++){
				PatientDTO patient=patients[i];
				AddressDTO address=patient.getAddress();
				CountryDTO country=address.getCountry();
				StateDTO state=country.getState();
				DistrictDTO  district=state. getDistrict();
				AreaDTO area=district.getArea();
				
			     if(patients[i].getAddress1().getCountry().getState().getDistrict().getArea().getAreaName()==(areaName)){
			System.out.println("Patient found by area name:"+areaName);
			patient=patients[i];
			     }
			  }
			}
			else{
			System.out.println("No Patient Found by area name:"+areaName);
			}
			return patientDTO;
			}
		
		
		public PatientDTO getPatientByStreetNO(int streetNO){
			System.out.println("inside getPatientByStreetNo()");
			PatientDTO patientDTO=null;
			
			
			if(streetNO!=0){
				
			for(int i=0;i<patients.length;i++){
				
				PatientDTO patient=patients[i];
				AddressDTO address=patient.getAddress();
				CountryDTO country=address.getCountry();
				StateDTO state=country.getState();
				DistrictDTO  district=state. getDistrict();
				AreaDTO area=district.getArea();
				StreetDTO street=area.getStreet();
				
			     if(street.getStreetNO()==streetNO){
			System.out.println("Patient found by street name:"+streetNO);
			patient=patients[i];
			     }
			  }
			}
			else{
			System.out.println("No Patient Found by street name:"+streetNO);
			}
			return patientDTO;
			}
		
		
		public void updatePatientContactNoById(int patientId,long contactNo){
			System.out.println("inside updatePatientsContactNoById()");
			if(patientId>0 && contactNo>0){
				for(int i=0; i<patients.length;i++){
				if(patients[i].getPatientId()==(patientId)){
			System.out.println("Patient contactNo updated by:"+contactNo);
			patients[i].setContactNo(contactNo);
			}
			}
			}

			else{
			System.out.println("Patient contactNo not updated");
			}
			}

			public void deletePatientById(int patientId){
			System.out.println("inside deletePatientById()");
			if(patientId>0){
				for(int i=0; i<patients.length;i++){
				if(patients[i].getPatientId()==(patientId)){
			System.out.println("Patient deleted by id:"+patientId);
			patients[i].setPatientId(patientId);
			}
			}
			}

			else{
			System.out.println("Patient is not deleted");
			}
			}
		
}
