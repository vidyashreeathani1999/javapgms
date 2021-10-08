class BankTester{

public static void main(String a[]){

Bank bank= new BandhanBank();
BandhanBank bandhanBank=(BandhanBank)bank;
bank.provideLoans(7.9);
System.out.println(bank);

Bank bank1= new KaveriBank();
KaveriBank kaveriBank=(KaveriBank)bank1;
bank1.provideLoans(6.6);
System.out.println(bank1);

Bank bank2= new ApnaBank();
ApnaBank apnaBank=(ApnaBank)bank2;
bank2.provideLoans(8.9);
System.out.println(bank2);

Bank bank3= new DenaBank();
DenaBank denaBank=(DenaBank)bank3;
bank3.provideLoans(5.3);
System.out.println(bank3);

Bank bank4= new SBIBank();
SBIBank sbiBank=(SBIBank)bank4;
bank4.provideLoans(4.6);
System.out.println(bank4);

Bank bank5= new ICICIBank();
ICICIBank iciciBank=(ICICIBank)bank5;
bank5.provideLoans(7.8);
System.out.println(bank5);
}
}
