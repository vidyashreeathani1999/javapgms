//Method OverLoading

class Operators{

	public static void main(String a[]){
	add(1,7);
	add(1,7,8);
	sub(2,1);
	sub(7,9,8);
	mul(8,6,5);
	div(8,6);
	mod(8,4);
}

 	public static void add(int a,int b){
 	System.out.println(a+b);
}

	
 	public static void add(int a,int b,int c){
 	System.out.println(a+b+c);
}	
	
	public static void sub(int a,int b){
 	System.out.println(a-b);
}
	
	public static void sub(int a,int b,int c){
 	System.out.println(a-b-c);
}
	public static void mul(int a,int b,int c){
 	System.out.println(a*b*c);
}
	public static void div(int a,int b){
 	System.out.println(a%b);
}
	public static void mod(int a,int b){
 	System.out.println(a/b);
}
}