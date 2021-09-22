class BagUtil{

public static void main(String a[]){

Bags bag=new Bags();
 bag.brandName="Da Milano";
 bag.price=900;
 
System.out.println(bag.brandName+" "+bag.price);
bag.quality();

Bags bag1=new Bags();
 bag1.brandName="Hidesign";
 bag1.price=400;
 
System.out.println(bag1.brandName+" "+bag1.price);
bag1.quality();

Bags bag2=new Bags();
 bag2.brandName="Baggit";
 bag2.price=200;
 
System.out.println(bag2.brandName+" "+bag2.price);
bag2.quality();


}
}