package com.xworkz.movie;
import java.util.*;

import com.xworkz.movie.dto.CastDTO;
public class MovieTester {
	
		public static void main(String a[]){


		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size");
		int size = sc.nextInt();

		Movie movie = new Movie(size);
		if(size>0) {
		for(int i=0;i<size;i++){

		CastDTO dto = new CastDTO();

		System.out.println("Enter the Cast Details");
		System.out.println("Enter the castId");
		int castId=sc.nextInt();
		System.out.println("Enter the actorName");
		String actorName=sc.next();
		System.out.println("Enter the directorName");
		String directorName=sc.next(); 
		

		dto.setCastId(castId);
		dto.setActorName(actorName);
		dto.setDirectorName(directorName);
		

		boolean isAdded=movie.addCastDetails(dto);
		System.out.println("CastAdded:"+isAdded);
		}

		movie.getAllCasts();
		
		
		int choice;
		String text;
		do {
		System.out.println("Press 1 to get all casts ");	
		System.out.println("Press 2 to get actor Name");
		System.out.println("Press 3 to get cast Id");
		System.out.println("Enter your choice :-");
		choice=sc.nextInt();
		
		 
		switch(choice) {
		case 1: movie.getAllCasts();
		  break;
		  
		case 2:System.out.println("Enter the directorName");
		    	CastDTO dto=movie.getCastByDirectorName(sc.next());
		    	 if(dto!=null) {
		    		 System.out.println(dto);
		    		 
		    	 }
		    	 else {
		    		 System.out.println("No cast found by directorName");
		    	 }
		    	 break;
		case 3:System.out.println("Enter the cast by Id");
		CastDTO dto1=movie.getCastById(sc.nextInt());
		       if(dto1!=null) {
		    	   System.out.println(dto1);
		       }
		       else {
		    	   System.out.println("No cast found by Id");
		       }
		       
		       default:
		    	 System.out.println("invalid Choice");
		}
		       System.out.println("do want continue press y/n");
		       text=sc.next();
		       
		}  
		       while(text.equals("y"));
		
		System.out.println("Enter the cast id and actor name to update");
		int castId=sc.nextInt();
		String actorName=sc.next();
		movie.updateCastIdByActorName(actorName, castId);

	     movie.getAllCasts();

		System.out.println("Enter cast Id to delete");
		int id1=sc.nextInt();
		movie.deleteCastById(id1);
		movie.getAllCasts();
		}

		}
	}