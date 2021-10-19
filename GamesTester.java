class GamesTester{

public static void main(String a[]){

GamesDTO game=new GamesDTO();
game.setGameId(688);
game.setName("Chess");
game.setPlayers(2);
game.setGameType("In door");
System.out.println(game.toString());

GamesDTO game1=new GamesDTO();
game1.setGameId(7657);
game1.setName("Table Tennis");
game1.setPlayers(2);
game1.setGameType("In door");
System.out.println(game1.toString());

GamesDTO game2=new GamesDTO();
game2.setGameId(134);
game2.setName("Gilli Danda");
game2.setPlayers(6);
game2.setGameType("Out door");
System.out.println(game2.toString());

GamesDTO game3=new GamesDTO();
game3.setGameId(8753);
game3.setName("Kabaddi");
game3.setPlayers(7);
game3.setGameType("Out door");
System.out.println(game3.toString());

GamesDTO game4=new GamesDTO();
game4.setGameId(766);
game4.setName("Kho Kho");
game4.setPlayers(9);
game4.setGameType("Out door");
System.out.println(game4.toString());
}
}