package com.xworkz.gym;

import com.xworkz.gym.dto.EquipmentsDTO;

public class Gym {

		public EquipmentsDTO[] equipments ;
		  private int index;

		public Gym(int size){
			equipments =new EquipmentsDTO[size];
		}
		
		public boolean createGymEquipmentsDetails(EquipmentsDTO equipments){
			boolean equipmentsAdded=false;
			System.out.println("inside createGymEquipmentsDetails()");
			if(equipments!=null){
			  this.equipments[index++]=equipments;
			  equipmentsAdded=true;
			}

			else{
			System.out.println("No equipments added");
			return equipmentsAdded=false;
			}
			return equipmentsAdded;
			}
		
		public void getAllEquipments(){
			for(int i=0;i<equipments.length;i++){
			System.out.println(equipments[i]);
			}
			}
		
		public  EquipmentsDTO getEquipmentByName(String equipmentName){
			EquipmentsDTO  equipmentsDTO=null;
			System.out.println("inside  getEquipmentByName()");
			if(equipmentName!=null){
			   for(int i=0;i<equipments.length;i++){
			     if(equipments[i].getEquipmentsName().equals(equipmentName)){
			System.out.println("Equipment found by Name:"+equipmentName);
			equipmentsDTO=equipments[i];
			     }
			  
			else{
			System.out.println("No Equipment Found by Name:"+equipmentName);
			}
			   }
			}
			return equipmentsDTO;
			}


	public EquipmentsDTO getEquipmentById(int equipmentId){
		 EquipmentsDTO equipmentsDTO=null;
		System.out.println("inside getEquipmentById()");
		if(equipmentId!=0){
		   for(int i=0;i<equipments.length;i++){
		     if(equipments[i].getEquipmentsId()==(equipmentId)){
		System.out.println("Application found by Id:"+equipmentId);
		equipmentsDTO =equipments[i];
		     }
		  
		else{
		System.out.println("No Equipment Found by Id:"+equipmentId);
		}
		   }
		}
		return equipmentsDTO;
	}



	public void updateEquipmentNameByEquipmentId(String equipmentName,int equipmentId){
		System.out.println("inside updateEquipmentNameByEquipmentId()");
		if(equipmentId>0&&equipmentName!=null){
		   for(int i=0;i<equipments.length;i++){
		     if(equipments[i].getEquipmentsId()==(equipmentId)){
		System.out.println("Equipment Name updated by:"+equipmentName);
		equipments[i].setEquipmentsName(equipmentName);
		     }

		else{
		System.out.println("Equipment not updated");
		}
		   }
		}
	}


	public void deleteEquipmentById(int equipmentId){
		System.out.println("Inside deleteEquipmentById()");
		if(equipmentId > 0){
		for(int i=0; i<equipments.length; i++){
		if(equipments[i].getEquipmentsId()==(equipmentId)){
		System.out.println("Equipment deleted by id : "+equipmentId);
		equipments[i].setEquipmentsId(equipmentId);
		}
		
		
		else{
		System.out.println("Equipment is not deleted");
		}
		}
		}
				
	}


	}
