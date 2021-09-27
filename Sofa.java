class Sofa{

public String brandName;
public String color;
public int price;

public Sofa(String brandName, String color, int price){
System.out.println("Sofa object is created");
this.brandName=brandName;
this.color=color;
this.price=price;
}

public static void main(String a[]){
Sofa sofa=new Sofa("VIP","Cream",24566);
System.out.println(sofa.brandName+" "+sofa.color+" "+sofa.price);
}
}
	