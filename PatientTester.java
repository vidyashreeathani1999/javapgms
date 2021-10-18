class PatientTester{

public static void main(String []args){
System.out.println("main method started");

PatientDTO dto=new PatientDTO();
dto.setPatientId(8976554);
dto.setPatientName("Dev");
dto.setAge(35);
dto.setGender("Male");
dto.setAddress("Nagarbhvi Circle");
dto.setBloodGroup("B+");
dto.getDetailsOfPatient();

System.out.println(dto.toString());
System.out.println("main method ended");
System.out.println("Default value of String"+dto.toString());


}
}
