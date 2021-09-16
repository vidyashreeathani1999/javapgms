class Airport22{
static String airportNames[]=new String[3];

public static void main(String a[]){
airportNames[0]="Belgaum"; 
airportNames[1]="Bellary";
airportNames[3]="Kempegowda International";
 
getAirportName();

}

public static void getAirportName()
{
System.out.println(airportNames.length);
for(int j=0; j<airportNames.length; j++)
{
System.out.println(airportNames[j]+"");
}

}
}