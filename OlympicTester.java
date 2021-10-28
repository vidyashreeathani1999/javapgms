package com.xwork.olympic;

import java.util.*;
import com.xwork.olympic.dto.GamesDTO;

public class OlympicTester {

	
	public static void main(String a[]){


	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the size");
	int size = sc.nextInt();

	Olympic olympic = new Olympic(size);
	if(size>0) {
	for(int i=0;i<size;i++){

	GamesDTO dto = new GamesDTO();

	System.out.println("Enter the Game Details");
	System.out.println("Enter the GameId");
	int gameId=sc.nextInt();
	System.out.println("Enter the GameName");
	String gameName=sc.next();
	System.out.println("Enter the Players");
	int players=sc.nextInt(); 
	

	dto.setGameId(gameId);
	dto.setGameName(gameName);
	dto.setPlayers(players);
	

	boolean isAdded=olympic.addGameDetails(dto);
	System.out.println("gameAdded:"+isAdded);
	}

	olympic.getAllGames();
	
	
	int choice;
	String text;
	do {
	System.out.println("Press 1 to get all games ");	
	System.out.println("Press 2 to get Game Name");
	System.out.println("Press 3 to get Game Id");
	System.out.println("Enter your choice :-");
	choice=sc.nextInt();
	
	 
	switch(choice) {
	case 1: olympic.getAllGames();
	  break;
	  
	case 2:System.out.println("Enter the game Name");
	    	GamesDTO dto=olympic.getGameByName(sc.next());
	    	 if(dto!=null) {
	    		 System.out.println(dto);
	    		 
	    	 }
	    	 else {
	    		 System.out.println("No game found by Name");
	    	 }
	    	 break;
	case 3:System.out.println("Enter the game by Id");
	GamesDTO dto1=olympic.getGameById(sc.nextInt());
	       if(dto1!=null) {
	    	   System.out.println(dto1);
	       }
	       else {
	    	   System.out.println("No game found by Id");
	       }
	       
	       default:
	    	 System.out.println("invalid Choice");
	}
	       System.out.println("do want continue press y/n");
	       text=sc.next();
	       
	}  
	       while(text.equals("y"));
	
	System.out.println("Enter the game id and game name to update");
	int gameId=sc.nextInt();
	String gameName=sc.next();
     olympic.updateGameIdByGameName(gameName, gameId);

     olympic.getAllGames();

	System.out.println("Enter patient Id to delete");
	int id1=sc.nextInt();
	olympic.deleteGameById(id1);
	olympic.getAllGames();
	}

	}
}