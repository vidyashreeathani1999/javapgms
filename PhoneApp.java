package com.xworkz.phoneApp;

import com.xworkz.phoneApp.dto.ContactsDTO;

public class PhoneApp {

	
	  		public ContactsDTO[] contact;
			  private int index;
			  
			  
		      
			public PhoneApp(int size){
			  contact=new ContactsDTO[size];
			  
			}

			public boolean addContactDetails(ContactsDTO contact){
			boolean contactAdded=false;
			System.out.println("inside add contact details");
			if(contact!=null){
			  this.contact[index++]=contact;
			  contactAdded=true;
			}

			else{
			System.out.println("No contact added");
			return contactAdded=false;
			}
			return contactAdded;
			}

			public void getAllContacts(){
			for(int i=0;i<contact.length;i++){
			System.out.println(contact[i]);
			}
			}
			
			
			public ContactsDTO getContactsByContactId(int contactId){
				ContactsDTO contactsDTO=null;
				System.out.println("inside get contact by contactId");
				if(contactId!=0){
				   for(int i=0;i<contact.length;i++){
				     if(contact[i].getContactId()==(contactId)){
				System.out.println("Contact found by Id:"+contactId);
				contactsDTO=contact[i];
				     }
				  
				else{
				System.out.println("No contact Found by Id:"+contactId);
				}
				   }
				}
				return contactsDTO;
				}

			public ContactsDTO getContactsByContactName(String contactName){
				ContactsDTO contactsDTO=null;
			System.out.println("inside get contact by name");
			if(contactName!=null){
			   for(int i=0;i<contact.length;i++){
			     if(contact[i].getContactName().equals(contactName)){
			System.out.println("Contact found by Name:"+contactName);
			contactsDTO=contact[i];
			     }
			  
			else{
			System.out.println("No contact Found by Name:"+contactName);
			}
			   }
			}
			return contactsDTO;
			}

			public ContactsDTO getContactsByContactNO(long contactNo){
				ContactsDTO contactsDTO=null;
			System.out.println("inside get contact by name");
			if(contactNo!=0){
			   for(int i=0;i<contact.length;i++){
			     if(contact[i].getContactNo()==(contactNo)){
			System.out.println("Contact found by Name:"+contactNo);
			contactsDTO=contact[i];
			     }
			  
			else{
			System.out.println("No contact Found by Name:"+contactNo);
			}
			   }
			}
			return contactsDTO;
			}

			public ContactsDTO getContactsByEmail(String email){
				ContactsDTO contactsDTO=null;
				System.out.println("inside get conatct by email");
				if(email!=null){
				   for(int i=0;i<contact.length;i++){
				     if(contact[i].getEmail().equals(email)){
				System.out.println("Contact found by email:"+email);
				contactsDTO=contact[i];
				     }
				  
				else{
				System.out.println("No contact Found by contactNo:"+email);
				}
				   }
				}
				return contactsDTO;
				}
			
			
		     
		    
		public void updateContactIdByContactNo(long contactNo,int contactId){
			System.out.println("inside update contactNo by id ");
			if(contactId>0&&contactNo!=0){
			   for(int i=0;i<contact.length;i++){
			     if(contact[i].getContactId()==(contactId)){
			System.out.println("contact contact no is updated by:"+contactNo);
			contact[i].setContactNo(contactNo);
			     }
			  }
			}

			else{
			System.out.println("Contact contact no is not updated");
			}
			}

		public void deleteContactByContactId(int contactId){
			System.out.println("Inside delete contact by id");
			if(contactId > 0){
			for(int i=0; i<contact.length; i++){
			if(contact[i].getContactId()==(contactId)){
			System.out.println("contact deleted by id : "+contactId);
			contact[i].setContactId(contactId);
			}
			}
			}
			else
			{
			System.out.println("Contact is not deleted");
			}
			
			}
		}
			
			
			
			
			
			
			

