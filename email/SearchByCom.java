package com.xwork.dao.email;

public class SearchByCom implements EmailSearch{

	@Override
	public boolean expression(String arg1, String arg2) {
		
			System.out.println("Invoked Case in-sensitive");
			String ma=arg1.substring(arg1.length()-3,arg1.length());
			if(arg1.equalsIgnoreCase(arg2)) {
				
			return true;
		
	}

		return false;
	}

	
}