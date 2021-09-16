class ShoppingMalls2{
static String[] malls=new String[3];


public static void main(String a[]){
malls[0]="Mantri mall";
malls[1]="Orian mall";
malls[2]="Garuda";
getMallNames();
}
public static void getMallNames()
{
System.out.println(malls.length);
for(int j=0; j<malls.length; j++)
{
System.out.println(malls[j]+"");
}
}
}


