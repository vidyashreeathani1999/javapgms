class GoldUtil{


public static void main(String a[]){

System.out.println("Main method is started");
GoldDTO dto=new GoldDTO();
dto.setGoldId(234456);
dto.setWeight("8Kg");
dto.setPrice(70000);
dto.getDetailsOfGold();
System.out.println(dto.toString());
System.out.println("Main method is ended");

System.out.println("Default value of String"+dto.toString());
}
}