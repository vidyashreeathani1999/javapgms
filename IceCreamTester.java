class IceCreamTester{

public static void main(String a[]){

IceCreams iceCream=new IceCreams();
 iceCream.iceCreamName="Vanilla";
 iceCream.price=76;

 
System.out.println(iceCream.iceCreamName+" "+iceCream.price);
iceCream.eat();


IceCreams iceCream1=new IceCreams();
 iceCream1.iceCreamName="Vanilla";
 iceCream1.price=56;

 
System.out.println(iceCream1.iceCreamName+" "+iceCream1.price);
iceCream1.eat();

IceCreams iceCream2=new IceCreams();
 iceCream2.iceCreamName="Vanilla";
 iceCream2.price=89;

 
System.out.println(iceCream2.iceCreamName+" "+iceCream2.price);
iceCream2.eat();



}
}