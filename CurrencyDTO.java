class CurrencyDTO{

public CurrencyDTO(){
System.out.println("Currency object is created");
}

private String currencyName;
private int amount;

public String getCurrencyName(){
return currencyName;
}

public void setCurrencyName(String currencyName){
this.currencyName=currencyName;
}

public int getAmount(){
return amount;
}

public void setAmount(int amount){
this.amount=amount;
}

@Override
public String toString(){
return "CurrencyDTO-{currencyName="+this.currencyName+",amount="+this.amount+"}";
}
}