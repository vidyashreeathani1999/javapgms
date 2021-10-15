class LicTester{


public static void main(String a[]){
System.out.println("Main method is started");
LicDTO dto=new LicDTO();
dto.setLicId(57677);
dto.setAgentName("Ragu");
dto.setCustomerName("Prakash");
dto.setYear("28/8/2021");
dto.getLicDetails();
System.out.println(dto.hashCode());
System.out.println("Main method is ended");
System.out.println("Default value of hashcode"+dto.hashCode());
}

}