class DrivingLicenseTester{


public static void main(String a[]){

System.out.println("Main method started");
DrivingLicDTO dto=new DrivingLicDTO();
dto.setDrivingLicId(8789);
dto.setType("Car");
dto.setOwnerName("Santosh");
dto.getDetailsOfDrivingLic();
System.out.println(dto.hashCode());
System.out.println("Main method ended");
System.out.println("Default value of hashCode:"+dto.hashCode());
}
}