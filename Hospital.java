class Hospital{

  public PatientDTO[]patients;
  private int index;

public Hospital(int size){
  patients=new PatientDTO[size];
}

public boolean createPatientDetails(PatientDTO patients){
boolean patientAdded=false;
System.out.println("inside createPatient()");
if(patients!=null){
  this.patients[index++]=patients;
  patientAdded=true;
}

else{
System.out.println("No Patient added");
return patientAdded=false;
}
return patientAdded;
}

public void getAllPatients(){
for(int i=0;i<patients.length;i++){
System.out.println(patients[i]);
}
}

public PatientDTO getPatientByName(String patientName){
PatientDTO patientDTO=null;
System.out.println("inside getPatientByName()");
if(patientName!=null){
   for(int i=0;i<patients.length;i++){
     if(patients[i].getPatientName().equals(patientName)){
System.out.println("Patient found by Name:"+patientName);
   patientDTO=patients[i];
     }
  }
}
else{
System.out.println("No Patient Found by Name:"+patientName);
}
return patientDTO;
}

public PatientDTO getPatientById(int patientId){
PatientDTO patientDTO=null;
System.out.println("inside getPatientById()");
if(patientId!=0){
   for(int i=0;i<patients.length;i++){
     if(patients[i].getPatientId()==(patientId)){
System.out.println("Patient found by PatientId:"+patientId);
   patientDTO=patients[i];
     }
  }
}
else{
System.out.println("No Patient Found by PatientId:"+patientId);
}
return patientDTO;
}

public PatientDTO getPatientByAge(int age){
PatientDTO patientDTO=null;
System.out.println("inside getPatientByAge()");
if(age!=0){
   for(int i=0;i<patients.length;i++){
     if(patients[i].getAge()==(age)){
System.out.println("Patient found by Age:"+age);
   patientDTO=patients[i];
     }
  }
}
else{
System.out.println("No Patient Found by Age:"+age);
}
return patientDTO;
}

public PatientDTO getPatientByAddress(String address){
PatientDTO patientDTO=null;
System.out.println("inside getPatientByAddress()");
if(address!=null){
   for(int i=0;i<patients.length;i++){
     if(patients[i].getAddress().equals(address)){
System.out.println("Patient found by Address:"+address);
   patientDTO=patients[i];
     }
  }
}
else{
System.out.println("No Patient Found by Address:"+address);
}
return patientDTO;
}

public PatientDTO getPatientByBloodGroup(String bloodGroup){
PatientDTO patientDTO=null;
System.out.println("inside getPatientByBloodGroup()");
if(bloodGroup!=null){
   for(int i=0;i<patients.length;i++){
     if(patients[i].getBloodGroup().equals(bloodGroup)){
System.out.println("Patient found by BloodGroup:"+bloodGroup);
   patientDTO=patients[i];
     }
  }
}
else{
System.out.println("No Patient Found by BloodGroup:"+bloodGroup);
}
return patientDTO;
}

public PatientDTO getPatientByContactNo(long contactNo){
PatientDTO patientDTO=null;
System.out.println("inside getPatientByContactNo()");
if(contactNo!=0L){
   for(int i=0;i<patients.length;i++){
     if(patients[i].getContactNo()==(contactNo)){
System.out.println("Patient found by ContactNo:"+contactNo);
   patientDTO=patients[i];
     }
  }
}
else{
System.out.println("No Patient Found by ContactNo:"+contactNo);
}
return patientDTO;
}

public PatientDTO getPatientByGender(char gender){
PatientDTO patientDTO=null;
System.out.println("inside getPatientByGender()");
if(gender!='\u0000'){
   for(int i=0;i<patients.length;i++){
     if(patients[i].getGender()==(gender)){
System.out.println("Patient found by Gender:"+gender);
   patientDTO=patients[i];
     }
  }
}
else{
System.out.println("No Patient Found by Gender:"+gender);
}
return patientDTO;
}


public void updatePatientContactNoById(int patientId,long contactNo){
System.out.println("inside updatePatientsContactNoById()");
if(patientId>0 && contactNo>0){
	for(int i=0; i<patients.length;i++){
	if(patients[i].getPatientId()==(patientId)){
System.out.println("Patient contactNo updated by:"+contactNo);
patients[i].setContactNo(contactNo);
}
}
}

else{
System.out.println("Patient contactNo not updated");
}
}

public void deletePatientById(int patientId){
System.out.println("inside deletePatientById()");
if(patientId>0){
	for(int i=0; i<patients.length;i++){
	if(patients[i].getPatientId()==(patientId)){
System.out.println("Patient deleted by id:"+patientId);
patients[i].setPatientId(patientId);
}
}
}

else{
System.out.println("Patient is not deleted");
}
}


}
