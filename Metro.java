class Metro{

String metroName;
String location;

String stationName[]={"Mahakavi Kuvempu Road","Kempegowda"};

public Metro(){
this("Namma Metro","Bangalore");
System.out.println("Metro object is created");
}

public Metro(String metroName, String location){
this.metroName=metroName;
this.location=location;
}
public void displayMetroDetails(){
System.out.println(this.metroName+" "+this.location);
}
public void getStationName(){
for(int i=0;i<=this.stationName.length;i++){
System.out.println(this.stationName[i]);
}
}
}