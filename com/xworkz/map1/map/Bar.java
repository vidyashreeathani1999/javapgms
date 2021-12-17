package com.xworkz.map1.map;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Bar {
public static void main(String[] args) {
	Map<String,Integer> barOfBrandMap=new TreeMap<String,Integer>((e1,e2)->e1.compareTo(e2));
	
	barOfBrandMap.put("My favorite", 10);
	barOfBrandMap.put("raise a Glass", 11);
	barOfBrandMap.put("Cheers and Beers", 9);
	barOfBrandMap.put("Neon Nights", 9);
	barOfBrandMap.put("Drinks after work", 6);
	barOfBrandMap.put("Cocktail Country", 12);
	barOfBrandMap.put("The meeting place", 11);
	barOfBrandMap.put("Trendy Tavern", 12);
	barOfBrandMap.put("Time for drinks", 33);
	barOfBrandMap.put("One for the Road", 13);
	
	System.out.println("List of Bar");
	Set<String> keys=barOfBrandMap.keySet();
	keys.forEach((e)->System.out.println(e));
	
	System.out.println("====================");
	System.out.println("List of Brands");
	Collection<Integer> values=barOfBrandMap.values();
	values.forEach((a)->System.out.println(a) );
	
	System.out.println("====================");
	System.out.println("List of bar and brand");
	Set<Map.Entry<String, Integer>> entrySet=barOfBrandMap.entrySet();
	entrySet.forEach((entry)->System.out.println(entry.getKey()+" "+entry.getValue()));
	
	System.out.println("===================");
	System.out.println("List of Bar and Brands in AcendingOrder");
	Iterator<Map.Entry<String,Integer>> itr=entrySet.iterator();	
	while(itr.hasNext()) {
		Map.Entry<String,Integer> entry=itr.next();
		System.out.println(entry.getKey());
		System.out.println(entry.getValue());
	}
	
	
}
}
