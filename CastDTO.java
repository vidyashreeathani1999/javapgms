package com.xworkz.movie.dto;

public class CastDTO {

	
	
		public CastDTO(){
			System.out.println(this.getClass().getSimpleName()+"object created");
			}

		private int castId;
		private String directorName;
		private String actorName;
		
		public boolean isAdded;

		public void setCastId(int castId){
		this.castId=castId;
		}

		public int getCastId(){
		return castId;
		}

		public void setDirectorName(String directorName){
		this.directorName=directorName;
		}

		public String getDirectorName(){
		return directorName;
		}

		public void setActorName(String actorName){
		this.actorName=actorName;
		}

		public String getActorName(){
		return actorName;
		}
		
		@Override
		public String toString(){
			return "CastDTO [CastId=" +this.castId + ", DirectorName=" +this.directorName + ", ActorName=" + this.actorName+ "}";
		}

		}


