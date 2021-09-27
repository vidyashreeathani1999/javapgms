class Weather{

public String countryName;
public String weatherType;

public Weather(){
System.out.println("Weather object is created");
}

public void sense(){
System.out.println("Sensing Weather..");
}

public void displayWeatherDetails(){
System.out.println(countryName+" "+weatherType);
}
}