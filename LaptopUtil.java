class LaptopUtil{

public static void main(String a[]){

Laptop laptop=new Laptop();
 laptop.brandName="HP";
 laptop.price=42000;
 laptop.length=32;
 laptop.processor="11th Gen Intel Core i5 Processor";

System.out.println(laptop.brandName+" "+laptop.price+ " " +laptop.length+" "+laptop.processor);
laptop.quality();


Laptop laptop1=new Laptop();
 laptop1.brandName="Lenovo";
 laptop1.price=38000;
 laptop1.length=30;
 laptop1.processor="11th Gen Intel Core i3 Processor";
System.out.println(laptop1.brandName+" "+laptop1.price+ " " +laptop1.length+" "+laptop1.processor);
laptop1.quality();


Laptop laptop2=new Laptop();
 laptop2.brandName="Dell";
 laptop2.price=35000;
 laptop2.length=28;
 laptop2.processor="10th Gen Intel Core i3 Processor";
System.out.println(laptop2.brandName+" "+laptop2.price+ " " +laptop2.length+" "+laptop2.processor);
laptop2.quality();
}
}