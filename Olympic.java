package com.xwork.olympic;

import com.xwork.olympic.dto.GamesDTO;

public class Olympic {

	public GamesDTO[] game;
	  private int index;
	  
	  
      
	public Olympic(int size){
	  game=new GamesDTO[size];
	  
	}

	public boolean addGameDetails(GamesDTO game){
	boolean gameAdded=false;
	System.out.println("inside add game details");
	if(game!=null){
	  this.game[index++]=game;
	  gameAdded=true;
	}

	else{
	System.out.println("No game added");
	return gameAdded=false;
	}
	return gameAdded;
	}

	public void getAllGames(){
	for(int i=0;i<game.length;i++){
	System.out.println(game[i]);
	}
	}
	
	
	public GamesDTO getGameById(int gameId){
		GamesDTO gameDTO=null;
		System.out.println("inside get game by name");
		if(gameId!=0){
		   for(int i=0;i<game.length;i++){
		     if(game[i].getGameName().equals(gameId)){
		System.out.println("Game found by Id:"+gameId);
		   gameDTO=game[i];
		     }
		  
		else{
		System.out.println("No Game Found by Id:"+gameId);
		}
		   }
		}
		return gameDTO;
		}

	public GamesDTO getGameByName(String gameName){
	GamesDTO gameDTO=null;
	System.out.println("inside get game by name");
	if(gameName!=null){
	   for(int i=0;i<game.length;i++){
	     if(game[i].getGameName().equals(gameName)){
	System.out.println("Game found by Name:"+gameName);
	   gameDTO=game[i];
	     }
	  
	else{
	System.out.println("No Game Found by Name:"+gameName);
	}
	   }
	}
	return gameDTO;
	}

	

	public GamesDTO getGameByPlayers(int players){
		GamesDTO gameDTO=null;
		System.out.println("inside get game by name");
		if(players!=0){
		   for(int i=0;i<game.length;i++){
		     if(game[i].getPlayers()==(players)){
		System.out.println("Game found by players:"+players);
		   gameDTO=game[i];
		     }
		  
		else{
		System.out.println("No Game Found by players:"+players);
		}
		   }
		}
		return gameDTO;
		}
	
	
     
    
public void updateGameIdByGameName(String gameName,int gameId){
	System.out.println("inside update game name by id ");
	if(gameId>0&&gameName!=null){
	   for(int i=0;i<game.length;i++){
	     if(game[i].getGameId()==(gameId)){
	System.out.println("Game gameName updated by:"+gameName);
	   game[i].setGameName(gameName);
	     }
	  }
	}

	else{
	System.out.println("Game gameName not updated");
	}
	}

public void deleteGameById(int gameId){
	System.out.println("Inside delete game by id");
	if(gameId > 0){
	for(int i=0; i<game.length; i++){
	if(game[i].getGameId()==(gameId)){
	System.out.println("Game deleted by id : "+gameId);
	game[i].setGameId(gameId);
	}
	}
	}
	else
	{
	System.out.println("Game is not deleted");
	}
	
	}
}
	
	
	
	
	
	
	

