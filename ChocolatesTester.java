class ChocolatesTester{

public static void main(String a[]){

Chocolates chocolates=new Chocolates();
chocolates.chocolateName="Kit Kat";
chocolates.price=5;


System.out.println(chocolates.chocolateName+" "+chocolates.price);
chocolates.eat();

Chocolates chocolates1=new Chocolates();
chocolates1.chocolateName="Parle";
chocolates1.price=1;

System.out.println(chocolates1.chocolateName+" "+chocolates1.price);
chocolates1.eat();

Chocolates chocolates2=new Chocolates();
chocolates2.chocolateName="Dark";
chocolates2.price=2;


System.out.println(chocolates2.chocolateName+" "+chocolates2.price);
chocolates2.eat();

}
}