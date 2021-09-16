class SpeakerUtil1{
public static void main(String a[]){
boolean isConnected = Speaker.onOrOff();
boolean connected=Speaker.onOrOff();

System.out.println("The Speaker is connected:"+isConnected);
Speaker.increaseVolume();
Speaker.increaseVolume();
Speaker.decreaseVolume();
Speaker.decreaseVolume();

}
}