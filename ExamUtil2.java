
class ExamUtil2{

static String[] hallTicket= new String[3];

public static void main(String a[]){



hallTicket[0]= "candidateName";
hallTicket[1]= "usnNo";
hallTicket[2]= "subjectName";

System.out.println("main method started"); 

Exam2 exam=new Exam2();
Exam2.allow(hallTicket);
Exam2.allow(1100);

System.out.println("main method ended");
System.out.println(exam.candidateName+" "+exam.usnNo+" "+exam.subjectName);
}

}