package com.xwork.dao.email;

public class SearchByIn implements EmailSearch{

	@Override
	public boolean expression(String arg1, String arg2) {
		String ma=arg1.substring(arg1.length()-2,arg1.length());
		if(arg1.equalsIgnoreCase(arg2)) {
			
		return true;
		}
		return false;
	}

}
