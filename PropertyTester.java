class PropertyTester{

public static void main(String a[]){
System.out.println("Main method is started");

PropertyDTO dto=new PropertyDTO();
dto.setPropertyId(6353788);
dto.setPropertyName("Tarun");
dto.setLocation("Mudhol");
dto.setAmount(400000);
dto.getDetailsOfProperty();

System.out.println(dto.hashCode());
System.out.println("Main method is ended");
System.out.println("Default value of hashcode"+dto.hashCode());
}
}
