package com.xworkz.phoneApp.dto;

public class ContactsDTO {

		
		public ContactsDTO(){
			System.out.println(this.getClass().getSimpleName()+"object created");
			}

		private int contactId;
		private String contactName;
		private long contactNo;
		private String email;
		
		
		public void setContactId(int contactId){
		this.contactId=contactId;
		}

		public int getContactId(){
		return contactId;
		}

		public void setContactName(String contactName){
		this.contactName=contactName;
		}

		public String getContactName(){
		return contactName;
		}
		
		public void setContactNo(long contactNo){
			this.contactNo=contactNo;
			}

			public long getContactNo(){
			return contactNo;
			}

		public void setEmail(String email){
			this.email=email;
			}

			public String getEmail(){
			return email;
			}

			
		@Override
		public String toString() {
			return "ContactDTO-[ContactId=" +this.contactId + ", ContactName=" +this.contactName + ",ContactNo="+this.contactNo+",Email="+this.email+"}";
		}

		}
