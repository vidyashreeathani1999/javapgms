package com.xworkz.bank;

import com.xworkz.bank.dto.AccountDTO;

public class Bank {

	

	
		public AccountDTO []account;
		  private int index;
		  
		  
	  
		public Bank(int size){
		  account=new AccountDTO[size];
		  
		}
		

		public boolean addAccountDetails(AccountDTO cast){
		boolean accountAdded=false;
		System.out.println("inside add account details");
		if(account!=null){
		  this.account[index++]=cast;
		 
		  accountAdded=true;
		}

		else{
		System.out.println("No account added");
		return accountAdded=false;
		}
		return accountAdded;
		}

		public void getAllAccounts(){
		for(int i=0;i<account.length;i++){
		System.out.println(account[i]);
		}
		}
		
		
		public AccountDTO getAccountById(int accountId){
			AccountDTO accountDTO=null;
			System.out.println("inside get account by account id");
			if(accountId!=0){
			   for(int i=0;i<account.length;i++){
			     if(account[i].getAccountId()==(accountId)){
			System.out.println("Account found by Id:"+accountId);
			  accountDTO=account[i];
			     }
			  
			else{
			System.out.println("No Account Found by Id:"+accountId);
			}
			   }
			}
			return accountDTO;
			}
		

		public AccountDTO getAccountByName(String accountName){
			AccountDTO accountDTO=null;
		System.out.println("inside get account by name");
		if(accountName!=null){
		   for(int i=0;i<account.length;i++){
		     if(account[i].getAccountName().equals(accountName)){
		System.out.println("Account found by accountName:"+accountName);
		 accountDTO=account[i];
		     }
		  
		else{
		System.out.println("No Account Found by accountName:"+accountName);
		}
		   }
		}
		return accountDTO;
		}

		public void updateAccountIdByAccountName(String accountName,int accountId){
		System.out.println("inside update account id by account name ");
		if(accountId>0&&accountName!=null){
		   for(int i=0;i<account.length;i++){
		     if(account[i].getAccountId()==(accountId)){
		System.out.println("Account name updated by:"+accountName);
		   account[i].setAccountName(accountName);
		     }
		  }
		}

		else{
		System.out.println("AccountName not updated");
		}
		}

	    public void deleteAccountById(int accountId){
		System.out.println("Inside delete account by id");
		if(accountId > 0){
		for(int i=0; i<account.length; i++){
		if(account[i].getAccountId()==(accountId)){
		System.out.println("Account deleted by id : "+accountId);
		account[i].setAccountId(accountId);
		}
		}
		}
		else
		{
		System.out.println("Account is not deleted");
		}
		
		}
	}
		
		
		
		
		
		
		







