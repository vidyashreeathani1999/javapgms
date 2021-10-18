class DrivingLicDTO{

public void getDetailsOfDrivingLic(){
System.out.println(getDrivingLicId()+" "+getType()+" "+getOwnerName());
}


int drivingLicId;
 String type;
 String ownerName;


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
public String toString(){
return "DrivingLicDto-{drivingLicId="+this.drivingLicId+",type="+this.type+",ownerName="+this.ownerName+"}";
}
}
