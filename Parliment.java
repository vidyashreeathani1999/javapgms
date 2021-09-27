class Parliment{


public String memberName;
public String partyName;
public int votes;

public Parliment(){
System.out.println("Parliment object is created");
}

public void assembly(){
System.out.println("Members are assembled in parliment");
}

public void displayParlimentDetails(){
System.out.println(memberName+" "+partyName+" "+votes);
}
}
