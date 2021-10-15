class PropertyDTO{

public void getDetailsOfProperty(){
System.out.println(getPropertyId()+" "+getPropertyName()+" "+getLocation()+" "+getAmount());
}

 int propertyId;
 String propertyName;
 String location;
 long amount;

public int getPropertyId(){
return propertyId;
}

public void setPropertyId(int propertyId){
this.propertyId=propertyId;
}

public String getPropertyName(){
return propertyName;
}

public void setPropertyName(String propertyName){
this.propertyName=propertyName;
}

public String getLocation(){
return location;
}

public void setLocation(String location){
this.location=location;
}

public long getAmount(){
return amount;
}

public void setAmount(long amount){
this.amount=amount;
}

@Override
public int hashCode(){
return propertyId;
}
}
