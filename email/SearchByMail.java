package com.xwork.dao.email;

public class SearchByMail implements EmailSearch{

	@Override
	public boolean expression(String arg1, String arg2) {
	String lastThreeCh=arg1.substring(0, 1);
	if(lastThreeCh.equalsIgnoreCase(".com"));
		return false;
	}

	
	
}