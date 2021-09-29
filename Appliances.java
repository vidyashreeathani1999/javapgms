class Appliances{

String shopName;
String ownerName;
String place;
boolean isOpen;

String items[]={"Microwave","Dishwasher","Blender","Slow Cooker"};

public Appliances(){

this("Laxmi","Tarun","Mudhol",true);
System.out.println("Appliances object is created");
}

public Appliances(String shopName, String ownerName,String place,boolean isOpen){
this.shopName=shopName;
this.ownerName=ownerName;
this.place=place;
this.isOpen=isOpen;
}

public void displayAppliancesDetails(){
System.out.println(this.shopName+" "+ this.ownerName+" " + this.place+" " +this.isOpen);
}

public void getItems(){
for(int i=0;i<this.items.length;i++){
System.out.println(this.items[i]);
}
}
}

