class GasCylinder{

public String name;
public String color;
public String weight;
public int price;

public GasCylinder(String name, String color,String weight, int price){
System.out.println("GasCylinder object is created");
this.name=name;
this.color=color;
this.weight=weight;	
this.price=price;
}

public static void main(String a[]){
GasCylinder gas=new GasCylinder("Barath","Red","50kg",766);
System.out.println(gas.name+" "+gas.color+" "+gas.weight+" "+gas.price);
}
}
	