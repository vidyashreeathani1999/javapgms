package com.xwork.dao.pg;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class PGDAO {

	private Collection<String> pgNameCollection =new ArrayList<String>();
	
	public boolean save(String pgName) {
		Iterator itr=pgNameCollection.iterator();
		return  pgNameCollection.add(pgName);		
	}
	
	
	public boolean find(String pgName) {
		
		Iterator<String> itr=pgNameCollection.iterator();
		while (itr.hasNext()) {
			String tempName = itr.next();
			if(tempName.equals(pgName)) {
				return true;
			}
		return pgNameCollection.contains(pgName);
		
	}
		return false;
	}
		
	
public boolean findByCaseInsensitive(String name) {
		Iterator<String> itr=pgNameCollection.iterator();
		while (itr.hasNext()) {
			String tempName = itr.next();
			if(tempName.equalsIgnoreCase(name)) {
				return true;
			}
			
		}
		return false;
}
	
	
	
	public boolean findByCaseInsensitiveAndTrimmed(String name) {
		Iterator<String> itr=pgNameCollection.iterator();
		while (itr.hasNext()) {
			String tempName = itr.next();
			if(tempName.trim() != null) {
				return true;
			}
		}
		return false;
		
	}
	
}
