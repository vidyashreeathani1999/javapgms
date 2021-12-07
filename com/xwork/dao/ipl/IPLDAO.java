package com.xwork.dao.ipl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IPLDAO {

private Collection<String> teamNameCollection =new ArrayList<String>();
	
	public boolean save(String teamName) {
		Iterator itr=teamNameCollection.iterator();
		
		return  teamNameCollection.add(teamName);
		
	}
	
	public boolean find(String name) {
		
		Iterator<String> itr=teamNameCollection.iterator();
		while (itr.hasNext()) {
			String tempName = itr.next();
			if(tempName.equals(name)) {
				return true;
			}
		return teamNameCollection.contains(name);
		
	}
		return false;
	}
		
	
	public boolean findByCaseInsensitive(String name) {
		Iterator<String> itr=teamNameCollection.iterator();
		while (itr.hasNext()) {
			String tempName = itr.next();
			if(tempName.equalsIgnoreCase(name)) {
				return true;
			}
			
		}
		return false;
	}
	
	
	
	public boolean findByCaseInsensitiveAndTrimmed(String name) {
		Iterator<String> itr=teamNameCollection.iterator();
		while (itr.hasNext()) {
			String tempName = itr.next();
			if(tempName.trim() != null) {
				return true;
			}
		}
		return false;
		
	}
	
}
