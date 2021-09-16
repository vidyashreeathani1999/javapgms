import java.util.Scanner;

class ExamUtil{
static String[] hallTicket= new String[3];


public static void main(String a[]){
Scanner sc=new Scanner(System.in);
System.out.println("Enter the candidate Name");
String candidateName = sc.next();

System.out.println("Enter the USN No");
String usnNo = sc.next();

System.out.println("Enter the Subject");
String subjectName = sc.next();

hallTicket[0]= candidateName;
hallTicket[1]= usnNo;
hallTicket[2]= subjectName;



System.out.println("main method started");
boolean allowed = Exam.allow(hallTicket);
System.out.println(allowed);
System.out.println("main method ended");
}

}