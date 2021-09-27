class City{

public String cityName;
public String famousFor;

public City(){
System.out.println("City object is created");
}

public void famous(){
System.out.println("This city is famous for...");
}

public void displayCityDetails(){
System.out.println(cityName+" "+famousFor);
}
}