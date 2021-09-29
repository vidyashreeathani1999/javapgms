class Transportation{

String vehicalName;
String vehicalNo;

public Transportation(){
this("Bus","KA20987");
System.out.println("Transportation object is created");
}

public Transportation(String vehicalName, String vehicalNo){
this.vehicalName=vehicalName;
this.vehicalNo=vehicalNo;
}

public void displayTransportationDetails(){
System.out.println(this.vehicalName+" "+this.vehicalNo);
}
}

