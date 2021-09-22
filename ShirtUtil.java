class ShirtUtil{

public static void main(String a[]){

Shirt shirt=new Shirt();
 shirt.brandName="Allen Solly";
 shirt.price=700;
 shirt.color="Blue";
 

System.out.println(shirt.brandName+" "+shirt.price+ " " +shirt.color);
shirt.quality();

Shirt shirt1=new Shirt();
 shirt1.brandName="Tommy Hilfiger";
 shirt1.price=600;
 shirt1.color="Black";
 

System.out.println(shirt1.brandName+" "+shirt1.price+ " " +shirt1.color);
shirt1.quality();


}
}