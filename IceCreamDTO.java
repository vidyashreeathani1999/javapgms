class IceCreamDTO{

public IceCreamDTO(){
System.out.println("IceCream object is created");
}


private String name;
private String flavor;
private int price;

public String getName(){
return name;
}

public void setName(String name){
this.name=name;
}

public String getFlavor(){
return flavor;
}

public void setFlavor(String flavor){
this.flavor=flavor;
}

public int getPrice(){
return price;
}

public void setPrice(int price){
this.price=price;
}

@Override
public String toString(){
return "IceCreamDTO-{name="+this.name+",flavor="+this.flavor+",price="+this.price+"}";
}
}


