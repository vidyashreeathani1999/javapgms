class WatchFactory1{
static String[] watchBrands={"Titan", "Timex", "Casio", "Rolex", "Guess", "Fossil", "Giordano"};
static int[] amount={5000,3000,2000,1000,800,7000,9000};

public static void main(String a[]){

for(int j=0; j<watchBrands.length; j++)
{
System.out.println(watchBrands[j] );
}

for(int k=0;k<amount.length;k++)
{
System.out.println(amount[k]);
}
}
}