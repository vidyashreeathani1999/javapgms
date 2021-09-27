class ParlimentTester{

public static void main(String a[]){

Parliment par=new Parliment();
par.memberName="Santosh";
par.partyName="BJP";
par.votes=876;

par.assembly();
par.displayParlimentDetails();

Parliment par1=new Parliment();
par1.memberName="Tarun";
par1.partyName="BJP";
par1.votes=978;

par1.assembly();
par1.displayParlimentDetails();
}
}