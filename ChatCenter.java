class ChatCenter{

String centerName;
int centerId;
String location;
String ownerName;
boolean isOpen;
String items[]={"Pani Puri", "Kachori", "Samosa", "Pav Bhaji", "Sandwich"};

public ChatCenter(){

this("Sai Chats", "near KLE Ground", 2, true, "Ranganna");
System.out.println("ChatCenter object is created");
}

public ChatCenter(String centerName, 
 			String location, int centerId, boolean isOpen, String ownerName){
this.centerName=centerName;
this.location=location;
this.items=items;
this.centerId=centerId;
this.ownerName=ownerName;
this.isOpen=isOpen;
}

public void displayChatCenterDetails(){
System.out.println(this.centerName+" "+this.centerId+" "+this.ownerName+" "+this.location+" "+this.isOpen);
}


public void getItems(){
for(int i=0;i<this.items.length;i++){
System.out.println(this.items[i]);
}
}
}