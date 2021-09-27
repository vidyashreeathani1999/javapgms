class Showroom{

public String name;
public String location;

public Showroom(String name,String location){
System.out.println("Showroomobject is created");
this.name=name;
this.location=location;
}

public static void main(String a[]){
Showroom showroom=new Showroom("Kumar","Mudhol");
System.out.println(showroom.name+" "+showroom.location);
}
}
	