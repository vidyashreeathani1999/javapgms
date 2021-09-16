class IPL2020{
static String []teams= new String[7];

public static void main(String a[]){

teams[0]="RCB";
String teams[]= teams();
System.out.println(teams.length);
getTeamsName();
for(int s=0; s<teams.length; s++)
{
System.out.println(teams[s]);
}

public static String []getTeamsName(){

return teams();

}
}
