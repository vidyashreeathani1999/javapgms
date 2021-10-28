package com.xworkz.bank.dto;

public class AccountDTO {

	
		public AccountDTO(){
			System.out.println(this.getClass().getSimpleName()+"object created");
			}

			   private int accountId;
			   private String accountName;
			  
			   
			   public void setAccountId(int accountId){
					this.accountId=accountId;
					}

				public int getAccountId(){
					return accountId;
					}

				public void setAccountName(String accountName){
					this.accountName=accountName;
					}

				public String getAccountName(){
					return accountName;
					}
				
				
				@Override
				public String toString(){
	return"AccountDTO-{accountId="+this.accountId+",accountName="+this.accountName+"}";
				}
				}

			   








