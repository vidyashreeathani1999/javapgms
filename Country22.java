class Country22
{
static String []countryName = new String[7];

public static void main(String a[])
{

countryName[0]="India"; 
countryName[1]="Shri Lanka"; 
countryName[2]="England" ;
countryName[3]="South Africa";
countryName[4]="USA";
countryName[5]="Pakistan";
countryName[6]="China";
getCountryName();
}

public static void getCountryName()
{
System.out.println(countryName.length);
for(int z=0; z<countryName.length; z++)
{
System.out.println(countryName[z] +" ");

}

}
}