class ProgramimgLanguages{

	static String[] programimgLanguages={"Java","C",".Net","Python"};

	
	static String programLanguage="C++";
	
	public static void main(String a[]){
	System.out.println("Main method is started");
	getProgramimgLanguages(programimgLanguages);
	
	String programimgLang=getProgramimgLanguages(programLanguage);
	System.out.println(programimgLang);
	
	}
	
	

	public static void getProgramimgLanguages(String[] ProgramimgLanguages){
	System.out.println("Name of ProgramimgLanguages");
	for(int i=0;i<programimgLanguages.length; i++)
	System.out.println(programimgLanguages[i]);
	}
	
	

	
	public static String getProgramimgLanguages(String ProgramimgLanguages){
	System.out.println("Inside the main method programimg languages added");
	return programLanguage;
	}
	
}