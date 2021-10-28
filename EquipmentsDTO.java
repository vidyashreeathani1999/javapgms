package com.xworkz.gym.dto;

public class EquipmentsDTO {

		public EquipmentsDTO(){
			System.out.println(this.getClass().getSimpleName()+"object created");
			}

		private int equipmentsId;
		private String equipmentsName;
		
		
		


		public void setEquipmentsId(int equipmentsId){
		this.equipmentsId=equipmentsId;
		}

		public int getEquipmentsId(){
		return equipmentsId;
		}

		public void setEquipmentsName(String equipmentsName){
		this.equipmentsName=equipmentsName;
		}

		public String getEquipmentsName(){
		return equipmentsName;
		}


		
		@Override
		public String toString() {
			return "EquipmentsDTO--- {EquipmentsId=" +this.equipmentsId+ ", EquipmentsName=" +this.equipmentsName +"}";
		}

	}
