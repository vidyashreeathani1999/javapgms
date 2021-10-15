class PatientDTO{


 int patientId;
 String patientName;
 int age;
 String gender;    
 String address;   
 String bloodGroup;

public void getDetailsOfPatient(){
System.out.println(getPatientId()+" "+getPatientName()+" "+getAge()+" "+getGender()+" "+getAddress()+" "+getBloodGroup());
}

public int getPatientId(){
return patientId;
}

public void setPatientId(int patientId){
this.patientId=patientId;
}

public String getPatientName(){
return patientName;
}

public void setPatientName(String patientName){
this.patientName=patientName;
}

public int getAge(){
return age;
}

public void setAge(int age){
this.age=age;
}

public String getGender(){
return gender;
}

public void setGender(String gender){
this.gender=gender;
}

public String getAddress(){
return address;
}

public void setAddress(String address){
this.address=address;
}

public String getBloodGroup(){
return bloodGroup;
}

public void setBloodGroup(String bloodGroup){
this.bloodGroup=bloodGroup;
}

@Override
public int hashCode(){
return patientId;
}
}