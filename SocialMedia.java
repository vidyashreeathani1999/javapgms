class SocialMedia{

	static String[] apps={"FaceBook","Instagram","Whatsapp","Telegram","Snapchat","Linked In"};

	
	static String app="Twitter";
	
	public static void main(String a[]){
	System.out.println("Main method is started");
	getApps(apps);
	
	}
	
	public static void getApps(String[] apps){
	System.out.println("Name of Apps");
	for(int i=0;i<apps.length; i++)
	System.out.println(apps[i]);
	}
	
}