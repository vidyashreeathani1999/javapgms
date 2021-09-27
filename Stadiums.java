class Stadiums{

public String name;
public String location;
public int noofseats;

public Stadiums(String name,String location,int noofseats){
System.out.println("Stadiums object is created");
this.name=name;
this.location=location;
this.noofseats=noofseats;
}

public static void main(String a[]){
Stadiums stadiums=new Stadiums("Ranna","Mudhol",1000);
System.out.println(stadiums.name+" "+stadiums.location+" "+stadiums.noofseats);
}
}
	