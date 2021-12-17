package com.xworkz.map1.map;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Month {
public static void main(String[] args) {
  
	Map<String,Integer> monthOfDaysMap=new TreeMap<String,Integer>((e1,e2)->e1.compareTo(e2));
	
	monthOfDaysMap.put("January", 31);
	monthOfDaysMap.put("Februvary", 29);
	monthOfDaysMap.put("March", 31);
	monthOfDaysMap.put("April", 30);
	monthOfDaysMap.put("May", 31);
	monthOfDaysMap.put("June", 30);
	monthOfDaysMap.put("July", 31);
	monthOfDaysMap.put("August", 31);
	monthOfDaysMap.put("September", 30);
	monthOfDaysMap.put("October", 31);
	
	System.out.println("List of month");
	Set<String> keys=monthOfDaysMap.keySet();
	keys.forEach((e)->System.out.println(e));
	
	System.out.println("====================");
	System.out.println("List of days");
	Collection<Integer> values=monthOfDaysMap.values();
	values.forEach((a)->System.out.println(a) );
	
	System.out.println("=======================");
	System.out.println("List of month and days");
	Set<Map.Entry<String, Integer>> entrySet=monthOfDaysMap.entrySet();
	entrySet.forEach((entry)->System.out.println(entry.getKey()+" "+entry.getValue()));
	
	System.out.println("====================");
	System.out.println("List of Month and Days in Acending Order");
	Iterator<Map.Entry<String,Integer>> itr=entrySet.iterator();
	while(itr.hasNext()) {
		Map.Entry<String, Integer> entry=itr.next();
		System.out.println(entry.getKey());
		System.out.println(entry.getValue());
}
}
}