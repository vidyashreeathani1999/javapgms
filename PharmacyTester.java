class PharmacyTester{


public static void main(String a[]){
System.out.println("Main method started");

PharmacyDTO dto=new PharmacyDTO();
dto.setPharmacyName("MedPlus");
dto.setLocation("Gayathrinagar");
dto.setPharmacyId(26789);
dto.getPharmacyDetails();

System.out.println(dto.hashCode());
System.out.println("Main method ended");
System.out.println("Default value of hashcode"+dto.hashCode());
}
}