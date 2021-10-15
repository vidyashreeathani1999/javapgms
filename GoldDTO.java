class GoldDTO{

int goldId;
String weight;
int price;

public void getDetailsOfGold(){
System.out.println(getGoldId()+" "+getWeight()+" "+getPrice());
}

public int getGoldId(){
return goldId;
}

public void setGoldId(int goldId){
this.goldId=goldId;
}

public String getWeight(){
return weight;
}

public void setWeight(String weight){
this.weight=weight;
}

public int getPrice(){
return price;
}

public void setPrice(int price){
this.price=price;
}

@Override
public int hashCode(){
return price;
}
}