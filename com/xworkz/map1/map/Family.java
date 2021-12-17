package com.xworkz.map1.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Family {

	public static void main(String[] args) {
		//Map<String, Integer> familyMemberMap=new HashMap<String, Integer>();
		
		//Decending Order
		Map<String, Integer> familyMemberMap=new TreeMap<String, Integer>((e1, e2)->e2.compareTo(e1));
		
		familyMemberMap.put("Vidyashree", 11);
		familyMemberMap.put("Aishwary", 5);
		familyMemberMap.put("Sanjana", 5);
		familyMemberMap.put("Ganga", 7);
		familyMemberMap.put("Susmita", 4);
		familyMemberMap.put("Basavaraj", 4);
		familyMemberMap.put("Tejashwini", 3);
		familyMemberMap.put("Sambruddi", 3);
		familyMemberMap.put("Vishalaxi", 6);
		familyMemberMap.put("Paddamavati", 8);
		
		//abstraction
		//get only keys , get only values or both
	    System.out.println("List of keys");
		Set<String> keys=familyMemberMap.keySet();
		keys.forEach((v)->System.out.println(v));
		
		System.out.println("========================");
		 System.out.println("List of valuess");
		Collection<Integer> values=familyMemberMap.values();
		values.forEach((l)->System.out.println(l));
		
		System.out.println("========================");
		 System.out.println("List of keys and values");
		Set<Map.Entry<String, Integer>> entrySet=familyMemberMap.entrySet();
		entrySet.forEach((entry)->System.out.println(entry.getKey()+" "+entry.getValue()));
		
		Iterator<Map.Entry<String, Integer>> itr=entrySet.iterator();
		System.out.println("========================");
		 System.out.println("Keys and values in decending order");
		while(itr.hasNext()) {
			Map.Entry<String, Integer> entry=itr.next();
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			
			
		/*	//Assending Order
			Map<String, Integer> familyMemberMap1=new TreeMap<String, Integer>((e1, e2)->e1.compareTo(e2));
			
			familyMemberMap1.put("Vidyashree", 11);
			familyMemberMap1.put("Aishwary", 5);
			familyMemberMap1.put("Sanjana", 5);
			familyMemberMap1.put("Ganga", 7);
			familyMemberMap1.put("Susmita", 4);
			familyMemberMap1.put("Basavaraj", 4);
			familyMemberMap1.put("Tejashwini", 3);
			familyMemberMap1.put("Sambruddi", 3);
			familyMemberMap1.put("Vishalaxi", 6);
			familyMemberMap1.put("Paddamavati", 8);
			
			Iterator<Map.Entry<String, Integer>> itr1=entrySet.iterator();
			System.out.println("========================");
			 System.out.println("Keys and values in Acending order");
			while(itr1.hasNext()) {
				Map.Entry<String, Integer> entry1=itr1.next();
				System.out.println(entry1.getKey());
				System.out.println(entry1.getValue());
		}*/
			
			
	}
}
}