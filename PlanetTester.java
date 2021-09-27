class PlanetTester{

public static void main(String a[]){

Planets planet=new Planets();
planet.planetName="Earth";
planet.color="Blue";

planet.gravitation();
planet.displayPlanetDetails();


Planets planet1=new Planets();
planet1.planetName="Mercury";
planet1.color="Dark gray";

planet1.gravitation();
planet1.displayPlanetDetails();
}
}