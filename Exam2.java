//Method over loading

class Exam2{
	public static String universityName="VTU";
	public  static int fees=1350;



	public static void allow(String[] hallTicket){
	System.out.println("Start of allow method with Hallticket");


          if(hallTicket!=null){
                  
                  getHallTicketDetails(hallTicket);
			}
	           else{
               System.out.println(" No HallTicket cannot allow to write exam");
                    }
		System.out.println("End of allow method with Hallticket");
		}


        

 	public static void allow(int fees){
	
	System.out.println("Start of allow method with fees");
	if(fees>1000){
	System.out.println(fees);
	}
	else{
            System.out.println("Gube..please pay the fees");
		}
	System.out.println("End of allow method with fees");

            }    



	public static void getHallTicketDetails(String[] hallTicket){

	for(int i=0;i<hallTicket.length;i++){
	System.out.println(hallTicket[i]);
}
}
}




   
	
