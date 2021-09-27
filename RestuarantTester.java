//Constructor
class RestuarantTester{

public static void main(String a[]){

Restuarant rest=new Restuarant();
rest.restuarantName="1947";
rest.type="veg";
rest.location="Malleshwaram";
rest.ownerName="Sadanand Gowda";
rest.restuarantId=467;

rest.serveFood();
rest.displayRestuarantDetails();

Restuarant rest1=new Restuarant();
rest1.restuarantName="Empire";
rest1.type="Non veg";
rest1.location="Kormangala";
rest1.ownerName="Somesh";
rest1.restuarantId=139;

System.out.println(rest1.restuarantName+" "+rest1.type+" "+rest1.location+" "+rest1.ownerName+" "+rest1.restuarantId);


}
}
