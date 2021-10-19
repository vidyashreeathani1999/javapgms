class GamesDTO{


public GamesDTO(){
System.out.println("Games Object is Created");
}

private int gameId;
private String name;
private int players;
private String gameType;

public int getGameId(){
return gameId;
}

public void setGameId(int gameId){
this.gameId=gameId;
}

public String getName(){
return name;
}

public void setName(String name){
this.name=name;
}

public int getPlayers(){
return players;
}

public void setPlayers(int players){
this.players=players;
}

public String getGameType(){
return gameType;
}

public void setGameType(String gameType){
this.gameType=gameType;
}

@Override
public String toString(){
return "GamesDTO-{gameId="+this.gameId+",name="+this.name+",players="+this.players+",gametype="+this.gameType+"}";
}
}