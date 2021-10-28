package com.xworkz.bank;
import java.util.*;

import com.xworkz.bank.dto.AccountDTO;
public class BankTester {

	
		public static void main(String a[]){


			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the size");
			int size = sc.nextInt();

			Bank bank = new Bank(size);
			if(size>0) {
			for(int i=0;i<size;i++){

			AccountDTO dto = new AccountDTO();

			System.out.println("Enter the Account Details");
			System.out.println("Enter the accountId");
			int accountId=sc.nextInt();
			System.out.println("Enter the accountName");
			String accountName=sc.next();
			
			dto.setAccountId(accountId);
			dto.setAccountName(accountName);
			

			boolean isAdded=bank.addAccountDetails(dto);
			System.out.println("AccountAdded:"+isAdded);
			}

			bank.getAllAccounts();
			
			
			int choice;
			String text;
			do {
			System.out.println("Press 1 to get all accounts ");	
			System.out.println("Press 2 to get account Name");
			System.out.println("Press 3 to get account Id");
			System.out.println("Enter your choice :-");
			choice=sc.nextInt();
			
			 
			switch(choice) {
			case 1:bank.getAllAccounts();
			  break;
			  
			case 2:System.out.println("Enter the accountName");
			    	AccountDTO dto=bank.getAccountByName(sc.next());
			    	 if(dto!=null) {
			    		 System.out.println(dto);
			    		 
			    	 }
			    	 else {
			    		 System.out.println("No account found by accountName");
			    	 }
			    	 break;
			case 3:System.out.println("Enter the account by Id");
			AccountDTO dto1=bank.getAccountById(sc.nextInt());
			       if(dto1!=null) {
			    	   System.out.println(dto1);
			       }
			       else {
			    	   System.out.println("No account found by Id");
			       }
			       
			       default:
			    	 System.out.println("invalid Choice");
			}
			       System.out.println("do want continue press y/n");
			       text=sc.next();
			       
			}  
			       while(text.equals("y"));
			
			System.out.println("Enter the account id and account name to update");
			int accountId=sc.nextInt();
			String accountName=sc.next();
			bank.updateAccountIdByAccountName(accountName, accountId);

		     bank.getAllAccounts();

			System.out.println("Enter account Id to delete");
			int id1=sc.nextInt();
			bank.deleteAccountById(id1);
			bank.getAllAccounts();
			}

			}
		}




