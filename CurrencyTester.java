class CurrencyTester{

public static void main(String args[]){

CurrencyDTO currency=new CurrencyDTO();
currency.setCurrencyName("Airtel");
currency.setAmount(599);

System.out.println(currency);

CurrencyDTO currency1=new CurrencyDTO();
currency1.setCurrencyName("Jio");
currency1.setAmount(555);

System.out.println(currency1);
}
}