class SuperMarket{

	static String[] soaps={"Medimix","Himalaya","Mysore","Vaadi herbals"};

	static String[] detergent={"Neerma","Surf excel","Tide","Wheel","Ariel","Rin"};
	static String soap="Dove";
	
	public static void main(String a[]){
	System.out.println("Main method is started");
	getSoaps(soaps);
	getDetergents(detergent);
	String soa=getSoaps(soap);
	System.out.println(soa);
	
	}
	
	

	public static void getSoaps(String[] soaps){
	System.out.println("Name of soaps");
	for(int i=0;i<soaps.length; i++)
	System.out.println(soaps[i]);
	}
	
	

	public static void getDetergents(String[] detergent){
	System.out.println("Name of detergent");
	for(int i=0;i<detergent.length; i++)
	System.out.println(detergent[i]);
	}

	public static String getSoaps(String soaps){
	System.out.println("Inside the main method soaps added");
	return soap;
	}
	
}