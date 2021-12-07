package com.xwork.dao.gym;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class GYMDAO {

private Collection<String> gymNameCollection =new ArrayList<String>();
	
	public boolean save(String gymName) {
		Iterator itr=gymNameCollection.iterator();
		return  gymNameCollection.add(gymName);	
		
		}
		
	
	public boolean find(String name) {
		
		Iterator<String> itr=gymNameCollection.iterator();
		while (itr.hasNext()) {
			String tempName = itr.next();
			if(tempName.equals(name)) {
				return true;
			}
		return gymNameCollection.contains(name);
		
	}
		return false;
	}
		
	
	public boolean findByCaseInsensitive(String name) {
		Iterator<String> itr=gymNameCollection.iterator();
		while (itr.hasNext()) {
			String tempName = itr.next();
			if(tempName.equalsIgnoreCase(name)) {
				return true;
			}
			
		}
		return false;
	}
	
	
	
	public boolean findByCaseInsensitiveAndTrimmed(String name) {
		Iterator<String> itr=gymNameCollection.iterator();
		while (itr.hasNext()) {
			String tempName = itr.next();
			if(tempName.trim() != null) {
				return true;
			}
		}
		return false;
		
	}
	
}
