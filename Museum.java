class Museum{

String museumName;
String location;

public Museum(){

this("Government Museum","Bengaluru");
System.out.println("Museum Object is Created");
}

public Museum(String museumName,String location){

this.museumName=museumName;
this.location=location;

}
public void displayMuseumDetails(){
System.out.println(this.museumName+" " +this.location);
}
}
