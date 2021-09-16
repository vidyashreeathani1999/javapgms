class PanCardUtil{

public static String[] adharCard={"Vidyashree","9463758239","123445","1234 5678 9012"};
public static void main(String a[]){

boolean toAccessPanCard=PanCard.allow(adharCard);
System.out.println(toAccessPanCard);
}
} 