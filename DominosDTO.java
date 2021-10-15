class DominosDTO{

public void getDetailsOfDominos(){
System.out.println(getItemName()+" "+getLocation()+" "+getPrice());
}


 String itemName;
 int price;
 String location;


public String getItemName(){
return itemName;
}

public void setItemName(String itemName){
this.itemName=itemName;
}

public int getPrice(){
return price;
}

public void setPrice(int price){
this.price=price;
}

public String getLocation(){
return location;
}

public void setLocation(String location){
this.location=location;
}

@Override
public int hashCode(){
return price;
}
}
