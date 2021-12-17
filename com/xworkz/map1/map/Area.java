package com.xworkz.map1.map;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Area {
public static void main(String[] args) {
	Map<String, Integer> areaOfDimensionMap=new TreeMap<String,Integer>((a1,a2)->a2.compareTo(a1));
	
	areaOfDimensionMap.put("Mantri square",93000 );
	areaOfDimensionMap.put("Phoenix", 93000);
	areaOfDimensionMap.put("Lotus", 56000);
	areaOfDimensionMap.put("Orion", 79000);
	areaOfDimensionMap.put("Forum Fiza", 61000);
	areaOfDimensionMap.put("VR", 56000);
	areaOfDimensionMap.put("Park Square", 37000);
	areaOfDimensionMap.put("Garuda", 26000);
	areaOfDimensionMap.put("UB City", 7900);
	areaOfDimensionMap.put("Mak", 7800);
	
	System.out.println("List of Areas");
	Set<String> keys=areaOfDimensionMap.keySet();
	keys.forEach((e)->System.out.println(e));
	
	System.out.println("=======================");
	System.out.println("List of Dimensions");
	Collection<Integer> values=	areaOfDimensionMap.values();
	values.forEach((v)->System.out.println(v));
	
	System.out.println("======================");
	System.out.println("List of Area and Dimensions");
	Set<Map.Entry<String,Integer>> entrySet=areaOfDimensionMap.entrySet();
	entrySet.forEach((entry)->System.out.println(entry.getKey()+" "+entry.getValue()));
	
	System.out.println("======================");
	System.out.println("List of Area and Dimensions in Decending order");
	Iterator<Map.Entry<String, Integer>> itr=entrySet.iterator();
	while(itr.hasNext()) {
		Map.Entry<String, Integer> entry=itr.next();
		System.out.println(entry.getKey());
		System.out.println(entry.getValue());
	}
	}
}
