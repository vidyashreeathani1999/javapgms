class DominosTester{


public static void main(String a[]){
System.out.println("Main method is started");
DominosDTO dto=new DominosDTO();
dto.setItemName("Dominos Pizza");
dto.setLocation("Mantri Mall");
dto.setPrice(267);
dto.getDetailsOfDominos();


System.out.println(dto.toString());
System.out.println("Main method is ended");
System.out.println("Default value of String"+dto.toString());
}
}