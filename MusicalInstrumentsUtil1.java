//Constructor
class MusicalInstrumentsUtil1{


public static void main(String a[]){

MusicalInstruments music=new MusicalInstruments("Guitar", 4000.89, "20hz", "Western");
System.out.println(music.name+" "+music.price+" "+music.frequency+" "+music.type);
music.play(music.name); 

MusicalInstruments music1=new MusicalInstruments();

	music1.name ="Violin";
	music1.price=4999.00;
	music1.frequency="10hz";
	music1.type="don't know";

System.out.println(music1.name+" "+music1.price+" "+music1.frequency+" "+music1.type);
music1.play(music.name); 




 }
}