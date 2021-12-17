package com.xworkz.map1.map;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class State {
public static void main(String[] args) {
	
	Map<String, Integer> stateOfDistrictMap=new TreeMap<String,Integer>((a1,a2)->a1.compareTo(a2));
	
	stateOfDistrictMap.put("Karnataka",30);
	stateOfDistrictMap.put("Jammu andKashmir",22);
	stateOfDistrictMap.put("Punjab",22);
	stateOfDistrictMap.put("Rajasthan",33);
	stateOfDistrictMap.put("Manipur",16);
	stateOfDistrictMap.put("Kerala",14);
	stateOfDistrictMap.put("Haryana",22);
	stateOfDistrictMap.put("Gujarat",33);
	stateOfDistrictMap.put("Assam",33);
	stateOfDistrictMap.put("Bihar",38);
	
	System.out.println("List of Districts");
	Set<String> keys=stateOfDistrictMap.keySet();
	keys.forEach((v)->System.out.println(v));
	
	System.out.println("========================");
	 System.out.println("List of states");
	Collection<Integer> values=stateOfDistrictMap.values();
	values.forEach((l)->System.out.println(l));
	
	System.out.println("========================");
	 System.out.println("List of states and districts");
	Set<Map.Entry<String, Integer>> entrySet=stateOfDistrictMap.entrySet();
	entrySet.forEach((entry)->System.out.println(entry.getKey()+" "+entry.getValue()));
	
	Iterator<Map.Entry<String, Integer>> itr=entrySet.iterator();
	System.out.println("========================");
	 System.out.println("States and districts in acending order");
	while(itr.hasNext()) {
		Map.Entry<String, Integer> entry=itr.next();
		System.out.println(entry.getKey());
		System.out.println(entry.getValue());
		
	}
}
}
