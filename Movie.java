package com.xworkz.movie;

import com.xworkz.movie.dto.CastDTO;

public class Movie {

	
		public CastDTO[] cast;
		  private int index;
		  
		  
	      
		public Movie(int size){
		  cast=new CastDTO[size];
		  
		}
		

		public boolean addCastDetails(CastDTO cast){
		boolean castAdded=false;
		System.out.println("inside add cast details");
		if(cast!=null){
		  this.cast[index++]=cast;
		 
		  castAdded=true;
		}

		else{
		System.out.println("No cast added");
		return castAdded=false;
		}
		return castAdded;
		}

		public void getAllCasts(){
		for(int i=0;i<cast.length;i++){
		System.out.println(cast[i]);
		}
		}
		
		
		public CastDTO getCastById(int castId){
			CastDTO castDTO=null;
			System.out.println("inside get cast by cast id");
			if(castId!=0){
			   for(int i=0;i<cast.length;i++){
			     if(cast[i].getCastId()==(castId)){
			System.out.println("cast found by Id:"+castId);
			  castDTO=cast[i];
			     }
			  
			else{
			System.out.println("No Cast Found by Id:"+castId);
			}
			   }
			}
			return castDTO;
			}
		

		public CastDTO getCastByDirectorName(String directorName){
			CastDTO castDTO=null;
		System.out.println("inside get game by name");
		if(directorName!=null){
		   for(int i=0;i<cast.length;i++){
		     if(cast[i].getDirectorName().equals(directorName)){
		System.out.println("Cast found by DirectorName:"+directorName);
		castDTO=cast[i];
		     }
		  
		else{
		System.out.println("No Cast Found by DirectorName:"+directorName);
		}
		   }
		}
		return castDTO;
		}

		

		public CastDTO getCastByActorname(int actorName){
			CastDTO castDTO=null;
			System.out.println("inside get game by name");
			if(actorName!=0){
			   for(int i=0;i<cast.length;i++){
			     if(cast[i].getActorName().equals(actorName)){
			System.out.println("Cast found by actorName:"+actorName);
			castDTO=cast[i];
			     }
			  
			else{
			System.out.println("No Cast Found by actorName:"+actorName);
			}
			   }
			}
			return castDTO;
			}
		
		
	     
	    
	public void updateCastIdByActorName(String actorName,int castId){
		System.out.println("inside update cast id by actor name ");
		if(castId>0&&actorName!=null){
		   for(int i=0;i<cast.length;i++){
		     if(cast[i].getCastId()==(castId)){
		System.out.println("Cast by actorName updated by:"+actorName);
		   cast[i].setActorName(actorName);
		     }
		  }
		}

		else{
		System.out.println("cast by actorName not updated");
		}
		}

	public void deleteCastById(int castId){
		System.out.println("Inside delete game by id");
		if(castId > 0){
		for(int i=0; i<cast.length; i++){
		if(cast[i].getCastId()==(castId)){
		System.out.println("cast deleted by id : "+castId);
		cast[i].setCastId(castId);
		}
		}
		}
		else
		{
		System.out.println("cast is not deleted");
		}
		
		}
	}
		
		
		
		
		
		
		

