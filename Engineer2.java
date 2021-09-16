class Engineer2{
static String branches[]=new String[4];

public static void main(String a[])
{
branches[0]="CSE";
branches[1]="E&C";
branches[2]="MECH";
branches[3]="CIV";
getBranchName();
}

public static void getBranchName()
{

System.out.println(branches.length);
for(int j=branches.length-1; j>=0; j--)
{
System.out.println(branches[j] );
}


}
}