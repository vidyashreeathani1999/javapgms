class Exam{
public static String universityName="VTU";
public  static int fees=1350;



public static boolean allow(String[] hallTicket){
System.out.println("Inside allow method");
boolean allowedToWriteExam=false;

if(fees>1000){
    
System.out.println("Fees is paid allow the exam");
System.out.println(hallTicket);
     
          if(hallTicket!=null){
                  
                  allowedToWriteExam=true;
                  getHallTicketDetails(hallTicket);
			System.out.println("Allowed to Write Exam");
	          return allowedToWriteExam;
                   }
	           else{
               System.out.println(" No HallTicket cannot allow to write exam");
                    }

        }
else{
            System.out.println("Gube..please pay the fees");
    }    


return allowedToWriteExam;
}
   
public static void getHallTicketDetails(String[] hallTicket){

for(int i=0;i<hallTicket.length;i++){
System.out.println(hallTicket[i]);
}
}
}