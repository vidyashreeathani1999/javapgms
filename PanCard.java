class PanCard
{
public static String pancardIssuedBy="Income Tax";
public static int age = 18;

public static boolean allow(String[] adharCard){

System.out.println(" ");
boolean toAccessPanCard=false;

if(age>=18){

    if(adharCard!=null){
     toAccessPanCard=true;
        getAdharCard(adharCard);
         return toAccessPanCard;

 }
   else{

   System.out.println(" Age less than 18 cannot get Pan Card");
 }

  }
    else{

    System.out.println("Get PanCard");
}

   return toAccessPanCard;
}
  public static void getAdharCard(String[] adharCard){

  for(int i=0;i<adharCard.length;i++){

  System.out.println(adharCard[i]);
}
}
}