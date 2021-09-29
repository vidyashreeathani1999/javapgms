class FancyStore{

String storeName;
String location;

public FancyStore(){

this("Fancy Fantasy","Bagalkot");
System.out.println("FancyStore Object is Created");
}

public FancyStore(String storeName,String location){
this.storeName=storeName;
this.location=location;
}
public void displayFancyStoreDetails(){

System.out.println(this.storeName+" "+this.location);
}
}




