class Speaker{

static String name="Boat";
static int minVolume=0;
static int maxVolume=15;
static boolean isConnected=false;
static int currentVolume;
	
public static boolean onOrOff()
	{
System.out.println("Start of onOrOff");
	if(isConnected==false){

	isConnected=true;
	System.out.println("Speaker is turned on..");
	return isConnected;
	}

	else if(isConnected==true){
             isConnected=false;
		System.out.println("Speaker is turned off....");
		return isConnected;
	}
	System.out.println("End of onOrOff");
	return false;

	}



	public static void increaseVolume(){

		System.out.println("Inside increaseVolume()");

			if(isConnected){

				if(currentVolume<maxVolume){

					currentVolume=currentVolume+1;
					System.out.println("The currentVolume is:"+currentVolume);
				}

				else{
					System.out.println("Max volume reached......");
					}
				}
else{
System.out.println("Gube switch on the Speaker....");
}
System.out.println("End of increaseVolume()");

}


public static void decreaseVolume(){

		System.out.println("Inside decreaseVolume()");

			if(isConnected){

				if(currentVolume>minVolume){

					currentVolume=currentVolume-1;
					System.out.println("The currentVolume is:"+currentVolume);
				}

				else{
					System.out.println("Min volume reached......");
					}
				}
else{
System.out.println("Gube switch off the Speaker....");
}

System.out.println("End of decreaseVolume()");

}
}
