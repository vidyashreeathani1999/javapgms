package com.xworkz.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Planet {

	public static void main(String[] args) {
     Map map=new HashMap();
		
		map.put("Mercury", 0);
		map.put("Venus", 0);
		map.put("Earth", 1);
		map.put("Mars",2);
		map.put("Jupiter",79);
		map.put("Saturn",82);
		map.put("Uranus",27);
		map.put("Neptune",14);
		
		System.out.println(map.size());
	
	     
		System.out.println(map.get("Earth"));
		
		boolean contains=map.containsKey("Pluto");
		System.out.println(contains);
		
		contains=map.containsValue(82);
		System.out.println(contains);
		
		System.out.println(map);
		Set<String> keys=map.keySet();
		keys.forEach((a)->{
			System.out.println(a);
		});
	}
}
