class DrivingLicDTO{

public void getDetailsOfDrivingLic(){
System.out.println(getDrivingLicId()+" "+getType()+" "+getOwnerName());
}


private int drivingLicId;
private String type;
private String ownerName;


public int getDrivingLicId(){
return drivingLicId;
}

public void setDrivingLicId(int drivingLicId){
this.drivingLicId=drivingLicId;
}

public String getType(){
return type;
}

public void setType(String type){
this.type=type;
}

public String getOwnerName(){
return ownerName;
}

public void setOwnerName(String ownerName){
this.ownerName=ownerName;
}

@Override
public int hashCode(){
return drivingLicId;
}
}
