package com.xworkz.phoneApp;

import com.xworkz.phoneApp.dto.ContactsDTO;
import java.util.*;
public class PhoneAppTester {

	
		
		public static void main(String a[]){


		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size");
		int size = sc.nextInt();

		PhoneApp phone = new PhoneApp(size);
		if(size>0) {
		for(int i=0;i<size;i++){

	    ContactsDTO dto = new ContactsDTO();

		System.out.println("Enter the Contacts Details");
		System.out.println("Enter the ContactId");
		int contactId=sc.nextInt();
		System.out.println("Enter the ContactName");
		String contactName=sc.next();
		System.out.println("Enter the ContactNo");
		long contactNo=sc.nextLong();
		System.out.println("Enter the Email");
		String email=sc.next(); 
		

		dto.setContactId(contactId);
		dto.setContactName(contactName);
		dto.setContactNo(contactNo);
		dto.setEmail(email);

		boolean isAdded=phone.addContactDetails(dto);
		System.out.println("contactAdded:"+isAdded);
		}

		phone.getAllContacts();
		
		
		int choice;
		String text;
		do {
		System.out.println("Press 1 to get all contacts ");	
		System.out.println("Press 2 to get Contact Name");
		System.out.println("Press 3 to get Contact No");
		System.out.println("Press 4 to get contact Id");
		System.out.println("Enter your choice :-");
		choice=sc.nextInt();
		
		 
		switch(choice) {
		case 1: phone.getAllContacts();
		  break;
		  
		case 2:System.out.println("Enter the contact Name");
		ContactsDTO dto=phone.getContactsByContactName(sc.next());
		    	 if(dto!=null) {
		    		 System.out.println(dto);
		    		 
		    	 }
		    	 else {
		    		 System.out.println("No contact found by Name");
		    	 }
		    	 break;
		    	 
		case 3:System.out.println("Enter the contact by No");
		ContactsDTO dto1=phone.getContactsByContactNO(sc.nextInt());
		       if(dto1!=null) {
		    	   System.out.println(dto1);
		       }
		       else {
		    	   System.out.println("No contact found by contactNo");
		       }
		       break;
		case 4:System.out.println("Enter the contact by Id");
		ContactsDTO dto2=phone.getContactsByContactId(sc.nextInt());
		       if(dto2!=null) {
		    	   System.out.println(dto2);
		       }
		       else {
		    	   System.out.println("No contact found by Id");
		       }
		       
		       default:
		    	 System.out.println("invalid Choice");
		}
		       System.out.println("do want continue press y/n");
		       text=sc.next();
		       
		}  
		       while(text.equals("y"));
		
		System.out.println("Enter the contact id and contact No to update");
		int contactId=sc.nextInt();
		long contactNo=sc.nextLong();
		phone.updateContactIdByContactNo(contactNo, contactId);

	     phone.getAllContacts();

		System.out.println("Enter contact Id to delete");
		int id1=sc.nextInt();
		phone.deleteContactByContactId(id1);
		phone.getAllContacts();
		}

		}
	}