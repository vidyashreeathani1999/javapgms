class Exam{
	public static String universityName;
	public  static int fees;

	public Exam(String name, int fs){
	System.out.println("Exam Object is created");
	
	universityName=name;
	fees=fs;

	}
public static void main(String a[]){
Exam exam=new Exam("VTU",1350);
System.out.println(exam.universityName+" "+exam.fees);
	


}
}