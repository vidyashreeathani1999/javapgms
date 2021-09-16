class Election{

public static String electionType="Lok Sabha";
public static int age=18;


public static boolean allow(String[] voterId){

System.out.println(" ");
boolean allowedToVote=false;

if(age>17){

    if(voterId!=null){
     allowedToVote=true;
        getVoterID(voterId);
         return allowedToVote;

 }
   else{

   System.out.println(" Age less than 18 cannot be allowed to vote");
 }

  }
    else{

    System.out.println("Please vote");
}

   return allowedToVote;
}
  public static void getVoterID(String[] voterId){

  for(int i=0;i<voterId.length;i++){

  System.out.println(voterId[i]);
}
}
}
    

