class ElectionUtil{

public static String[] voterid={"Vidyashree","F","23"};
public static void main(String a[]){

boolean allowed=Election.allow(voterid);
System.out.println(allowed);
}
} 

