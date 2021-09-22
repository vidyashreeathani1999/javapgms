class ShoeUtil{

public static void main(String a[]){

Shoe shoe=new Shoe();
 shoe.brandName="Nike";
 shoe.price=420;
 

System.out.println(shoe.brandName+" "+shoe.price);
shoe.quality();

Shoe shoe1=new Shoe();
 shoe1.brandName="Adidas";
 shoe1.price=700;
 

System.out.println(shoe1.brandName+" "+shoe1.price);
shoe1.quality();

Shoe shoe2=new Shoe();
 shoe2.brandName="Reebok";
 shoe2.price=500;
 

System.out.println(shoe2.brandName+" "+shoe2.price);
shoe2.quality();



}
}