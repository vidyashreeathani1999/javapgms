class PatientDTO{

public PatientDTO(){
System.out.println(this.getClass().getSimpleName()+"object created");
}

   private int patientId;
   private String patientName;
   private long contactNo;
   private String address;
   private String bloodGroup;
   private int age;
   private char gender;

public void setPatientId(int patientId){
this.patientId=patientId;
}

public int getPatientId(){
return patientId;
}

public void setPatientName(String patientName){
this.patientName=patientName;
}

public String getPatientName(){
return patientName;
}

public void setContactNo(long contactNo){
this.contactNo=contactNo;
}

public long getContactNo(){
return contactNo;
}

public void setAddress(String address){
this.address=address;
}

public String getAddress(){
return address;
}

public void setBloodGroup(String bloodGroup){
this.bloodGroup=bloodGroup;
}

public String getBloodGroup(){
return bloodGroup;
}

public void setAge(int age){
this.age=age;
}

public int getAge(){
return age;
}

public void setGender(char gender){
this.gender=gender;
}

public char getGender(){
return gender;
}

@Override
public String toString(){
return"PatientDTO-{patientId="+this.patientId+",patientName="+this.patientName+",contactNo="+this.contactNo+",address="+this.address+",bloodGroup="+this.bloodGroup+",age="+this.age+",gender="+this.gender+"}";
}
}