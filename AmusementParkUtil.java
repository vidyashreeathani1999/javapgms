class AmusementParkUtil{

public static void main(String a[]){

AmusementPark amusementPark=new AmusementPark();
amusementPark.amusementParkName="Magic Kingdom Theme Park at Walt Disney World Resort";
amusementPark.location="Florida";
System.out.println(amusementPark.amusementParkName+" "+amusementPark.location);
amusementPark.famous();


AmusementPark amusementPark1=new AmusementPark();
amusementPark1.amusementParkName="Disneyland Park";
amusementPark1.location="California";
System.out.println(amusementPark1.amusementParkName+" "+amusementPark1.location);
amusementPark1.famous();


AmusementPark amusementPark2=new AmusementPark();
amusementPark2.amusementParkName="Tokyo Disneyland";
amusementPark2.location="Japan"; 
System.out.println(amusementPark2.amusementParkName+" "+amusementPark2.location);
amusementPark2.famous();

}
}