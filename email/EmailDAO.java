package com.xwork.dao.email;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class EmailDAO{

private Collection<String> emailCollection =new ArrayList<String>();

	
	public boolean save(String emailName) {
		Iterator itr=emailCollection.iterator();
		
		return  emailCollection.add(emailName);
		
	}
	
	public boolean find(EmailSearch search, String name) {
			
		Iterator<String> itr=this.emailCollection.iterator();
		while (itr.hasNext()) {
			String tempName = itr.next();
			
			if(search.expression(tempName, name)) {
				return true;
			}
		
	}
		return false;
	}

	
}
