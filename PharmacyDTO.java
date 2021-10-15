class PharmacyDTO{

 String pharmacyName;
 String location;
 int pharmacyId;

public void getPharmacyDetails(){
System.out.println(getPharmacyName()+" "+getPharmacyId()+" "+getLocation());

}

public String getPharmacyName(){
return pharmacyName;
}

public void setPharmacyName(String pharmacyName){
this.pharmacyName=pharmacyName;
}

public String getLocation(){
return location;
}

public void setLocation(String location){
this.location=location;
}

public int getPharmacyId(){
return pharmacyId;
}

public void setPharmacyId(int pharmacyId){
this.pharmacyId=pharmacyId;
}

@Override
public int hashCode(){
return pharmacyId;
}
}
