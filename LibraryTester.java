class LibraryTester{


public static void main(String a[]){

System.out.println("Main method is started");
LibraryDTO dto=new LibraryDTO();
dto.setLibraryId(898769);
dto.setTypeOfLibrary("College");
dto.setLibraryName("BGMIT");
dto.getDetailsOfLibrary();
System.out.println(dto.toString());
System.out.println("Main method is ended");
System.out.println("Default value of String"+dto.toString());
}
}