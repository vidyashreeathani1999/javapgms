class ContinentsDTO{

public ContinentsDTO(){
System.out.println("Continent object is created");
}

private String continentName;
private int continentId;
private String capital;

public String getContinentName(){
return continentName;
}

public void setContinentName(String continentName){
this.continentName=continentName;
}

public String getCapital(){
return capital;
}

public void setCapital(String capital){
this.capital=capital;
}

public int getContinentId(){
return continentId;
}

public void setContinentId(int continentId){
this.continentId=continentId;
}

@Override
public String toString(){
return "ContinentsDTO-{continentId="+this.continentId+",continentName="+this.continentName+",capital="+this.capital+"}";
}
}
